package com.longsheng.xueqiao.vendor.alisms;

import com.aliyuncs.exceptions.ClientException;
import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.goose.bean.VerifyCodeInfo;
import com.longsheng.xueqiao.goose.errorcode.SmsErrorCode;
import com.longsheng.xueqiao.goose.handler.VerifyCodeHandler;
import com.longsheng.xueqiao.goose.util.TimeUtil;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;

import java.io.UnsupportedEncodingException;

public class AliSendVerifyCodeDelegate {

    private static final int GET_VERIFY_CODE_FREQUENCY_IN_SECONDS = 60;
    private VerifyCodeHandler mVerifyCodeHelper;

    public AliSendVerifyCodeDelegate() {
        mVerifyCodeHelper = new VerifyCodeHandler();
    }

    public void sendVerifyCode(TServiceCntl oCntl, String mobileNo) throws ErrorInfo, TException {

        AppLog.i("AliSendVerifyCodeDelegate ---- sendVerifyCode ---- mobileNo : " + mobileNo);

        ErrorInfo errorInfo = new ErrorInfo();

        if ("".equals(mobileNo)) {
            errorInfo.setErrorCode(ErrorCodeOuter.PARAM_ERROR.getErrorCode());
            errorInfo.setErrorMsg("Tel number empty.");
            throw errorInfo;
        }

        // 检查手机号使用状态，防止频繁发送，如有异常，慢抛出异常
        checkValidity(mobileNo);

        // 生成验证码
        String verifyCode = "" + (RandomUtils.nextInt(9000) + 1000);
        boolean isSuccess = false;

        try {
            isSuccess = AliSmsAPI.sendSms(mobileNo, verifyCode);
        } catch (ClientException e) {
            AppLog.e(e.getMessage(), e);
            errorInfo.setErrorCode(SmsErrorCode.SEND_VERIFY_CODE_FAILED.getValue());
            errorInfo.setErrorMsg("AliSms send sms fail : " + e.getErrMsg());
            throw errorInfo;
        }

        if (isSuccess) {
            // 用duck_service来记录验证码
            try {
                mVerifyCodeHelper.updateVerifyCode(mobileNo, verifyCode);
            } catch (UnsupportedEncodingException e) {
                AppLog.e("AliSendVerifyCodeDelegate : " + e.toString());
            }
        } else {
            errorInfo.setErrorCode(SmsErrorCode.SEND_VERIFY_CODE_FAILED.getValue());
            errorInfo.setErrorMsg("AliSms send sms fail");
            throw errorInfo;
        }
    }

    private void checkValidity(String mobileNo) throws ErrorInfo {
        VerifyCodeInfo verifyCodeInfo = null;
        try {
            verifyCodeInfo = mVerifyCodeHelper.getVerifyCodeInfo(mobileNo);
        } catch (TException e) {
            e.printStackTrace();
        }
        AppLog.i("AliSendVerifyCodeDelegate ---- checkValidity ---- mobileNo : " + mobileNo + ", (verifyCodeInfo != null) : " + (verifyCodeInfo != null));
        if (verifyCodeInfo != null) {

            AppLog.i("AliSendVerifyCodeDelegate ---- checkValidity ---- verifyCodeInfo : " + verifyCodeInfo.toString() + ", TimeUtil.getCurrentTimeSeconds() : " + TimeUtil.getCurrentTimeSeconds());

            if (TimeUtil.getCurrentTimeSeconds() - verifyCodeInfo.getUpdateTimeSeconds() < GET_VERIFY_CODE_FREQUENCY_IN_SECONDS) {
                ErrorInfo errorInfo = new ErrorInfo();
                errorInfo.setErrorCode(SmsErrorCode.SEND_VERIFY_CODE_TOO_FREQUENTLY.getValue());
                errorInfo.setErrorMsg("send sms to frequently");
                throw errorInfo;
            }
        }
    }

}
