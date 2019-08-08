package com.zt.seatcommon.result;

public enum  ResultEnum {

    //成功
    SUCCESS(200, "成功"),
    SUCCESS_EMPTY_DATA(201, "赞无数据"),
    //失败
    FAIL(400, "失败"),
    FAIL_NEED_LOGIN(401, "未登录"),
    FAIL_MISSING_PARAMETER(402, "缺少关键参数");







    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
