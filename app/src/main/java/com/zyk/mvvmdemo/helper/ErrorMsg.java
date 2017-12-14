package com.zyk.mvvmdemo.helper;

/**
 * ErrorMsg final class file
 * 常用错误信息类
 *
 * @author 宋欢 <trotri@yeah.net>
 * @version $Id: ErrorMsg.java 1 2016-10-24 10:00:06Z huan.song $
 * @since 1.0
 */
public final class ErrorMsg {
    /**
     * OK
     */
    public static final String SUCCESS_MSG = "OK";

    /**
     * 参数错误
     */
    public static final String ERROR_REQUEST = "Bad Request";

    /**
     * 用户没有访问权限
     */
    public static final String ERROR_NO_POWER = "Forbidden";

    /**
     * 用户未登录，禁止访问
     */
    public static final String ERROR_NO_LOGIN = "Not Found";

    /**
     * 系统运行异常
     */
    public static final String ERROR_SYSTEM_RUN_ERR = "Internal Server Error";

    /**
     * 脚本运行失败
     */
    public static final String ERROR_SCRIPT_RUN_ERR = "Not Implemented";

    /**
     * 参数错误
     */
    public static final String ERROR_ARGS_ERR = "Args Error";

    /**
     * 结果为空
     */
    public static final String ERROR_RESULT_EMPTY = "Result Empty";

    /**
     * 未知错误
     */
    public static final String ERROR_UNKNOWN = "Unknown Error";

}
