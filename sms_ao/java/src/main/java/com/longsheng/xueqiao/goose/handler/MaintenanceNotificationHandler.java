package com.longsheng.xueqiao.goose.handler;

import com.aliyuncs.exceptions.ClientException;
import com.longsheng.xueqiao.goose.errorcode.SmsErrorCode;
import com.longsheng.xueqiao.goose.util.QconfUtil;
import com.longsheng.xueqiao.vendor.alisms.AliSmsAPI;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.util.List;

public class MaintenanceNotificationHandler {

    public void sendMaintenanceSms(String msg) throws ErrorInfo {
        List<String> adminTelList = QconfUtil.getAdminTelList();
        for (String tel : adminTelList) {
            sendSms(tel, msg);
        }
    }

    private void sendSms(String mobileNo, String msg) throws ErrorInfo {
        AppLog.i("MaintenanceNotificationHandler ---- sendSms ---- mobileNo : " + mobileNo + ", msg : " + msg);
        boolean ret = false;
        try {
            ret = AliSmsAPI.sendMaintenanceNotification(mobileNo, msg);
        } catch (ClientException e) {
            e.printStackTrace();
            AppLog.e("MaintenanceNotificationHandler ---- sendSms ---- e " + e.toString());
        }
        if (!ret) {
            throw new ErrorInfo(SmsErrorCode.SEND_SMS_FAILED.getValue(), "send sms failed");
        }
    }
}
