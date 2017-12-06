package com.example.hhj.loaderdemo;

import android.content.res.Configuration;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.hhj.loaderdemo.presenter.MainPresenter;
import com.example.hhj.loaderdemo.presenter.Presenter;
import com.example.hhj.loaderdemo.presenter.PresenterLoader;
import com.example.hhj.loaderdemo.presenter.SomeFactoryImpl;
import com.example.hhj.loaderdemo.theme.base.BaseSkinActivity;

public class MainActivity extends BaseSkinActivity implements LoaderManager.LoaderCallbacks<MainPresenter> {
    static  final String TAG=MainActivity.class.getSimpleName();
    private static final int LOADER_ID = 101;
    private Presenter presenter;
    TextView  textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) findViewById(R.id.tv);
        if(savedInstanceState==null){
            Log.e(TAG,"MainActivity--初始化");
        }else {
            Log.e(TAG,"savedInstanceState--非空");
        }
        getSupportLoaderManager().initLoader(LOADER_ID, null, this);
    }
    public void showNum(int num){
        textView.setText(num+"");
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
