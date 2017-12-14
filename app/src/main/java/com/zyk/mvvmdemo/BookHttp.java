package com.zyk.mvvmdemo;

import com.zyk.mvvmdemo.data.bean.BookBean;
import com.zyk.mvvmdemo.data.bean.RequestAdapter;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作者：张玉轲
 * 时间：2017/11/5
 */

public interface BookHttp {

    @GET("action/book_list?limit=8")
    Observable<RequestAdapter.ResultList<BookBean>> getRows(@Query("offset") int offset);

}
