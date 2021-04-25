package com.longsheng.xueqiao.goose.handler;

import com.longsheng.xueqiao.goose.bean.VerifyCodeInfo;
import com.longsheng.xueqiao.goose.errorcode.SmsErrorCode;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;

public class VerifyCodeDelegate {

    private VerifyCodeHandler mVerifyCodeHelper;

    public VerifyCodeDelegate() {
        mVerifyCodeHelper = new VerifyCodeHandler();
    }

    public boolean verifySmsCode(TServiceCntl oCntl, String mobileNo, String smsCode) throws ErrorInfo, TException {
        return verifySmsCode(oCntl, mobileNo, smsCode, true);
    }

    public boolean verifySmsCode(TServiceCntl oCntl, String mobileNo, String smsCode, boolean clear) throws ErrorInfo, TException {
        ErrorInfo errorInfo = new ErrorInfo();

        AppLog.i("VerifyCodeDelegate ---- verifySmsCode ---- mobileNo : " + mobileNo + ", smsCode : " + smsCode);

        if (mobileNo == null || mobileNo.isEmpty()) {
            errorInfo.setErrorCode(SmsErrorCode.VERIFY_CODE_ERROR.getValue());
            errorInfo.setErrorMsg("mobileNo should not be null or empty.");
            throw errorInfo;
        }
        if (smsCode == null || smsCode.isEmpty()) {
            errorInfo.setErrorCode(SmsErrorCode.VERIFY_CODE_ERROR.getValue());
            errorInfo.setErrorMsg("smsCode should be null or empty.");
            throw errorInfo;
        }

        VerifyCodeInfo verifyCodeInfo = mVerifyCodeHelper.getVerifyCodeInfo(mobileNo);

        boolean verifySmsCode = false;
        if (verifyCodeInfo != null && verifyCodeInfo.getCode() != null && verifyCodeInfo.getCode().equals(smsCode)) {
            verifySmsCode = true;

            /*
            * 校验成功后清除
            * */
            if (clear) {
                mVerifyCodeHelper.clearVerifyCode(mobileNo);
            }
        }

        return verifySmsCode;
    }


}
