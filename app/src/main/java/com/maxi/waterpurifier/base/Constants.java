package com.maxi.waterpurifier.base;

/**
 * Created by bin.shen on 02/01/2017.
 */

public interface Constants {

    public final boolean IS_DEBUG_MODE = true;

    public final String API_BASE_PATH = "http://120.55.161.114:8888";

    public final String LOGIN = API_BASE_PATH + "/user/login";//用户登录

    public final String REQUEST_CODE = API_BASE_PATH  + "/user/request_code";//获取验证码

    public final String REGISTER = API_BASE_PATH  + "/user/register";//用户注册

    public final String FORGET_PASSWORD = API_BASE_PATH  + "/user/forget_password";//找回密码
}
