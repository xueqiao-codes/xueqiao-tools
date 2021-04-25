package xueqiao.mail.ao.thriftapi.server;

import java.util.Properties;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import java.util.Map;
import java.util.HashMap;
import xueqiao.mail.ao.thriftapi.MailAo;
import xueqiao.mail.ao.thriftapi.MailAoVariable;


public abstract class MailAoAdaptor implements MailAo.Iface{
  // unmodified map, so we do not need lock for this 
  private final Map<String, String[]> methodParameterNameMap = new HashMap<String, String[]>(); 

  public String[] getMethodParameterName(String methodName) {
    return methodParameterNameMap.get(methodName);
  }

  @Override
  public void sendMail(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mail.MailSettings settings, xueqiao.mail.MailEntity mailEntity) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailAoVariable.serviceKey,"sendMail",platformArgs);
sendMail(oCntl, settings, mailEntity);
  }

  protected abstract void sendMail(TServiceCntl oCntl, xueqiao.mail.MailSettings settings, xueqiao.mail.MailEntity mailEntity) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  protected MailAoAdaptor(){
    methodParameterNameMap.put("sendMail",new String[]{"platformArgs", "settings", "mailEntity"});
  }
  protected abstract int InitApp(final Properties props);

  protected abstract void destroy();

}
