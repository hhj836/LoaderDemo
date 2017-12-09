package com.example.hhj.loaderdemo;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.hhj.loaderdemo.activity.CollapsingTestActivity;
import com.example.hhj.loaderdemo.base.BaseViewActivity;
import com.example.hhj.loaderdemo.presenter.MainPresenter;
import com.example.hhj.loaderdemo.presenter.Presenter;
import com.example.hhj.loaderdemo.presenter.PresenterLoader;
import com.example.hhj.loaderdemo.presenter.SomeFactoryImpl;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseViewActivity implements LoaderManager.LoaderCallbacks<MainPresenter> {
    static  final String TAG=MainActivity.class.getSimpleName();
    private static final int LOADER_ID = 101;
    private Presenter presenter;
    @BindView(R.id.tv)
    TextView  textView;
    @OnClick(R.id.btn)
    public void onBnClick(){
        startActivity(new Intent().setClass(MainActivity.this,CollapsingTestActivity.class));

    }
    @Override
    public boolean isSlideTitleBar() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }
    public void showNum(int num){
        textView.setText(num+"");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportLoaderManager().initLoader(LOADER_ID,null,MainActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"MainActivity--onResume");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG,"MainActivity--onSaveInstanceState");

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(TAG,"MainActivity--onRestoreInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,"MainActivity--onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG,"MainActivity--onStop");
        presenter.onViewDetached();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"MainActivity--onDestroy");
        if(isFinishing()){
            Log.e(TAG,"MainActivity--isFinishing");
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e(TAG,"MainActivity--onConfigurationChanged");
    }

    @Override
    public Loader<MainPresenter> onCreateLoader(int id, Bundle args) {
        Log.e(TAG,"MainActivity--onCreateLoader");
        return new PresenterLoader<>(this, new SomeFactoryImpl());
    }

    @Override
    public void onLoadFinished(Loader<MainPresenter> loader, MainPresenter data) {
        Log.e(TAG,"MainActivity--onLoadFinished");
                this.presenter=data;
        presenter.onViewAttached(this);

    }

    @Override
    public void onLoaderReset(Loader<MainPresenter> loader) {
        Log.e(TAG,"MainActivity--onLoaderReset");
        presenter.onDestroyed();
    }


}
