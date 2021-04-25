package com.longsheng.xueqiao.duck.thriftapi.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.soldier.platform.svr_platform.client.BaseStub;
import org.soldier.platform.svr_platform.client.TStubOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.comm.PlatformArgs;
import java.util.List;
import java.nio.ByteBuffer;
import com.longsheng.xueqiao.duck.thriftapi.DuckService;
import com.longsheng.xueqiao.duck.thriftapi.DuckServiceVariable;

public class DuckServiceStub extends BaseStub {

  public DuckServiceStub() {
    super(DuckServiceVariable.serviceKey);
  }

  public ByteBuffer  getSession(String sessionKey) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return getSession(sessionKey, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public ByteBuffer  getSession(String sessionKey,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("getSession").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<ByteBuffer>(){
    @Override
    public ByteBuffer call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new DuckService.Client(protocol).getSession(platformArgs, sessionKey);
      }
    }, invokeInfo);
  }

  public ByteBuffer  getSession(int routeKey, int timeout,String sessionKey)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return getSession(sessionKey, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateSession(String sessionKey, ByteBuffer sessionValue, int expireSeconds) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateSession(sessionKey, sessionValue, expireSeconds, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateSession(String sessionKey, ByteBuffer sessionValue, int expireSeconds,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateSession").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new DuckService.Client(protocol).updateSession(platformArgs, sessionKey, sessionValue, expireSeconds);
      return null;
      }
    }, invokeInfo);
  }

  public void  updateSession(int routeKey, int timeout,String sessionKey, ByteBuffer sessionValue, int expireSeconds)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateSession(sessionKey, sessionValue, expireSeconds, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteSession(String sessionKey) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteSession(sessionKey, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteSession(String sessionKey,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("deleteSession").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new DuckService.Client(protocol).deleteSession(platformArgs, sessionKey);
      return null;
      }
    }, invokeInfo);
  }

  public void  deleteSession(int routeKey, int timeout,String sessionKey)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteSession(sessionKey, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<ByteBuffer>  batchGetSession(List<String> sessionKeyList) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return batchGetSession(sessionKeyList, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<ByteBuffer>  batchGetSession(List<String> sessionKeyList,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("batchGetSession").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<ByteBuffer>>(){
    @Override
    public List<ByteBuffer> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new DuckService.Client(protocol).batchGetSession(platformArgs, sessionKeyList);
      }
    }, invokeInfo);
  }

  public List<ByteBuffer>  batchGetSession(int routeKey, int timeout,List<String> sessionKeyList)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return batchGetSession(sessionKeyList, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public ByteBuffer  getAppSession(String sessionKey, String appId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return getAppSession(sessionKey, appId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public ByteBuffer  getAppSession(String sessionKey, String appId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("getAppSession").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<ByteBuffer>(){
    @Override
    public ByteBuffer call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new DuckService.Client(protocol).getAppSession(platformArgs, sessionKey, appId);
      }
    }, invokeInfo);
  }

  public ByteBuffer  getAppSession(int routeKey, int timeout,String sessionKey, String appId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return getAppSession(sessionKey, appId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateAppSession(String sessionKey, ByteBuffer sessionValue, int expireSeconds, String appId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateAppSession(sessionKey, sessionValue, expireSeconds, appId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateAppSession(String sessionKey, ByteBuffer sessionValue, int expireSeconds, String appId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateAppSession").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new DuckService.Client(protocol).updateAppSession(platformArgs, sessionKey, sessionValue, expireSeconds, appId);
      return null;
      }
    }, invokeInfo);
  }

  public void  updateAppSession(int routeKey, int timeout,String sessionKey, ByteBuffer sessionValue, int expireSeconds, String appId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateAppSession(sessionKey, sessionValue, expireSeconds, appId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteAppSession(String sessionKey, String appId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteAppSession(sessionKey, appId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteAppSession(String sessionKey, String appId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("deleteAppSession").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new DuckService.Client(protocol).deleteAppSession(platformArgs, sessionKey, appId);
      return null;
      }
    }, invokeInfo);
  }

  public void  deleteAppSession(int routeKey, int timeout,String sessionKey, String appId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteAppSession(sessionKey, appId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

}
