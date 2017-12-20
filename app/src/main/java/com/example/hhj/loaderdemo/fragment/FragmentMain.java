package com.example.hhj.loaderdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.Loader;

import com.example.hhj.loaderdemo.R;
import com.example.hhj.loaderdemo.base.BaseFragment;
import com.example.hhj.loaderdemo.base.PresenterImp;
import com.example.hhj.loaderdemo.presenter.MainFragmentPresenter;
import com.example.hhj.loaderdemo.utils.RxBus;
import com.trello.rxlifecycle2.android.FragmentEvent;

import java.util.Objects;

import io.reactivex.functions.Consumer;

/**
 * Created by hhj on 2017/12/11.
 */
@PresenterImp(MainFragmentPresenter.class)
public class FragmentMain extends BaseFragment<MainFragmentPresenter> {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public boolean isContainsCommonViews() {
        return super.isContainsCommonViews();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fm_main;
    }

}
