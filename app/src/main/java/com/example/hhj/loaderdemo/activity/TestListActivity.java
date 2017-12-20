package com.example.hhj.loaderdemo.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.hhj.loaderdemo.R;
import com.example.hhj.loaderdemo.base.BaseActivity;
import com.example.hhj.loaderdemo.base.PresenterImp;
import com.example.hhj.loaderdemo.fragment.TestListFragment;
import com.example.hhj.loaderdemo.presenter.TestListPresenter2;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.trello.rxlifecycle2.LifecycleTransformer;

import io.reactivex.Observable;

/**
 * Created by hhj on 2017/12/14.
 */
@PresenterImp(TestListPresenter2.class)
public class TestListActivity extends BaseActivity<TestListPresenter2> {
    @Override
    public boolean isContainsCommonViews() {
        return false;
    }

    public EasyRecyclerView getListView() {
        return mListView;
    }

    private EasyRecyclerView mListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction().replace(R.id.fm_content_base,new TestListFragment()).commitAllowingStateLoss();
    }

    @Override
    public int getLayoutId() {
        return R.layout.ac_base_view;
    }
/*
    @Override
    public View getContentView() {
        mListView = new EasyRecyclerView(this);
        mListView.setId(com.jude.beam.R.id.recycler);
        mListView.setLayoutManager(new LinearLayoutManager(this));
        mListView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return mListView;
    }*/
}
