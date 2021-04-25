package com.longsheng.xueqiao.goose.thriftapi.server;

import java.util.Properties;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import java.util.Map;
import java.util.HashMap;
import com.longsheng.xueqiao.goose.thriftapi.GooseAo;
import com.longsheng.xueqiao.goose.thriftapi.GooseAoVariable;


public abstract class GooseAoAdaptor implements GooseAo.Iface{
  // unmodified map, so we do not need lock for this 
  private final Map<String, String[]> methodParameterNameMap = new HashMap<String, String[]>(); 

  public String[] getMethodParameterName(String methodName) {
    return methodParameterNameMap.get(methodName);
  }

  @Override
  public void sendVerifyCode(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String mobileNo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(GooseAoVariable.serviceKey,"sendVerifyCode",platformArgs);
sendVerifyCode(oCntl, mobileNo);
  }

  protected abstract void sendVerifyCode(TServiceCntl oCntl, String mobileNo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public boolean verifySmsCode(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String mobileNo, String smsCode) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(GooseAoVariable.serviceKey,"verifySmsCode",platformArgs);
    return verifySmsCode(oCntl, mobileNo, smsCode);
  }

  protected abstract boolean verifySmsCode(TServiceCntl oCntl, String mobileNo, String smsCode) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void sendUserNotificationSms(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String mobileNo, String msg) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(GooseAoVariable.serviceKey,"sendUserNotificationSms",platformArgs);
sendUserNotificationSms(oCntl, mobileNo, msg);
  }

  protected abstract void sendUserNotificationSms(TServiceCntl oCntl, String mobileNo, String msg) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void sendMaintenanceNotificationSms(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String msg) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(GooseAoVariable.serviceKey,"sendMaintenanceNotificationSms",platformArgs);
sendMaintenanceNotificationSms(oCntl, msg);
  }

  protected abstract void sendMaintenanceNotificationSms(TServiceCntl oCntl, String msg) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void sendMailboxMessage(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String tel, String userName, String content) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(GooseAoVariable.serviceKey,"sendMailboxMessage",platformArgs);
sendMailboxMessage(oCntl, tel, userName, content);
  }

  protected abstract void sendMailboxMessage(TServiceCntl oCntl, String tel, String userName, String content) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public boolean verifySmsCodeForClear(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String mobileNo, String smsCode, boolean clear) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(GooseAoVariable.serviceKey,"verifySmsCodeForClear",platformArgs);
    return verifySmsCodeForClear(oCntl, mobileNo, smsCode, clear);
  }

  protected abstract boolean verifySmsCodeForClear(TServiceCntl oCntl, String mobileNo, String smsCode, boolean clear) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  protected GooseAoAdaptor(){
    methodParameterNameMap.put("sendVerifyCode",new String[]{"platformArgs", "mobileNo"});
    methodParameterNameMap.put("verifySmsCode",new String[]{"platformArgs", "mobileNo", "smsCode"});
    methodParameterNameMap.put("sendUserNotificationSms",new String[]{"platformArgs", "mobileNo", "msg"});
    methodParameterNameMap.put("sendMaintenanceNotificationSms",new String[]{"platformArgs", "msg"});
    methodParameterNameMap.put("sendMailboxMessage",new String[]{"platformArgs", "tel", "userName", "content"});
    methodParameterNameMap.put("verifySmsCodeForClear",new String[]{"platformArgs", "mobileNo", "smsCode", "clear"});
  }
  protected abstract int InitApp(final Properties props);

  protected abstract void destroy();

}
