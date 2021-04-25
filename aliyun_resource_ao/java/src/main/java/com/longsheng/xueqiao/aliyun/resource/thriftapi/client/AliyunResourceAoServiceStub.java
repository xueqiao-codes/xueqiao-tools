package com.longsheng.xueqiao.aliyun.resource.thriftapi.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.soldier.platform.svr_platform.client.BaseStub;
import org.soldier.platform.svr_platform.client.TStubOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.comm.PlatformArgs;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.AddResourceTagResp;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.ResourceTag;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.SynceEcsInstanceOption;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.AliyunResourceAoService;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.AliyunResourceAoServiceVariable;

public class AliyunResourceAoServiceStub extends BaseStub {

  public AliyunResourceAoServiceStub() {
    super(AliyunResourceAoServiceVariable.serviceKey);
  }

  public com.longsheng.xueqiao.aliyun.resource.thriftapi.EcsInstancePage  reqEcsInstance(com.longsheng.xueqiao.aliyun.resource.thriftapi.ReqEcsInstanceOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqEcsInstance(option, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.aliyun.resource.thriftapi.EcsInstancePage  reqEcsInstance(com.longsheng.xueqiao.aliyun.resource.thriftapi.ReqEcsInstanceOption option,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqEcsInstance").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<com.longsheng.xueqiao.aliyun.resource.thriftapi.EcsInstancePage>(){
    @Override
    public com.longsheng.xueqiao.aliyun.resource.thriftapi.EcsInstancePage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new AliyunResourceAoService.Client(protocol).reqEcsInstance(platformArgs, option);
      }
    }, invokeInfo);
  }

  public com.longsheng.xueqiao.aliyun.resource.thriftapi.EcsInstancePage  reqEcsInstance(int routeKey, int timeout,com.longsheng.xueqiao.aliyun.resource.thriftapi.ReqEcsInstanceOption option)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqEcsInstance(option, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public AddResourceTagResp  addResourceTag(ResourceTag resourceTag) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addResourceTag(resourceTag, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public AddResourceTagResp  addResourceTag(ResourceTag resourceTag,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("addResourceTag").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<AddResourceTagResp>(){
    @Override
    public AddResourceTagResp call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new AliyunResourceAoService.Client(protocol).addResourceTag(platformArgs, resourceTag);
      }
    }, invokeInfo);
  }

  public AddResourceTagResp  addResourceTag(int routeKey, int timeout,ResourceTag resourceTag)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addResourceTag(resourceTag, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  syncEcsInstance(SynceEcsInstanceOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    syncEcsInstance(option, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  syncEcsInstance(SynceEcsInstanceOption option,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("syncEcsInstance").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new AliyunResourceAoService.Client(protocol).syncEcsInstance(platformArgs, option);
      return null;
      }
    }, invokeInfo);
  }

  public void  syncEcsInstance(int routeKey, int timeout,SynceEcsInstanceOption option)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    syncEcsInstance(option, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

}
