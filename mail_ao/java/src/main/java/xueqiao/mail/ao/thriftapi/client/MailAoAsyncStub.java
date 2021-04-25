package xueqiao.mail.ao.thriftapi.client;

import xueqiao.mail.ao.thriftapi.MailAo;
import xueqiao.mail.ao.thriftapi.MailAoVariable;
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

public class MailAoAsyncStub extends BaseStub { 
  public MailAoAsyncStub() {
    super(MailAoVariable.serviceKey);
  }
  public void send_sendMail(int routeKey, int timeout, xueqiao.mail.MailSettings settings, xueqiao.mail.MailEntity mailEntity) throws TException {
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
        create_sendMailServiceCall(routeKey, timeout, platformArgs, settings, mailEntity), new TRequestOption());
  }

  public void send_sendMail(int routeKey, int timeout, xueqiao.mail.MailSettings settings, xueqiao.mail.MailEntity mailEntity,TRequestOption requestOption) throws TException { 
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
        create_sendMailServiceCall(routeKey, timeout, platformArgs, settings, mailEntity), requestOption);
  }

  public long sendMail(int routeKey, int timeout, xueqiao.mail.MailSettings settings, xueqiao.mail.MailEntity mailEntity, IMethodCallback<MailAo.sendMail_args, MailAo.sendMail_result> callback) throws TException{
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
            create_sendMailServiceCall(routeKey, timeout, platformArgs, settings, mailEntity), callback);
  }

  public long add_sendMailCall(AsyncCallRunner runner, int routeKey, int timeout, xueqiao.mail.MailSettings settings, xueqiao.mail.MailEntity mailEntity, IMethodCallback<MailAo.sendMail_args, MailAo.sendMail_result> callback) throws TException{
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
            create_sendMailServiceCall(routeKey, timeout, platformArgs, settings, mailEntity), callback);
  }

  protected TServiceCall create_sendMailServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mail.MailSettings settings, xueqiao.mail.MailEntity mailEntity){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailAoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailAo.sendMail_args request = new MailAo.sendMail_args();
    request.setPlatformArgs(platformArgs);
    request.setSettings(settings);
    request.setMailEntity(mailEntity);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("sendMail");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailAo.sendMail_result.class);
    return serviceCall;
  }

}
