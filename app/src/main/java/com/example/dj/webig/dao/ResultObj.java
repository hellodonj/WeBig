package com.example.dj.webig.dao;

/**
 * 描述：返回的数据格式
 *
 * Created by dj on 2016/10/26 0026.
 */
public class ResultObj {

    private String code;

    private String desc;

    private ResultDataObj result;

    private String userDesc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ResultDataObj getResult() {
        return result;
    }

    public void setResult(ResultDataObj result) {
        this.result = result;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }
}
