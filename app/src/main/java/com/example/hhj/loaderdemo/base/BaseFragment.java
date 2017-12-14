package com.example.hhj.loaderdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.hhj.loaderdemo.presenter.Presenter;
import com.example.hhj.loaderdemo.presenter.ViewHelper;

/**
 * Created by hhj on 2017/12/11.
 */

public  abstract class BaseFragment<P extends Presenter> extends BaseViewFragment {
    private ViewHelper<P>  viewHelper=new ViewHelper(BaseFragment.this);
    public P getPresenter(){
        return viewHelper.getPresenter();
    }
    boolean isLoaderInit=false;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(!isLoaderInit){
            viewHelper.onCreate(getLoaderManager(),mActivity,savedInstanceState);
            isLoaderInit=true;
        }

    }

    @Override
    public void onStart() {
        super.onStart();

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
