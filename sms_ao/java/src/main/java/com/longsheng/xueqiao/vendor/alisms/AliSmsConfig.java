package com.longsheng.xueqiao.vendor.alisms;

/**
 * 龙胜账号下的配置信息
 * 阿里云短信服务配置文件
 * */
public class AliSmsConfig {

    // 龙胜账号下的配置信息 访问控制权限
//    public static final String ACCESS_KEY_ID = "LTAIlaRknG7FihM1";
//    public static final String ACCESS_KEY_SECRET = "FkkNpaFh9QpCBZhDTxjUdycPmVhuHj";

    /**
     * 雪橇账号下的配置信息 访问控制权限
     * */
    public static final String ACCESS_KEY_ID = "LTAIHf21g3Gq3cEw";
    public static final String ACCESS_KEY_SECRET = "gJKZA7KSRfg5M6DVaZQFPtApLX2tET";

    /**
     *  短信验证码签名
     * */
//    public static final String SIGN = "验证码";
    public static final String SIGN = "雪橇科技";

    /**
     *  短信验证码模板
     * */
//    public static final String TEMPLATE = "SMS_141596615";
    public static final String TEMPLATE = "SMS_160856372";

    /**
     *  用户通知短信模板
     * */
//    public static final String TEMPLATE_USER_NOTIFICATION = "SMS_141581777";
    public static final String TEMPLATE_USER_NOTIFICATION = "SMS_160861329";

    /**
     *  运维通知短信模板
     * */
//    public static final String TEMPLATE_MAINTENANCE_NOTIFICATION = "SMS_141616630";
    public static final String TEMPLATE_MAINTENANCE_NOTIFICATION = "SMS_160856375";

    /**
     *  连接超时和读超时时间
     * */
    public static final String TIMEOUT = "10000";

    /**
     *  验证码模板内容
     *  需要与模板保持对应
     * */
    public static final String CODE(String code) {
        return "{\"code\":\"" + code + "\"}";
    }

    /**
     *  验证码模板内容
     *  需要与模板保持对应
     * */
    public static final String USER_NOTIFICATION_CONTENT(String content) {
        return "{\"content\":\"" + content + "\"}";
    }

    /**
     *  短信通知模板内容
     *  需要与模板保持对应
     * */
    public static final String MAINTENANCE_NOTIFICATION_CONTENT(String content) {
        return "{\"content\":\"" + content + "\",\"action\":\"处理\"}";
    }

//    /**
//     *  短信通知模板内容
//     * */
//    public static final String ACTION() {
//        return "{\"action\":\"" + "处理" + "\"}";
//    }

}
