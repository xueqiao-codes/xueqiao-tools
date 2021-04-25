package com.longsheng.xueqiao.aliyun.resource.thriftapi.server.impl;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.ecs.model.v20140526.DescribeInstancesRequest;
import com.aliyuncs.ecs.model.v20140526.DescribeInstancesResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.longsheng.xueqiao.aliyun.resource.aliyunapi.EcsInstanceHandler;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.EcsInstancePage;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.ReqEcsInstanceOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    private static final String FULL_DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm'Z'";

    public static void main(String[] args) {


        EcsInstanceHandler handler = new EcsInstanceHandler();
        ReqEcsInstanceOption option = new ReqEcsInstanceOption();
        option.addToInstanceIds("i-uf6jf5148crpp8sx46rn");
//        option.addToInstanceIds("i-uf60tu1nzl0h7jofdrzn");
//        option.addToInstanceIds("i-uf60tu1nzl0h7hpe9q05");

        try {
            EcsInstancePage page = handler.query(option);
            print(page);
        } catch (ErrorInfo errorInfo) {
            errorInfo.printStackTrace();
        }
//        sample();

    }

    private static void sample() {
        String ak = "LTAI7Wn1YH00U2mz";
        String aks = "i7psWzrSpt7KruEbEHqnigEQjtmSWq";
        String regionId = "cn-shanghai";
        IClientProfile profile = DefaultProfile.getProfile(regionId, ak, aks);


        IAcsClient client = new DefaultAcsClient(profile);
        DescribeInstancesRequest ecsRequest = new DescribeInstancesRequest();
        ecsRequest.setPageSize(1);
        ecsRequest.setPageNumber(1);

        try {
            DescribeInstancesResponse ecsResponse = client.getAcsResponse(ecsRequest);
            print(ecsResponse.getTotalCount());
            print(ecsResponse.getPageNumber());
            print(ecsResponse.getPageSize());
            print(ecsResponse.getRequestId());
            for (DescribeInstancesResponse.Instance ins : ecsResponse.getInstances()) {
                print(ins.getInstanceName());

                print(ins.getInstanceChargeType());
                print(ins.getInstanceId());


                print(ins.getRegionId());
                print(ins.getZoneId());
                print(ins.getAutoReleaseTime());
                print(ins.getClusterId());
                print(ins.getCpu());
                print(ins.getCreationTime());
                print(ins.getDescription());
                print(ins.getExpiredTime());
                print("expired time: "+ getDateTimeFull(ins.getExpiredTime()));
                print(ins.getGPUAmount());
                print(ins.getGPUSpec());
                print(ins.getHostName());
                print(ins.getHpcClusterId());
                print(ins.getImageId());
                print(ins.getMemory());
                print(ins.getOSName());
                print(ins.getOSType());
                print(ins.getStatus());
                print(ins.getInstanceChargeType());
                print(ins.getInstanceNetworkType());
                print(ins.getPublicIpAddress());
                print(ins.getVpcAttributes().getPrivateIpAddress());

               print("InternetMaxBandwidthOut : "+ins.getInternetMaxBandwidthOut());


                for (DescribeInstancesResponse.Instance.Tag s : ins.getTags()) {
                    print("tag key: " + s.getTagKey());
                    print("tag value: " + s.getTagValue());
                }
            }
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    private static void print(Object obj) {

        System.out.println(obj);
    }

    private static long getDateTimeFull(String formatTime) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FULL_DATE_TIME_PATTERN);
            Date date = simpleDateFormat.parse(formatTime);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
