package com.longsheng.xueqiao.aliyun.resource.thriftapi.server.impl;


import java.util.Objects;
import java.util.Properties;

import com.longsheng.xueqiao.aliyun.resource.aliyunapi.EcsInstanceHandler;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.SynceEcsInstanceOption;
import org.apache.commons.lang.NullArgumentException;
import org.apache.thrift.TException;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.server.AliyunResourceAoServiceAdaptor;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.AddResourceTagResp;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.ResourceTag;

public class AliyunResourceAoServiceHandler extends AliyunResourceAoServiceAdaptor {
    @Override
    public int InitApp(Properties props) {
        return 0;
    }

    @Override
    protected com.longsheng.xueqiao.aliyun.resource.thriftapi.EcsInstancePage reqEcsInstance(TServiceCntl oCntl, com.longsheng.xueqiao.aliyun.resource.thriftapi.ReqEcsInstanceOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(option, "ReqEcsInstanceOption");
        checkPageOption(option.getPageOption());
        return new EcsInstanceHandler().query(option);
    }

    @Override
    protected AddResourceTagResp addResourceTag(TServiceCntl oCntl, ResourceTag resourceTag) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(resourceTag, "ResourceTag");
        return new AddResourceTagResp().setSuccess(false).setErrMsg("Permission need.");
    }

    @Override
    protected void syncEcsInstance(TServiceCntl oCntl, SynceEcsInstanceOption option) throws ErrorInfo, TException {
        checkNull(option, "option");
        new EcsInstanceHandler().sync(option);
    }

    private void checkNull(Object obj, String name) {
        if (Objects.isNull(obj)) {
            throw new NullArgumentException(name + " is null.");
        }
    }

    private void checkPageOption(IndexedPageOption pageOption) {
        if (pageOption != null) {
            if (pageOption.getPageIndex() < 0) {
                throw new IllegalArgumentException("page index must >= 0");
            }
            if (pageOption.getPageSize() > 50) {
                throw new IllegalArgumentException("page size must >= 0 && <= 50");
            }
        }
    }

    @Override
    public void destroy() {
    }
}
