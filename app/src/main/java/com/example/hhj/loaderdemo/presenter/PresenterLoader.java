package com.example.hhj.loaderdemo.presenter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.util.Log;

import com.example.hhj.loaderdemo.base.PresenterUtils;

/**
 * @author 侯慧杰
 * @date 2017/12/4
 * @Description:
 */


public class PresenterLoader<P extends Presenter> extends Loader<P> {

    private P presenter;
    private Object view;
    private  Bundle bundle;
    public  P getPresenter(){
        return  presenter;
    }
    /**
     * Stores away the application context associated with context.
     * Since Loaders can be used across multiple activities it's dangerous to
     * store the context directly; always use {@link #getContext()} to retrieve
     * the Loader's Context, don't use the constructor argument directly.
     * The Context returned by {@link #getContext} is safe to use across
     * Activity instances.
     *
     * @param context used to retrieve the application context.
     */
    public PresenterLoader(Context context,Object view,Bundle bundle) {
        super(context);
        this.view=view;
        this.bundle=bundle;
    }

    // 省略构造方法

    @Override
    protected void onStartLoading() {

        // 如果已经有Presenter实例那就直接返回
        if (presenter != null) {
            deliverResult(presenter);
            return;
        }

        // 如果没有
        forceLoad();
    }
    @Override
    protected void onForceLoad() {
        // 通过工厂来实例化Presenter
      //  presenter = factory.create(view,bundle);
        presenter= PresenterUtils.fromViewClass(view.getClass());
        presenter.onCreate(view,bundle);
        // 返回Presenter
        deliverResult(presenter);
    }

    @Override
    protected void onReset() {
        presenter.onDestroyed();
        presenter = null;
    }
}
