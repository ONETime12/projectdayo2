package com.zyk.mvvmdemo.helper;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * VMActionManager class file
 * ViewModel的RxJava方法管理类
 * 需要包：
 * compile 'io.reactivex:rxjava:1.0.10'
 * compile 'io.reactivex:rxandroid:1.2.0'
 *
 * @author 宋欢 <trotri@yeah.net>
 * @version $Id: VMActionManager.java 1 2016-08-27 15:09:06Z huan.song $
 * @since 1.0
 */
public class VMActionManager {
    /**
     * RxJava方法集合
     */
    private final Map<String, Action1<Result>> mActions = new HashMap<>();

    /**
     * 执行RxJava方法：错误码 = 成功码、错误消息 = 成功消息
     *
     * @param name 方法名
     * @throws ClassNotFoundException RxJava方法名不存在，忘记绑定或绑定错误
     * @throws RuntimeException       RxJava执行异常
     */
    public void exec(String name) throws ClassNotFoundException, RuntimeException {
        exec(name, ErrorNo.SUCCESS_NUM, ErrorMsg.SUCCESS_MSG);
    }

    /**
     * 执行RxJava方法
     *
     * @param name   方法名
     * @param errNo  错误码
     * @param errMsg 错误消息
     * @throws ClassNotFoundException RxJava方法名不存在，忘记绑定或绑定错误
     * @throws RuntimeException       RxJava执行异常
     */
    public void exec(final String name, final int errNo, final String errMsg) throws ClassNotFoundException, RuntimeException {
        Action1<Result> func = get(name);

        Observable.OnSubscribe<Result> subscriber = new Observable.OnSubscribe<Result>() {
            @Override
            public void call(Subscriber<? super Result> s) {
                s.onNext(new Result(errNo, errMsg));
            }
        };

        Observable.create(subscriber).observeOn(AndroidSchedulers.mainThread()).subscribe(func, new Action1<Throwable>() {
            @Override
            public void call(Throwable tr) {
                throw new RuntimeException("VMActionManager exec func: '" + name + "' error", tr);
            }
        });
    }

    /**
     * 获取RxJava方法
     *
     * @param name 方法名
     * @return RxJava方法
     * @throws ClassNotFoundException RxJava方法不存在，忘记绑定或绑定错误
     */
    public Action1<Result> get(String name) throws ClassNotFoundException {
        Action1<Result> result = mActions.get(name);
        if (result == null) {
            throw new ClassNotFoundException("VMActionManager get func: '" + name + "' not found");
        }

        return result;
    }

    /**
     * 添加RxJava方法
     *
     * @param name 方法名
     * @param func RxJava方法
     */
    public void add(String name, Action1<Result> func) {
        mActions.put(name, func);
    }

    /**
     * Result class
     */
    public static class Result {
        /**
         * 错误码
         */
        private int errNo;

        /**
         * 错误消息
         */
        private String errMsg;

        /**
         * 构造方法：错误码 = 成功码、错误消息 = 成功消息
         */
        public Result() {
            this(ErrorNo.SUCCESS_NUM, ErrorMsg.SUCCESS_MSG);
        }

        /**
         * 构造方法：初始化错误码、错误消息和内容
         *
         * @param errNo  错误码
         * @param errMsg 错误消息
         */
        public Result(int errNo, String errMsg) {
            setErrNo(errNo);
            setErrMsg(errMsg);
        }

        /**
         * 获取错误码
         *
         * @return 错误码
         */
        public int getErrNo() {
            return errNo;
        }

        /**
         * 设置错误码
         *
         * @param errNo 错误码
         */
        public void setErrNo(int errNo) {
            this.errNo = errNo;
        }

        /**
         * 获取错误消息
         *
         * @return 错误消息
         */
        public String getErrMsg() {
            return errMsg;
        }

        /**
         * 设置错误消息
         *
         * @param errMsg 错误消息
         */
        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }

    }

}
