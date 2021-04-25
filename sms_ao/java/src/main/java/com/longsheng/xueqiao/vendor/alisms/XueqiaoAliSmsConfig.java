package com.longsheng.xueqiao.vendor.alisms;

import com.antiy.error_code.ErrorCodeInner;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

public class XueqiaoAliSmsConfig extends BaseAliSmsConfig {
    // 访问控制权限
    private static final String ACCESS_KEY_ID = "LTAIHf21g3Gq3cEw";
    private static final String ACCESS_KEY_SECRET = "gJKZA7KSRfg5M6DVaZQFPtApLX2tET";

    /**
     *  短信验证码签名
     * */
    private static final String SIGN = "雪橇科技";

    /**
     *  信箱系统消息短信模板
     * */
    private static final String TEMPLATE = "SMS_160861296";

    /**
     *  连接超时和读超时时间
     * */
    private static final String TIMEOUT = "10000";

    /**
     *  验证码模板内容
     *  需要与模板保持对应
     * */
    private static final String MAILBOX_MESSAGE(String userName, String message) {
        return "{\"UserName\":\"" + userName + "\",\"NoticeContent\":\"" + message + "\"}";
    }

    @Override
    public String getSign() {
        return SIGN;
    }

    @Override
    public String getTemplate() {
        return TEMPLATE;
    }

    @Override
    public String templateContent(String... param) throws ErrorInfo {
        if (param.length != 2) {
            throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), "should set userName and message");
        }
        return MAILBOX_MESSAGE(param[0], param[1]);
    }

    @Override
    public String getAsscessKeyId() {
        return ACCESS_KEY_ID;
    }

    @Override
    public String getAccessKeySecret() {
        return ACCESS_KEY_SECRET;
    }

    @Override
    public String getTimeout() {
        return TIMEOUT;
    }
}
