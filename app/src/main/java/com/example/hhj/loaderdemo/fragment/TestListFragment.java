package com.example.hhj.loaderdemo.fragment;

import android.os.Bundle;

import com.example.hhj.loaderdemo.base.PresenterImp;
import com.example.hhj.loaderdemo.base.list.BaseListFragment;
import com.example.hhj.loaderdemo.presenter.TestListFragmentPresenter;

/**
 * Created by hhj on 2017/12/14.
 */
@PresenterImp(TestListFragmentPresenter.class)
public class TestListFragment extends BaseListFragment<TestListFragmentPresenter> {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
