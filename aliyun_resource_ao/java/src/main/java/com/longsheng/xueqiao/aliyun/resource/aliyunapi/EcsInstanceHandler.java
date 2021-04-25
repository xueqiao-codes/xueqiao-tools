package com.longsheng.xueqiao.aliyun.resource.aliyunapi;

import com.aliyuncs.ecs.model.v20140526.DescribeInstancesRequest;
import com.aliyuncs.ecs.model.v20140526.DescribeInstancesResponse;
import com.google.gson.Gson;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.*;
import net.qihoo.qconf.Qconf;
import net.qihoo.qconf.QconfException;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.hosting.machine.*;
import xueqiao.hosting.machine.dao.client.HostingMachineDaoStub;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EcsInstanceHandler {

    private static final String FULL_DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm'Z'";

    public EcsInstancePage query(ReqEcsInstanceOption option) throws ErrorInfo {
        DescribeInstancesRequest ecsRequest = map2Request(option);

        DescribeInstancesResponse ecsResponse;
        try {
            ecsResponse = AliYunApiFactory.getInstance().getDefaultClient().getAcsResponse(ecsRequest);
        } catch (Throwable e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(AliYunResourceErrorCode.REQUEST_ECS_INSTANCES_FAIL.getValue(), "request aliyun ecs fail.");
        }


        EcsInstancePage page = new EcsInstancePage();
        page.setTotal(ecsResponse.getTotalCount());
        List<EcsInstance> list = new ArrayList<>();
        for (DescribeInstancesResponse.Instance ins : ecsResponse.getInstances()) {
            EcsInstance ecsInstance = new EcsInstance();

            ecsInstance.setAliyunInstanceId(ins.getInstanceId());
            ecsInstance.setRegionId(ins.getRegionId());
            ecsInstance.setInstanceName(ins.getInstanceName());
            ecsInstance.setZoneId(ins.getZoneId());
            ecsInstance.setAliyunExpiredTimestamp(getDateTimeFullSeconds(ins.getExpiredTime()));
            ecsInstance.setInstanceChargeType(InstanceChargeType.valueOf(ins.getInstanceChargeType().toUpperCase()));
            ecsInstance.setInstanceNetworkType(InstanceNetworkType.valueOf(ins.getInstanceNetworkType().toUpperCase()));
            ecsInstance.setRunningStatus(HostingMachineRunningStatus.valueOf(ins.getStatus().toUpperCase()));

            Map<String, String> tagMap = new HashMap<>();
            for (DescribeInstancesResponse.Instance.Tag tag : ins.getTags()) {
                tagMap.put(tag.getTagKey(), tag.getTagValue());
            }
            ecsInstance.setTags(tagMap);

            if (InstanceNetworkType.VPC.equals(ecsInstance.getInstanceNetworkType())) {
                ecsInstance.setInnerIpAddress(StringUtils.join(ins.getVpcAttributes().getPrivateIpAddress(), ","));
            }

            if (ins.getPublicIpAddress().size() > 0) {
                ecsInstance.setPublicIpAddress(StringUtils.join(ins.getPublicIpAddress(), ","));
            } else if (ins.getEipAddress() != null) {
                ecsInstance.setPublicIpAddress(ins.getEipAddress().getIpAddress());
            } else {
                ecsInstance.setPublicIpAddress("");
            }


            HostingMachineSpec machineSpec = new HostingMachineSpec();
            machineSpec.setCpuCount(ins.getCpu());
            machineSpec.setMemoryGB(ins.getMemory() / 1000);
            machineSpec.setOutIfBandMB(ins.getInternetMaxBandwidthOut());
            ecsInstance.setMachineSpec(machineSpec);

            list.add(ecsInstance);
        }
        page.setPage(list);
        return page;
    }

    public void sync(SynceEcsInstanceOption option) throws TException {
        HostingMachineDaoStub stub = new HostingMachineDaoStub();
        IndexedPageOption pageIndexOption = new IndexedPageOption();
        pageIndexOption.setNeedTotalCount(true);
        pageIndexOption.setPageSize(Integer.MAX_VALUE);
        pageIndexOption.setPageIndex(0);
        HostingMachinePageResult pageResult = stub.queryHostingMachinePage(new QueryHostingMachineOption(), pageIndexOption);
        if (pageResult.getTotalNum() == 0) {
            return;
        }
        int pageSize = 20;
        int pageIndex = 0;
        do {
            ReqEcsInstanceOption reqOption = new ReqEcsInstanceOption();
            IndexedPageOption pageOption = new IndexedPageOption();
            pageOption.setPageIndex(pageIndex);
            pageOption.setPageSize(pageSize);
            pageOption.setNeedTotalCount(true);
            reqOption.setPageOption(pageOption);
            Map<String, Long> instanceMachineIdMap = new HashMap<>();
            for (HostingMachine hostingMachine : pageResult.getResultList()) {
                if (StringUtils.isNotBlank(hostingMachine.getInstanceId())) {
                    reqOption.addToInstanceIds(hostingMachine.getInstanceId());
                    instanceMachineIdMap.put(hostingMachine.getInstanceId(), hostingMachine.getMachineId());
                }
            }

            EcsInstancePage page = query(reqOption);
            for (EcsInstance instance : page.getPage()) {
                HostingMachine hostingMachine = new HostingMachine();
                hostingMachine.setMachineId(instanceMachineIdMap.get(instance.getAliyunInstanceId()));
                hostingMachine.setMachineInnerIP(instance.getInnerIpAddress());
                hostingMachine.setMachineOuterIP(instance.getPublicIpAddress());
                hostingMachine.setMachineSpec(instance.getMachineSpec());
                hostingMachine.setMachineRunningStatus(instance.getRunningStatus());
                stub.updateHostingMachine(hostingMachine);
            }

            pageIndex++;
        } while (pageIndex * pageSize < pageResult.getTotalNum());
    }

    private DescribeInstancesRequest map2Request(ReqEcsInstanceOption option) {
        DescribeInstancesRequest ecsRequest = new DescribeInstancesRequest();

        if (option.isSetPageOption()) {
            IndexedPageOption pageOption = option.getPageOption();
            ecsRequest.setPageSize(pageOption.getPageSize());
            if (pageOption.getPageSize() == 0) {
                ecsRequest.setPageSize(20);
            }
            ecsRequest.setPageNumber(pageOption.getPageIndex() + 1);
        }
        if (option.isSetInstanceIds()) {
            ecsRequest.setInstanceIds(new Gson().toJson(option.getInstanceIds()));
        }
        if (option.isSetRegionId()) {
            ecsRequest.setRegionId(option.getRegionId());
        }

        String env = null;
        try {
            env = Qconf.getConf("platform/environment");
        } catch (QconfException e) {
            AppLog.e(e.getMessage(), e);
        }
//        String env ="dev";
        if (StringUtils.isNotEmpty(env)) {
            ecsRequest.setTag1Key("VPC");
            ecsRequest.setTag1Value(env);
            ecsRequest.setTag2Key("HOSTING");
            ecsRequest.setTag2Value("true");
        }

        return ecsRequest;
    }

    private static long getDateTimeFullSeconds(String formatTime) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FULL_DATE_TIME_PATTERN);
            Date date = simpleDateFormat.parse(formatTime);
            return date.getTime() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }


}

