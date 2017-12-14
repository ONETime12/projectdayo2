package com.zyk.mvvmdemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import com.liaoinstan.springview.container.AcFunFooter;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.widget.SpringView;
import com.zyk.mvvmdemo.data.bean.BookBean;
import com.zyk.mvvmdemo.databinding.ActivityMainBinding;
import com.zyk.mvvmdemo.databinding.BooklistItemBinding;
import com.zyk.mvvmdemo.helper.VMActionManager;
import java.util.ArrayList;
import java.util.List;

import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mMainBinding;
    BookDetailViewModel mViewmodel = new BookDetailViewModel();
    public static final String TAG="MainActivity";
//    private List<BookBean> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        mMainBinding.rvBooklist.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter();
        mMainBinding.rvBooklist.setAdapter(adapter);
        getBind();
        mViewmodel.getData(false);
        mMainBinding.svBooklist.setType(SpringView.Type.FOLLOW);
        mMainBinding.svBooklist.setHeader(new DefaultFooter(this));
        mMainBinding.svBooklist.setFooter(new DefaultFooter(this));
        mMainBinding.svBooklist.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                mViewmodel.getData(true);
                mMainBinding.svBooklist.onFinishFreshAndLoad();

            }

            @Override
            public void onLoadmore() {
             mViewmodel.getData(false);
             mMainBinding.svBooklist.onFinishFreshAndLoad();
             boolean no = mViewmodel.isNo();
                if (no){
                    Toast.makeText(MainActivity.this, "到底啦", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void getBind(){
        mViewmodel.bind(BookDetailViewModel.STATUS_NO_DATA, new Action1<VMActionManager.Result>() {
            @Override
            public void call(VMActionManager.Result result) {
                Log.i(TAG, "call me: 没有数据。。。");
            }
        });
        mViewmodel.bind(BookDetailViewModel.STATUS_LOADING, new Action1<VMActionManager.Result>() {
            @Override
            public void call(VMActionManager.Result result) {
                Log.i(TAG, "call me: 正在加载数据。。。");
            }
        });
        mViewmodel.bind(BookDetailViewModel.STATUS_LOAD_FAILURE, new Action1<VMActionManager.Result>() {
            @Override
            public void call(VMActionManager.Result result) {
                Log.i(TAG, "call me: 加载数据失败。。。");
            }
        });
        mViewmodel.bind(BookDetailViewModel.STATUS_LOAD_SUCCESS, new Action1<VMActionManager.Result>() {
            @Override
            public void call(VMActionManager.Result result) {
                Log.i(TAG, "call me: 加载数据成功。。。");
                mMainBinding.rvBooklist.getAdapter().notifyDataSetChanged();
            }
        });
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(BooklistItemBinding.inflate(getLayoutInflater(),parent,false));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            BookBean bookBean = mViewmodel.getmData(position);
            holder.mItemBinding.setBean(bookBean);
        }

        @Override
        public int getItemCount() {
            return mViewmodel.getSize();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        BooklistItemBinding mItemBinding;
        public MyViewHolder(BooklistItemBinding itemBinding) {
            super(itemBinding.getRoot());
            mItemBinding=itemBinding;
        }
    }
}
