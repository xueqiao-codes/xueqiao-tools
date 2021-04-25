package com.longsheng.xueqiao.aliyun.resource.aliyunapi;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class AliYunApiFactory {
    private static AliYunApiFactory ourInstance = new AliYunApiFactory();

    public static AliYunApiFactory getInstance() {
        return ourInstance;
    }

    private IAcsClient client;

    private AliYunApiFactory() {
        IClientProfile profile = DefaultProfile.getProfile(ApiConst.REGION_ID, ApiConst.ACCESS_KEY, ApiConst.ACCESS_KEY_SECRET);
        this.client = new DefaultAcsClient(profile);
    }

    public IAcsClient getDefaultClient() {
        return this.client;
    }
}
