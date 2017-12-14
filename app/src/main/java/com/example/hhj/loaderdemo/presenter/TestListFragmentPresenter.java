package com.example.hhj.loaderdemo.presenter;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.hhj.loaderdemo.fragment.TestListFragment;
import com.example.hhj.loaderdemo.adapter.TestAdapter;
import com.example.hhj.loaderdemo.utils.DataUtil;

import java.util.ArrayList;

/**
 * Created by hhj on 2017/12/14.
 */

public class TestListFragmentPresenter extends BaseListFragmentPresenter<TestListFragment,TestAdapter,DataUtil.Data> {
    boolean init=false;
    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return new GridLayoutManager(getContext(),2);
    }

    @Override
    public void onCreate(TestListFragment view, Bundle savedInstanceState) {
        super.onCreate(view, savedInstanceState);
        onRefresh();
        Log.e("TestListFragment","onCreate---");
    }

    @Override
    public void onCreateView(TestListFragment view) {
        super.onCreateView(view);
        if(!init){
            getView().getList().setAdapter(getAdapter());
            init=true;
        }else {
            getAdapter().notifyDataSetChanged();
        }

        Log.e("TestListFragment","onCreateView---");




    }

    @Override
    public TestAdapter createAdapter() {
        return new TestAdapter(new ArrayList<DataUtil.Data>());
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        DataUtil.getDataList(getPage()).subscribe(getRefreshSubscriber());


    }

    @Override
    public void onLoadMoreRequested() {
        super.onLoadMoreRequested();
        DataUtil.getDataList(getPage()).subscribe(getMoreSubscriber());
    }
}
