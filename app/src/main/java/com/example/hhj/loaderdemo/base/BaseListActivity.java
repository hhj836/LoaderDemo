package com.example.hhj.loaderdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.hhj.loaderdemo.R;
import com.example.hhj.loaderdemo.presenter.BaseListPresenter;
import butterknife.BindView;

/**
 * Created by hhj on 2017/12/13.
 */

public abstract  class BaseListActivity<P extends BaseListPresenter> extends BaseActivity<P> {
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.mList)
    RecyclerView mList;

    private View emptyView;
    private View netErrorView;



    ListConfig listConfig;
    public  abstract ListConfig getListConfig();
    public RecyclerView getList(){
        return  mList;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listConfig=getListConfig();



    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        initConfig();
        super.onPostCreate(savedInstanceState);

    }

    public void stopRefresh(){
        refreshLayout.setRefreshing(false);
    }
    private void initConfig() {
        if(!listConfig.enableRefresh){
            refreshLayout.setEnabled(false);
        }else {
            refreshLayout.setOnRefreshListener(getPresenter());
        }
        if(listConfig.enableLoadMore){
            getPresenter().getAdapter().setEnableLoadMore(true);
            getPresenter().getAdapter().setOnLoadMoreListener(getPresenter(),mList);
        }
        if(listConfig.emptyLayoutResId!=0){
            emptyView=View.inflate(BaseListActivity.this,listConfig.emptyLayoutResId,null);
        }
        if(listConfig.netErrorResId!=0){
            netErrorView=View.inflate(BaseListActivity.this,listConfig.netErrorResId,null);
        }

    }

    public void showEmpty(){
        getPresenter().getAdapter().setEmptyView(emptyView);

    }
    @Override
    public int getLayoutId() {
        return R.layout.base_list;
    }
}
