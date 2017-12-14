package com.zyk.mvvmdemo.helper;

/**
 * ErrorNo final class file
 * 常用错误码类
 *
 * @author 宋欢 <trotri@yeah.net>
 * @version $Id: ErrorNo.java 1 2016-10-24 10:00:06Z huan.song $
 * @since 1.0
 */
public final class ErrorNo {
    /**
     * OK
     */
    public static final int SUCCESS_NUM = 0;

    /**
     * 参数错误
     */
    public static final int ERROR_REQUEST = 400;

    /**
     * 用户没有访问权限
     */
    public static final int ERROR_NO_POWER = 403;

    /**
     * 用户未登录，禁止访问
     */
    public static final int ERROR_NO_LOGIN = 404;

    /**
     * 系统运行异常
     */
    public static final int ERROR_SYSTEM_RUN_ERR = 500;

    /**
     * 脚本运行失败
     */
    public static final int ERROR_SCRIPT_RUN_ERR = 501;

    /**
     * 参数错误
     */
    public static final int ERROR_ARGS_ERR = 1001;

    /**
     * 结果为空
     */
    public static final int ERROR_RESULT_EMPTY = 1002;

    /**
     * 未知错误
     */
    public static final int ERROR_UNKNOWN = 2008;

}
