package com.example.hhj.loaderdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.hhj.loaderdemo.presenter.Presenter;
import com.example.hhj.loaderdemo.presenter.ViewHelper;

/**
 * Created by hhj on 2017/12/11.
 */

public  abstract class BaseFragment<P extends Presenter> extends BaseViewFragment {
    private ViewHelper<P,BaseFragment>  viewHelper=new ViewHelper(BaseFragment.this);
    public P getPresenter(){
        return viewHelper.getPresenter();
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //不要在onCreate初始化loader 防止多个fragment 共享一个loader
        viewHelper.onCreate(getLoaderManager(),mActivity,savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        viewHelper.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        viewHelper.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        viewHelper.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        viewHelper.onSaveData(outState);
    }


}
