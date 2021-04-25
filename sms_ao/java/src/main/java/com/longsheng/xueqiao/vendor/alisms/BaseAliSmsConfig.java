package com.longsheng.xueqiao.vendor.alisms;

import org.soldier.platform.svr_platform.comm.ErrorInfo;

public abstract class BaseAliSmsConfig {
    // 访问控制权限
    protected String asscessKeyId = "LTAIHf21g3Gq3cEw";
    protected String accessKeySecret = "gJKZA7KSRfg5M6DVaZQFPtApLX2tET";

    /**
     * 短信验证码签名
     */
    protected String sign = "雪橇科技";

    /**
     * 信箱系统消息短信模板
     */
    protected String template = "SMS_160861296";

    /**
     * 连接超时和读超时时间
     */
    protected String timeout = "10000";

    public String getAsscessKeyId() {
        return asscessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public abstract String templateContent(String...param) throws ErrorInfo;
//        return "{\"UserName\":\"" + userName + "\",\"NoticeContent\":\"" + message + "\"}";

    public abstract String getSign();

    public abstract String getTemplate();

    public String getTimeout() {
        return timeout;
    }
}
