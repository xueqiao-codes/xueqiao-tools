package com.longsheng.xueqiao.goose.util;

/**
 *  TimeUtil
 * */
public class TimeUtil {

    public static int getCurrentTimeSeconds() {
        return (int) (System.currentTimeMillis() / 1000);
    }
}
