package com.longsheng.xueqiao.goose.util;

import net.qihoo.qconf.Qconf;
import net.qihoo.qconf.QconfException;
import org.apache.commons.lang.StringUtils;
import org.soldier.base.logger.AppLog;

import java.util.ArrayList;
import java.util.List;

public class QconfUtil {

    private static List<String> adminTelList = new ArrayList<>();
    private final static String QCONF_PATH = "xueqiao/company/sms/";
    private final static String QCONN_KEY_ADMIN_TEL_LIST = "admin_tel_list";
    private final static String QCONF_KEY_PLATFORM_ENV = "platform_environment";

    public static String getPlatformEnv() {
        String platformEnv = getQconfValue(QCONF_KEY_PLATFORM_ENV);
        if (StringUtils.isNotBlank(platformEnv)) {
            return "[" + getQconfValue(QCONF_KEY_PLATFORM_ENV) + "]";
        }
        return "";
    }

    public static List<String> getAdminTelList() {
        adminTelList.clear();
        String qconfValue = getQconfValue(QCONN_KEY_ADMIN_TEL_LIST);
        AppLog.i("QconfUtil ---- getAdminTelList ---- qconfValue : " + qconfValue);
        if (StringUtils.isNotBlank(qconfValue)) {
            if (qconfValue.contains(",")) {
                String[] telArray = qconfValue.split(",");
                for(String tel : telArray) {
                    adminTelList.add(tel);
                }
            } else {
                adminTelList.add(qconfValue);
            }
        }
        return adminTelList;
    }

    private static String getQconfValue(String key) {
        String qconfValue = null;
        try {
            qconfValue =  Qconf.getConf(QCONF_PATH + key).trim();
        } catch (QconfException e) {
            AppLog.e("QconfUtil ---- getQconfValue ---- Qconf.getConf ---- error : " + e.toString());
            e.printStackTrace();
        }
        return qconfValue;
    }
}
