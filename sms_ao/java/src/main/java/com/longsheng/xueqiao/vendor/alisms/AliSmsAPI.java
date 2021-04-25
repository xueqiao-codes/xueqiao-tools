package com.longsheng.xueqiao.vendor.alisms;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.antiy.error_code.ErrorCodeInner;
import com.longsheng.xueqiao.goose.util.QconfUtil;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

/**
 * 阿里云短信服务接口
 */
public class AliSmsAPI {

    /**
     * 发送验证码短信
     *
     * @param phoneNumbers 发送短信的目标手机号
     * @param verifyCode   需要发送的验证码
     * @return 是否发送成功
     */
    public static boolean sendSms(String phoneNumbers, String verifyCode) throws ClientException {
        AppLog.i("AliSmsHelper ---- sendSms ---- phoneNumbers : " + phoneNumbers + ", verifyCode : " + verifyCode);
        return sendSms(AliSmsConfig.TEMPLATE, phoneNumbers, AliSmsConfig.CODE(verifyCode));
    }

    public static boolean sendUserNotification(String phoneNumbers, String content) throws ClientException {
        return sendSms(AliSmsConfig.TEMPLATE_USER_NOTIFICATION, phoneNumbers, AliSmsConfig.USER_NOTIFICATION_CONTENT(content));
    }

    public static boolean sendMaintenanceNotification(String phoneNumbers, String content) throws ClientException {
        return sendSms(AliSmsConfig.TEMPLATE_MAINTENANCE_NOTIFICATION, phoneNumbers, AliSmsConfig.MAINTENANCE_NOTIFICATION_CONTENT(QconfUtil.getPlatformEnv() + content));
    }

    /**
     * 发送信箱系统消息
     */
    public static boolean sendMailboxMessage(String tel, String userName, String content) throws ErrorInfo {
        try {
            return sendSms(new XueqiaoAliSmsConfig(), tel, userName, content);
        } catch (ClientException e) {
            AppLog.e(e.getMessage(),e);
            throw new ErrorInfo(ErrorCodeInner.SERVER_INNER_ERROR.getErrorCode(), e.getMessage());
        }
    }

    private static boolean sendSms(String template, String phoneNumbers, String content) throws ClientException {

        //设置超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", AliSmsConfig.TIMEOUT);
        System.setProperty("sun.net.client.defaultReadTimeout", AliSmsConfig.TIMEOUT);

        final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
        final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）

        final String accessKeyId = AliSmsConfig.ACCESS_KEY_ID;
        final String accessKeySecret = AliSmsConfig.ACCESS_KEY_SECRET;
        //初始化ascClient,暂时不支持多region（请勿修改）
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        request.setMethod(MethodType.POST);
        //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为00+国际区号+号码，如“0085200000000”
        request.setPhoneNumbers(phoneNumbers);
        request.setSignName(AliSmsConfig.SIGN);
        request.setTemplateCode(template);
        request.setTemplateParam(content);
        //请求失败这里会抛ClientException异常
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        AppLog.i("AliSmsHelper ---- sendSms ---- sendSmsResponse code : " + sendSmsResponse.getCode() + ", msg : " + sendSmsResponse.getMessage());

        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            return true;
        }
        return false;
    }

    /**
     * 发送信息
     */
    private static boolean sendSms(BaseAliSmsConfig config, String tel, String... param) throws ClientException, ErrorInfo {

        //设置超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", config.getTimeout());
        System.setProperty("sun.net.client.defaultReadTimeout", config.getTimeout());

        final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
        final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）

        final String accessKeyId = config.getAsscessKeyId();
        final String accessKeySecret = config.getAccessKeySecret();
        //初始化ascClient,暂时不支持多region（请勿修改）
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        request.setMethod(MethodType.POST);
        //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为00+国际区号+号码，如“0085200000000”
        request.setPhoneNumbers(tel);
        request.setSignName(config.getSign());
        request.setTemplateCode(config.getTemplate());
        request.setTemplateParam(config.templateContent(param));
        //请求失败这里会抛ClientException异常
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        AppLog.i("AliSmsHelper ---- sendSms ---- sendSmsResponse code : " + sendSmsResponse.getCode() + ", msg : " + sendSmsResponse.getMessage());

        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            return true;
        }
        return false;
    }
}
