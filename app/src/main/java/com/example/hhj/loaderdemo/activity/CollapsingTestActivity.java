package com.example.hhj.loaderdemo.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import com.example.hhj.loaderdemo.R;
import com.example.hhj.loaderdemo.base.BaseViewActivity;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.BindView;

/**
 * Created by hhj on 2017/12/7.
 */

public class CollapsingTestActivity extends BaseViewActivity {
    @BindView(R.id.searchView)
    SearchView searchView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Override
    public boolean isContainsCommonViews() {
        return false;
    }

    @Override
    public boolean isAutoSetStatusBarColor() {
        return false;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.ac_collapsing_test;
    }

    /*@Override
    public void initView() {
        ImmersionBar.with(this).transparentStatusBar()
               .titleBar(toolbar).init();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsingToolbarLayout.setTitle("title");

    }*/
}
