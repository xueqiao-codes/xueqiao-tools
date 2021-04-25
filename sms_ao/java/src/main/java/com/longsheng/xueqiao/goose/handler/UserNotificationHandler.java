package com.longsheng.xueqiao.goose.handler;

import com.aliyuncs.exceptions.ClientException;
import com.longsheng.xueqiao.goose.errorcode.SmsErrorCode;
import com.longsheng.xueqiao.vendor.alisms.AliSmsAPI;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

public class UserNotificationHandler {

    public void sendNotificationSms(String mobileNo, String msg) throws ErrorInfo {
        boolean ret = false;
        try {
            ret = AliSmsAPI.sendUserNotification(mobileNo, msg);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        if (!ret) {
            throw new ErrorInfo(SmsErrorCode.SEND_SMS_FAILED.getValue(), "send sms failed");
        }
    }
}
