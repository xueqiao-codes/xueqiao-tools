package xueqiao.mail.ao.thriftapi.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.soldier.platform.svr_platform.client.BaseStub;
import org.soldier.platform.svr_platform.client.TStubOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.comm.PlatformArgs;
import xueqiao.mail.ao.thriftapi.MailAo;
import xueqiao.mail.ao.thriftapi.MailAoVariable;

public class MailAoStub extends BaseStub {

  public MailAoStub() {
    super(MailAoVariable.serviceKey);
  }

  public void  sendMail(xueqiao.mail.MailSettings settings, xueqiao.mail.MailEntity mailEntity) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    sendMail(settings, mailEntity, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  sendMail(xueqiao.mail.MailSettings settings, xueqiao.mail.MailEntity mailEntity,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("sendMail").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new MailAo.Client(protocol).sendMail(platformArgs, settings, mailEntity);
      return null;
      }
    }, invokeInfo);
  }

  public void  sendMail(int routeKey, int timeout,xueqiao.mail.MailSettings settings, xueqiao.mail.MailEntity mailEntity)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    sendMail(settings, mailEntity, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

}
