package com.qicheng.config;

/**
 * 自定义请求状态码
 * 约定： 1开头为用户模块，2开头为商品类别模块。3待定
 * @author ScienJus
 * @date 2015/7/15.
 */
public enum ResultStatus {
    SUCCESS(100, "操作成功"),
    FAIL(-100, "操作失败"),
    REGISTER_SUCCESS(100, "注册成功"),
    DELETE_SUCCESS(100, "删除成功"),
    DELETE_FAIL(-201, "小类别还存在此信息，请先删除小类别信息"),
    UPDATE_SUCCESS(100, "修改成功"),
    USERNAME_OR_PASSWORD_ERROR(-1001, "用户名或密码错误"),
    USER_YES_FOUND(-1002, "用户已存在"),
    USER_NOT_LOGIN(-1003, "用户未登录"),
    USER_NOT_FOUND(-1004, "用户不存在");

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回结果描述
     */
    private String message;

    ResultStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
