package com.mt.demo.oauth2.utils;

/**
 * ResultCode
 *
 * @author MT.LUO
 * 2018/1/12 10:46
 * @Description:
 */
public class ResultCode {
    public static int RESULT_CODE_OK = 200;
    public static int RESULT_CODE_ERROR = 400;
    public static int RESULT_CODE_LOGIN_ERROR = 300;
    public static int RESULT_CODE_LOGIN_FAIL = 301;
    public static int RESULT_CODE_AUTH_LIMIT = 302;
    public static int RESULT_CODE_SERVER_ERROR = 500;


    /**用户名重复*/
    public static int RESULT_CODE_USERNAME_EXIST = 601;
}
