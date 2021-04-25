package com.longsheng.xueqiao.aliyun.resource.thriftapi.client;

import com.longsheng.xueqiao.aliyun.resource.thriftapi.AliyunResourceAoService;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.AliyunResourceAoServiceVariable;
import org.apache.thrift.TException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.client.AsyncCallRunner;
import org.soldier.platform.svr_platform.client.IMethodCallback;
import org.soldier.platform.svr_platform.client.SvrContainer;
import org.soldier.platform.svr_platform.client.TRequestOption;
import org.soldier.platform.svr_platform.client.TServiceCall;
import org.soldier.platform.svr_platform.comm.PlatformArgs;
import org.soldier.platform.svr_platform.client.BaseStub;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.AddResourceTagResp;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.ResourceTag;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.SynceEcsInstanceOption;

public class AliyunResourceAoServiceAsyncStub extends BaseStub { 
  public AliyunResourceAoServiceAsyncStub() {
    super(AliyunResourceAoServiceVariable.serviceKey);
  }
  public void send_reqEcsInstance(int routeKey, int timeout, com.longsheng.xueqiao.aliyun.resource.thriftapi.ReqEcsInstanceOption option) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqEcsInstanceServiceCall(routeKey, timeout, platformArgs, option), new TRequestOption());
  }

  public void send_reqEcsInstance(int routeKey, int timeout, com.longsheng.xueqiao.aliyun.resource.thriftapi.ReqEcsInstanceOption option,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqEcsInstanceServiceCall(routeKey, timeout, platformArgs, option), requestOption);
  }

  public long reqEcsInstance(int routeKey, int timeout, com.longsheng.xueqiao.aliyun.resource.thriftapi.ReqEcsInstanceOption option, IMethodCallback<AliyunResourceAoService.reqEcsInstance_args, AliyunResourceAoService.reqEcsInstance_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqEcsInstanceServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  public long add_reqEcsInstanceCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.aliyun.resource.thriftapi.ReqEcsInstanceOption option, IMethodCallback<AliyunResourceAoService.reqEcsInstance_args, AliyunResourceAoService.reqEcsInstance_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqEcsInstanceServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  protected TServiceCall create_reqEcsInstanceServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.aliyun.resource.thriftapi.ReqEcsInstanceOption option){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(AliyunResourceAoServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    AliyunResourceAoService.reqEcsInstance_args request = new AliyunResourceAoService.reqEcsInstance_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqEcsInstance");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(AliyunResourceAoService.reqEcsInstance_result.class);
    return serviceCall;
  }

  public void send_addResourceTag(int routeKey, int timeout, ResourceTag resourceTag) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_addResourceTagServiceCall(routeKey, timeout, platformArgs, resourceTag), new TRequestOption());
  }

  public void send_addResourceTag(int routeKey, int timeout, ResourceTag resourceTag,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_addResourceTagServiceCall(routeKey, timeout, platformArgs, resourceTag), requestOption);
  }

  public long addResourceTag(int routeKey, int timeout, ResourceTag resourceTag, IMethodCallback<AliyunResourceAoService.addResourceTag_args, AliyunResourceAoService.addResourceTag_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_addResourceTagServiceCall(routeKey, timeout, platformArgs, resourceTag), callback);
  }

  public long add_addResourceTagCall(AsyncCallRunner runner, int routeKey, int timeout, ResourceTag resourceTag, IMethodCallback<AliyunResourceAoService.addResourceTag_args, AliyunResourceAoService.addResourceTag_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_addResourceTagServiceCall(routeKey, timeout, platformArgs, resourceTag), callback);
  }

  protected TServiceCall create_addResourceTagServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ResourceTag resourceTag){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(AliyunResourceAoServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    AliyunResourceAoService.addResourceTag_args request = new AliyunResourceAoService.addResourceTag_args();
    request.setPlatformArgs(platformArgs);
    request.setResourceTag(resourceTag);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addResourceTag");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(AliyunResourceAoService.addResourceTag_result.class);
    return serviceCall;
  }

  public void send_syncEcsInstance(int routeKey, int timeout, SynceEcsInstanceOption option) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_syncEcsInstanceServiceCall(routeKey, timeout, platformArgs, option), new TRequestOption());
  }

  public void send_syncEcsInstance(int routeKey, int timeout, SynceEcsInstanceOption option,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_syncEcsInstanceServiceCall(routeKey, timeout, platformArgs, option), requestOption);
  }

  public long syncEcsInstance(int routeKey, int timeout, SynceEcsInstanceOption option, IMethodCallback<AliyunResourceAoService.syncEcsInstance_args, AliyunResourceAoService.syncEcsInstance_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_syncEcsInstanceServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  public long add_syncEcsInstanceCall(AsyncCallRunner runner, int routeKey, int timeout, SynceEcsInstanceOption option, IMethodCallback<AliyunResourceAoService.syncEcsInstance_args, AliyunResourceAoService.syncEcsInstance_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_syncEcsInstanceServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  protected TServiceCall create_syncEcsInstanceServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, SynceEcsInstanceOption option){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(AliyunResourceAoServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    AliyunResourceAoService.syncEcsInstance_args request = new AliyunResourceAoService.syncEcsInstance_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("syncEcsInstance");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(AliyunResourceAoService.syncEcsInstance_result.class);
    return serviceCall;
  }

}
