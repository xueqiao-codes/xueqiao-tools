package com.longsheng.xueqiao.goose.thriftapi.server.impl;


import java.util.Properties;

import com.longsheng.xueqiao.goose.handler.MaintenanceNotificationHandler;
import com.longsheng.xueqiao.goose.handler.UserNotificationHandler;
import com.longsheng.xueqiao.goose.handler.VerifyCodeDelegate;
import com.longsheng.xueqiao.vendor.alisms.AliSendVerifyCodeDelegate;
import com.longsheng.xueqiao.vendor.alisms.AliSmsAPI;
import org.apache.thrift.TException;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import com.longsheng.xueqiao.goose.thriftapi.server.GooseAoAdaptor;

public class GooseAoHandler extends GooseAoAdaptor {
    @Override
    public int InitApp(Properties props) {
        ConfigurationProperty.instance().init(props);
        return 0;
    }

    @Override
    protected void sendVerifyCode(TServiceCntl oCntl, String mobileNo) throws ErrorInfo, TException {
        new AliSendVerifyCodeDelegate().sendVerifyCode(oCntl, mobileNo);
    }

    @Override
    protected boolean verifySmsCode(TServiceCntl oCntl, String mobileNo, String smsCode) throws ErrorInfo, TException {
        // 用session来保存验证码信息
        return new VerifyCodeDelegate().verifySmsCode(oCntl, mobileNo, smsCode);
    }

    @Override
    protected void sendUserNotificationSms(TServiceCntl oCntl, String mobileNo, String msg) throws ErrorInfo, TException {
        new UserNotificationHandler().sendNotificationSms(mobileNo, msg);
    }

    @Override
    protected void sendMaintenanceNotificationSms(TServiceCntl oCntl, String msg) throws ErrorInfo, TException {
        /*
         *   运维人员电话号码从QCONF中配置
         * */
        new MaintenanceNotificationHandler().sendMaintenanceSms(msg);
    }

    @Override
    protected void sendMailboxMessage(TServiceCntl oCntl, String tel, String userName, String content) throws ErrorInfo, TException {
        AliSmsAPI.sendMailboxMessage(tel, userName, content);
    }

    @Override
    protected boolean verifySmsCodeForClear(TServiceCntl oCntl, String mobileNo, String smsCode, boolean clear) throws ErrorInfo, TException {
        return new VerifyCodeDelegate().verifySmsCode(oCntl, mobileNo, smsCode, clear);
    }

    @Override
    public void destroy() {
    }
}
