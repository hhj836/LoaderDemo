package com.example.hhj.loaderdemo.presenter;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;


/**
 * Created by hhj on 2017/12/11.
 */

public class ViewHelper<P extends Presenter> implements LoaderManager.LoaderCallbacks<P> {
    public static final String PRESENTER_ID = "presenter_id";
    private   int LOADER_ID= (int) System.currentTimeMillis();

    P presenter;
    public P getPresenter() {
        return presenter;
    }
    public void onCreate(LoaderManager loaderManager,Context context,Bundle savedInstanceState){
        this.context=context;
        Log.e("ViewHelper","onCreate---"+view.getClass().getSimpleName());
        if(savedInstanceState!=null&&savedInstanceState.containsKey(PRESENTER_ID)){
            LOADER_ID=savedInstanceState.getInt(PRESENTER_ID);
        }

        loaderManager.initLoader(LOADER_ID,savedInstanceState,ViewHelper.this);
    }
    public void onPostCreate(){
        presenter.onCreateView(view);
        Log.e("ViewHelper","onPostCreate---"+view.getClass().getSimpleName());

    }
    public void onResume(){
        presenter.onResume();
    }
    public void onPause(){
        presenter.onPause();
    }
    public void onStop(){
        presenter.onStop();
    }


    public void onSaveData(Bundle outState){
        outState.putInt(PRESENTER_ID,LOADER_ID);
        presenter.onSaveData(outState);

    }

    Object view;
    Context context;


    public ViewHelper(Object view){
        this.view=view;

    }

    @Override
    public Loader<P> onCreateLoader(int id, Bundle args) {

        return  new PresenterLoader(context,view,args);
    }

    @Override
    public void onLoadFinished(Loader<P> loader, P data) {
        Log.e("ViewHelper","onLoadFinished---"+view.getClass().getSimpleName());
        presenter=data;
    }

    @Override
    public void onLoaderReset(Loader<P> loader) {

    }
}
