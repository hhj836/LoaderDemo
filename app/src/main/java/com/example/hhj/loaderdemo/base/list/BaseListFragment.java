package com.example.hhj.loaderdemo.base.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.hhj.loaderdemo.R;
import com.example.hhj.loaderdemo.base.BaseFragment;
import com.example.hhj.loaderdemo.base.BaseListActivity;
import com.example.hhj.loaderdemo.base.ListConfig;
import com.example.hhj.loaderdemo.presenter.BaseListFragmentPresenter;
import com.example.hhj.loaderdemo.presenter.BaseListPresenter;

import butterknife.BindView;

/**
 * Created by hhj on 2017/12/14.
 */

public abstract class BaseListFragment<P extends BaseListFragmentPresenter> extends BaseFragment<P> {
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.mList)
    RecyclerView mList;


    private View emptyView;
    private View netErrorView;



    public RecyclerView getList(){
        return  mList;
    }
    public void stopRefresh(){
        refreshLayout.setRefreshing(false);
    }
    public void initConfig(ListConfig listConfig) {
        mList.setHasFixedSize(true);
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
            emptyView=View.inflate(mActivity,listConfig.emptyLayoutResId,null);
        }
        if(listConfig.netErrorResId!=0){
            netErrorView=View.inflate(mActivity,listConfig.netErrorResId,null);
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
