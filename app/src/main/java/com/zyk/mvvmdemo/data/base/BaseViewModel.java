package com.zyk.mvvmdemo.data.base;

import android.util.Log;


import com.zyk.mvvmdemo.helper.ErrorMsg;
import com.zyk.mvvmdemo.helper.ErrorNo;
import com.zyk.mvvmdemo.helper.VMActionManager;

import rx.functions.Action1;

/**
 * BaseViewModel abstract class file
 * ViewModel基类
 *
 * @author 宋欢 <trotri@yeah.net>
 * @version $Id: BaseViewModel.java 1 2016-11-09 10:00:06Z huan.song $
 * @since 1.0
 */
public abstract class BaseViewModel {

    public static final String TAG = "BaseViewModel";

    /**
     * RxJava方法管理类
     */
    private VMActionManager mActionManager = new VMActionManager();

    /**
     * 绑定监听方法
     *
     * @param name 方法名
     * @param func RxJava方法
     */
    public void bind(String name, Action1<VMActionManager.Result> func) {
        mActionManager.add(name, func);
    }

    /**
     * 执行RxJava方法：错误码 = 成功码、错误消息 = 成功消息
     *
     * @param name 方法名
     */
    public void post(String name) {
        post(name, ErrorNo.SUCCESS_NUM, ErrorMsg.SUCCESS_MSG);
    }

    /**
     * 通知监听执行
     *
     * @param name   方法名
     * @param errNo  错误码
     * @param errMsg 错误消息
     */
    public void post(String name, int errNo, String errMsg) {
        try {
            mActionManager.exec(name, errNo, errMsg);
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "post name: '" + name + "' not found", e);
        }
    }

}
