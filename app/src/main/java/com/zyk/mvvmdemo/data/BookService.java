package com.zyk.mvvmdemo.data;

import com.zyk.mvvmdemo.BookHttp;
import com.zyk.mvvmdemo.data.base.BaseService;
import com.zyk.mvvmdemo.data.bean.BookBean;
import com.zyk.mvvmdemo.data.bean.RequestAdapter;

import retrofit2.http.Query;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：张玉轲
 * 时间：2017/11/5
 */

public class BookService extends BaseService{

   public Observable<RequestAdapter.ResultList<BookBean>> getRows(int offset){
       Observable<RequestAdapter.ResultList<BookBean>> observable = getRetrofit().create(BookHttp.class).getRows(offset).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
       return  observable;
   }

}
