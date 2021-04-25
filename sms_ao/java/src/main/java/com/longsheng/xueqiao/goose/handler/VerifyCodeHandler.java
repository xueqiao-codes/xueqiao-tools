package com.longsheng.xueqiao.goose.handler;

import com.google.gson.Gson;
import com.longsheng.xueqiao.duck.thriftapi.client.DuckServiceStub;
import com.longsheng.xueqiao.goose.util.ByteBufferUtil;
import com.longsheng.xueqiao.goose.bean.VerifyCodeInfo;
import com.longsheng.xueqiao.goose.util.TimeUtil;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 * VerifyCodeHelper
 */
public class VerifyCodeHandler {

    private static final String SMS_PREFIX = "SMS_VC_";
    // 验证码有效时间为15分钟
    private static final int EXPIRE_SECONDS = 15 * 60;

    private DuckServiceStub duckServiceStub;


    public VerifyCodeHandler() {
        duckServiceStub = new DuckServiceStub();
    }

    public VerifyCodeInfo getVerifyCodeInfo(String mobileNo) throws TException {
        ByteBuffer byteBuffer = duckServiceStub.getSession(getKey(mobileNo));
        VerifyCodeInfo verifyCodeInfo = new Gson().fromJson(ByteBufferUtil.byteBufferToString(byteBuffer), VerifyCodeInfo.class);
        AppLog.i("VerifyCodeHandler ---- getVerifyCodeInfo ---- mobileNo : " + mobileNo + ", verifyCodeInfo : " + (verifyCodeInfo == null ? "null" : verifyCodeInfo.toString()));
        return verifyCodeInfo;
    }

    public void updateVerifyCode(String mobileNo, String code) throws TException, UnsupportedEncodingException {
        AppLog.i("VerifyCodeHandler ---- updateVerifyCode ---- mobileNo : " + mobileNo + ", code : " + code);
        int nowTimeSeconds = TimeUtil.getCurrentTimeSeconds();
        VerifyCodeInfo verifyCodeInfo = new VerifyCodeInfo(mobileNo, code, nowTimeSeconds);
        String verifyCodeInfoJsonStr = new Gson().toJson(verifyCodeInfo);
        duckServiceStub.updateSession(getKey(mobileNo), ByteBufferUtil.stringToByteBuffer(verifyCodeInfoJsonStr), EXPIRE_SECONDS);
    }

    public void clearVerifyCode(String mobileNo) throws TException {
        AppLog.i("VerifyCodeHandler ---- clearVerifyCode ---- mobileNo : " + mobileNo);
        duckServiceStub.deleteSession(getKey(mobileNo));
    }

    private String getKey(String mobileNo) {
        return SMS_PREFIX + mobileNo;
    }


}
