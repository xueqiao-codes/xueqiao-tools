package xueqiao.mail.ao.monitor;

import org.soldier.platform.attr.AttrReporterFactory;

import java.util.HashMap;
import java.util.Map;

public class PlatformMonitor {
    private static final String serviceKey = "mail_ao";
    private static final String TAG_SEND_MAIL_EXCEPTION = "service.mail.exception.count";

    private static PlatformMonitor instance = new PlatformMonitor();

    private Map<String, String> requestTags = new HashMap();

    private PlatformMonitor() {
        requestTags.put("servicekey", serviceKey);
    }

    /**
     *  发送邮件失败事件
     * */
    public static void reportSendMailException() {
        instance.report(TAG_SEND_MAIL_EXCEPTION);
    }

    private void report(String tag) {
        AttrReporterFactory.getDefault().inc(AttrReporterFactory.getDefault().requireKey(tag, requestTags), 1L);
    }

}
