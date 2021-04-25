package com.longsheng.xueqiao.aliyun.resource.thriftapi.server;

import java.util.Properties;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import java.util.Map;
import java.util.HashMap;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.AddResourceTagResp;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.ResourceTag;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.SynceEcsInstanceOption;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.AliyunResourceAoService;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.AliyunResourceAoServiceVariable;


public abstract class AliyunResourceAoServiceAdaptor implements AliyunResourceAoService.Iface{
  // unmodified map, so we do not need lock for this 
  private final Map<String, String[]> methodParameterNameMap = new HashMap<String, String[]>(); 

  public String[] getMethodParameterName(String methodName) {
    return methodParameterNameMap.get(methodName);
  }

  @Override
  public com.longsheng.xueqiao.aliyun.resource.thriftapi.EcsInstancePage reqEcsInstance(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.aliyun.resource.thriftapi.ReqEcsInstanceOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(AliyunResourceAoServiceVariable.serviceKey,"reqEcsInstance",platformArgs);
    return reqEcsInstance(oCntl, option);
  }

  protected abstract com.longsheng.xueqiao.aliyun.resource.thriftapi.EcsInstancePage reqEcsInstance(TServiceCntl oCntl, com.longsheng.xueqiao.aliyun.resource.thriftapi.ReqEcsInstanceOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public AddResourceTagResp addResourceTag(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ResourceTag resourceTag) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(AliyunResourceAoServiceVariable.serviceKey,"addResourceTag",platformArgs);
    return addResourceTag(oCntl, resourceTag);
  }

  protected abstract AddResourceTagResp addResourceTag(TServiceCntl oCntl, ResourceTag resourceTag) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void syncEcsInstance(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, SynceEcsInstanceOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(AliyunResourceAoServiceVariable.serviceKey,"syncEcsInstance",platformArgs);
syncEcsInstance(oCntl, option);
  }

  protected abstract void syncEcsInstance(TServiceCntl oCntl, SynceEcsInstanceOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  protected AliyunResourceAoServiceAdaptor(){
    methodParameterNameMap.put("reqEcsInstance",new String[]{"platformArgs", "option"});
    methodParameterNameMap.put("addResourceTag",new String[]{"platformArgs", "resourceTag"});
    methodParameterNameMap.put("syncEcsInstance",new String[]{"platformArgs", "option"});
  }
  protected abstract int InitApp(final Properties props);

  protected abstract void destroy();

}
