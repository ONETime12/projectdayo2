package com.zyk.mvvmdemo.data.base;

import com.zyk.mvvmdemo.data.bean.BookBean;
import com.zyk.mvvmdemo.data.bean.RequestAdapter;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * 作者：张玉轲
 * 时间：2017/11/5
 */

public class BaseService {

    private final Retrofit retrofit;

    public BaseService() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://169.254.181.49:8080/WebSample/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
