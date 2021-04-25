package com.longsheng.xueqiao.duck.thriftapi.client;

import com.longsheng.xueqiao.duck.thriftapi.DuckService;
import com.longsheng.xueqiao.duck.thriftapi.DuckServiceVariable;
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
import java.util.List;
import java.nio.ByteBuffer;

public class DuckServiceAsyncStub extends BaseStub { 
  public DuckServiceAsyncStub() {
    super(DuckServiceVariable.serviceKey);
  }
  public void send_getSession(int routeKey, int timeout, String sessionKey) throws TException {
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
        create_getSessionServiceCall(routeKey, timeout, platformArgs, sessionKey), new TRequestOption());
  }

  public void send_getSession(int routeKey, int timeout, String sessionKey,TRequestOption requestOption) throws TException { 
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
        create_getSessionServiceCall(routeKey, timeout, platformArgs, sessionKey), requestOption);
  }

  public long getSession(int routeKey, int timeout, String sessionKey, IMethodCallback<DuckService.getSession_args, DuckService.getSession_result> callback) throws TException{
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
            create_getSessionServiceCall(routeKey, timeout, platformArgs, sessionKey), callback);
  }

  public long add_getSessionCall(AsyncCallRunner runner, int routeKey, int timeout, String sessionKey, IMethodCallback<DuckService.getSession_args, DuckService.getSession_result> callback) throws TException{
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
            create_getSessionServiceCall(routeKey, timeout, platformArgs, sessionKey), callback);
  }

  protected TServiceCall create_getSessionServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String sessionKey){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(DuckServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    DuckService.getSession_args request = new DuckService.getSession_args();
    request.setPlatformArgs(platformArgs);
    request.setSessionKey(sessionKey);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("getSession");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(DuckService.getSession_result.class);
    return serviceCall;
  }

  public void send_updateSession(int routeKey, int timeout, String sessionKey, ByteBuffer sessionValue, int expireSeconds) throws TException {
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
        create_updateSessionServiceCall(routeKey, timeout, platformArgs, sessionKey, sessionValue, expireSeconds), new TRequestOption());
  }

  public void send_updateSession(int routeKey, int timeout, String sessionKey, ByteBuffer sessionValue, int expireSeconds,TRequestOption requestOption) throws TException { 
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
        create_updateSessionServiceCall(routeKey, timeout, platformArgs, sessionKey, sessionValue, expireSeconds), requestOption);
  }

  public long updateSession(int routeKey, int timeout, String sessionKey, ByteBuffer sessionValue, int expireSeconds, IMethodCallback<DuckService.updateSession_args, DuckService.updateSession_result> callback) throws TException{
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
            create_updateSessionServiceCall(routeKey, timeout, platformArgs, sessionKey, sessionValue, expireSeconds), callback);
  }

  public long add_updateSessionCall(AsyncCallRunner runner, int routeKey, int timeout, String sessionKey, ByteBuffer sessionValue, int expireSeconds, IMethodCallback<DuckService.updateSession_args, DuckService.updateSession_result> callback) throws TException{
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
            create_updateSessionServiceCall(routeKey, timeout, platformArgs, sessionKey, sessionValue, expireSeconds), callback);
  }

  protected TServiceCall create_updateSessionServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String sessionKey, ByteBuffer sessionValue, int expireSeconds){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(DuckServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    DuckService.updateSession_args request = new DuckService.updateSession_args();
    request.setPlatformArgs(platformArgs);
    request.setSessionKey(sessionKey);
    request.setSessionValue(sessionValue);
    request.setExpireSeconds(expireSeconds);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateSession");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(DuckService.updateSession_result.class);
    return serviceCall;
  }

  public void send_deleteSession(int routeKey, int timeout, String sessionKey) throws TException {
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
        create_deleteSessionServiceCall(routeKey, timeout, platformArgs, sessionKey), new TRequestOption());
  }

  public void send_deleteSession(int routeKey, int timeout, String sessionKey,TRequestOption requestOption) throws TException { 
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
        create_deleteSessionServiceCall(routeKey, timeout, platformArgs, sessionKey), requestOption);
  }

  public long deleteSession(int routeKey, int timeout, String sessionKey, IMethodCallback<DuckService.deleteSession_args, DuckService.deleteSession_result> callback) throws TException{
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
            create_deleteSessionServiceCall(routeKey, timeout, platformArgs, sessionKey), callback);
  }

  public long add_deleteSessionCall(AsyncCallRunner runner, int routeKey, int timeout, String sessionKey, IMethodCallback<DuckService.deleteSession_args, DuckService.deleteSession_result> callback) throws TException{
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
            create_deleteSessionServiceCall(routeKey, timeout, platformArgs, sessionKey), callback);
  }

  protected TServiceCall create_deleteSessionServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String sessionKey){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(DuckServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    DuckService.deleteSession_args request = new DuckService.deleteSession_args();
    request.setPlatformArgs(platformArgs);
    request.setSessionKey(sessionKey);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("deleteSession");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(DuckService.deleteSession_result.class);
    return serviceCall;
  }

  public void send_batchGetSession(int routeKey, int timeout, List<String> sessionKeyList) throws TException {
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
        create_batchGetSessionServiceCall(routeKey, timeout, platformArgs, sessionKeyList), new TRequestOption());
  }

  public void send_batchGetSession(int routeKey, int timeout, List<String> sessionKeyList,TRequestOption requestOption) throws TException { 
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
        create_batchGetSessionServiceCall(routeKey, timeout, platformArgs, sessionKeyList), requestOption);
  }

  public long batchGetSession(int routeKey, int timeout, List<String> sessionKeyList, IMethodCallback<DuckService.batchGetSession_args, DuckService.batchGetSession_result> callback) throws TException{
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
            create_batchGetSessionServiceCall(routeKey, timeout, platformArgs, sessionKeyList), callback);
  }

  public long add_batchGetSessionCall(AsyncCallRunner runner, int routeKey, int timeout, List<String> sessionKeyList, IMethodCallback<DuckService.batchGetSession_args, DuckService.batchGetSession_result> callback) throws TException{
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
            create_batchGetSessionServiceCall(routeKey, timeout, platformArgs, sessionKeyList), callback);
  }

  protected TServiceCall create_batchGetSessionServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, List<String> sessionKeyList){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(DuckServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    DuckService.batchGetSession_args request = new DuckService.batchGetSession_args();
    request.setPlatformArgs(platformArgs);
    request.setSessionKeyList(sessionKeyList);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("batchGetSession");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(DuckService.batchGetSession_result.class);
    return serviceCall;
  }

  public void send_getAppSession(int routeKey, int timeout, String sessionKey, String appId) throws TException {
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
        create_getAppSessionServiceCall(routeKey, timeout, platformArgs, sessionKey, appId), new TRequestOption());
  }

  public void send_getAppSession(int routeKey, int timeout, String sessionKey, String appId,TRequestOption requestOption) throws TException { 
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
        create_getAppSessionServiceCall(routeKey, timeout, platformArgs, sessionKey, appId), requestOption);
  }

  public long getAppSession(int routeKey, int timeout, String sessionKey, String appId, IMethodCallback<DuckService.getAppSession_args, DuckService.getAppSession_result> callback) throws TException{
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
            create_getAppSessionServiceCall(routeKey, timeout, platformArgs, sessionKey, appId), callback);
  }

  public long add_getAppSessionCall(AsyncCallRunner runner, int routeKey, int timeout, String sessionKey, String appId, IMethodCallback<DuckService.getAppSession_args, DuckService.getAppSession_result> callback) throws TException{
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
            create_getAppSessionServiceCall(routeKey, timeout, platformArgs, sessionKey, appId), callback);
  }

  protected TServiceCall create_getAppSessionServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String sessionKey, String appId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(DuckServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    DuckService.getAppSession_args request = new DuckService.getAppSession_args();
    request.setPlatformArgs(platformArgs);
    request.setSessionKey(sessionKey);
    request.setAppId(appId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("getAppSession");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(DuckService.getAppSession_result.class);
    return serviceCall;
  }

  public void send_updateAppSession(int routeKey, int timeout, String sessionKey, ByteBuffer sessionValue, int expireSeconds, String appId) throws TException {
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
        create_updateAppSessionServiceCall(routeKey, timeout, platformArgs, sessionKey, sessionValue, expireSeconds, appId), new TRequestOption());
  }

  public void send_updateAppSession(int routeKey, int timeout, String sessionKey, ByteBuffer sessionValue, int expireSeconds, String appId,TRequestOption requestOption) throws TException { 
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
        create_updateAppSessionServiceCall(routeKey, timeout, platformArgs, sessionKey, sessionValue, expireSeconds, appId), requestOption);
  }

  public long updateAppSession(int routeKey, int timeout, String sessionKey, ByteBuffer sessionValue, int expireSeconds, String appId, IMethodCallback<DuckService.updateAppSession_args, DuckService.updateAppSession_result> callback) throws TException{
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
            create_updateAppSessionServiceCall(routeKey, timeout, platformArgs, sessionKey, sessionValue, expireSeconds, appId), callback);
  }

  public long add_updateAppSessionCall(AsyncCallRunner runner, int routeKey, int timeout, String sessionKey, ByteBuffer sessionValue, int expireSeconds, String appId, IMethodCallback<DuckService.updateAppSession_args, DuckService.updateAppSession_result> callback) throws TException{
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
            create_updateAppSessionServiceCall(routeKey, timeout, platformArgs, sessionKey, sessionValue, expireSeconds, appId), callback);
  }

  protected TServiceCall create_updateAppSessionServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String sessionKey, ByteBuffer sessionValue, int expireSeconds, String appId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(DuckServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    DuckService.updateAppSession_args request = new DuckService.updateAppSession_args();
    request.setPlatformArgs(platformArgs);
    request.setSessionKey(sessionKey);
    request.setSessionValue(sessionValue);
    request.setExpireSeconds(expireSeconds);
    request.setAppId(appId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateAppSession");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(DuckService.updateAppSession_result.class);
    return serviceCall;
  }

  public void send_deleteAppSession(int routeKey, int timeout, String sessionKey, String appId) throws TException {
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
        create_deleteAppSessionServiceCall(routeKey, timeout, platformArgs, sessionKey, appId), new TRequestOption());
  }

  public void send_deleteAppSession(int routeKey, int timeout, String sessionKey, String appId,TRequestOption requestOption) throws TException { 
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
        create_deleteAppSessionServiceCall(routeKey, timeout, platformArgs, sessionKey, appId), requestOption);
  }

  public long deleteAppSession(int routeKey, int timeout, String sessionKey, String appId, IMethodCallback<DuckService.deleteAppSession_args, DuckService.deleteAppSession_result> callback) throws TException{
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
            create_deleteAppSessionServiceCall(routeKey, timeout, platformArgs, sessionKey, appId), callback);
  }

  public long add_deleteAppSessionCall(AsyncCallRunner runner, int routeKey, int timeout, String sessionKey, String appId, IMethodCallback<DuckService.deleteAppSession_args, DuckService.deleteAppSession_result> callback) throws TException{
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
            create_deleteAppSessionServiceCall(routeKey, timeout, platformArgs, sessionKey, appId), callback);
  }

  protected TServiceCall create_deleteAppSessionServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String sessionKey, String appId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(DuckServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    DuckService.deleteAppSession_args request = new DuckService.deleteAppSession_args();
    request.setPlatformArgs(platformArgs);
    request.setSessionKey(sessionKey);
    request.setAppId(appId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("deleteAppSession");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(DuckService.deleteAppSession_result.class);
    return serviceCall;
  }

}
