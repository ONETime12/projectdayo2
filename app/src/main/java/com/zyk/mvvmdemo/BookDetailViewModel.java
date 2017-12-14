package com.zyk.mvvmdemo;

import android.util.Log;

import com.zyk.mvvmdemo.data.BookService;
import com.zyk.mvvmdemo.data.base.BaseViewModel;
import com.zyk.mvvmdemo.data.bean.BookBean;
import com.zyk.mvvmdemo.data.bean.RequestAdapter;
import com.zyk.mvvmdemo.helper.ErrorMsg;
import com.zyk.mvvmdemo.helper.ErrorNo;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;

/**
 * 作者：张玉轲
 * 时间：2017/11/5
 */

public class BookDetailViewModel extends BaseViewModel {
    public static final String STATUS_LOADING = "LOADING";
    public static final String STATUS_NO_DATA = "NO_DATA";
    public static final String STATUS_LOAD_SUCCESS = "LOAD_SUCCESS";
    public static final String STATUS_LOAD_FAILURE = "LOAD_FAILURE";

    BookService service=new BookService();
    private List<BookBean> mData=new ArrayList<>();
    private int num=0;
    private long total;

    public void getData(boolean isFresh){
        post(STATUS_LOADING);
        if (isFresh){
            mData.clear();
            num=0;
        }
        Observer<RequestAdapter.ResultList<BookBean>> observer=new Observer<RequestAdapter.ResultList<BookBean>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError: "+e);
                post(STATUS_LOAD_FAILURE, ErrorNo.ERROR_UNKNOWN, ErrorMsg.ERROR_UNKNOWN);
            }

            @Override
            public void onNext(RequestAdapter.ResultList<BookBean> bookBeanResultList) {
                if (bookBeanResultList.errNo!=ErrorNo.SUCCESS_NUM){
                    post(STATUS_LOAD_FAILURE, ErrorNo.ERROR_UNKNOWN, ErrorMsg.ERROR_UNKNOWN);
                    return;
                }
                if (bookBeanResultList.data==null){
                    post(STATUS_LOAD_FAILURE, ErrorNo.ERROR_RESULT_EMPTY, ErrorMsg.ERROR_RESULT_EMPTY);
                    return;

                }
                mData.addAll(bookBeanResultList.data.rows);
                total=bookBeanResultList.data.total;
                post(STATUS_LOAD_SUCCESS);

            }
        };
        service.getRows(num).subscribe(observer);
        num+=8;

    }

    public BookBean getmData(int po) {
        try {
            return mData.get(po);
        } catch (Exception e) {
            Log.i(TAG, "getmData: "+e);
        }
        return null;
    }
    public int getSize(){
        return mData.size();
    }
    public boolean isNo(){
        return mData.size()>=total;
    }

}
