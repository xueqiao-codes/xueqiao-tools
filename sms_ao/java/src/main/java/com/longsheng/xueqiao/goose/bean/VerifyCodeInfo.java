package com.longsheng.xueqiao.goose.bean;

import com.google.gson.Gson;

public class VerifyCodeInfo {

    private String tel;
    private String code;
    private int updateTimeSeconds;

    public VerifyCodeInfo(String tel, String code, int updateTimeSeconds) {
        this.tel = tel;
        this.code = code;
        this.updateTimeSeconds = updateTimeSeconds;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getUpdateTimeSeconds() {
        return updateTimeSeconds;
    }

    public void setUpdateTimeSeconds(int updateTimeSeconds) {
        this.updateTimeSeconds = updateTimeSeconds;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
