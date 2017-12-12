package com.example.hhj.loaderdemo.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;

import com.example.hhj.loaderdemo.presenter.MainFragmentPresenter;
import com.example.hhj.loaderdemo.presenter.Presenter;
import com.example.hhj.loaderdemo.presenter.PresenterLoader;
import com.example.hhj.loaderdemo.presenter.ViewHelper;

/**
 * Created by hhj on 2017/12/11.
 */

public abstract  class BaseActivity<P extends Presenter> extends BaseViewActivity {
    private ViewHelper<P> viewHelper=new ViewHelper(BaseActivity.this);
    public P getPresenter(){
        return viewHelper.getPresenter();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewHelper.onCreate(getSupportLoaderManager(),BaseActivity.this,savedInstanceState);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        viewHelper.onPostCreate();

    }

    @Override
    protected void onResume() {
        super.onResume();
        viewHelper.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewHelper.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewHelper.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        viewHelper.onSaveData(outState);
    }
}
