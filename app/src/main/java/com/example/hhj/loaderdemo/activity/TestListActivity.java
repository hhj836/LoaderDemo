package com.example.hhj.loaderdemo.activity;

import com.example.hhj.loaderdemo.base.BaseActivity;
import com.example.hhj.loaderdemo.base.PresenterImp;
import com.example.hhj.loaderdemo.presenter.TestListPresenter2;

/**
 * Created by hhj on 2017/12/14.
 */
@PresenterImp(TestListPresenter2.class)
public class TestListActivity extends BaseActivity<TestListPresenter2> {

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public boolean isSlideTitleBar() {
        return true;
    }
}
