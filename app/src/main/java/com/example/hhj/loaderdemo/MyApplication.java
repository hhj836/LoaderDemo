package com.example.hhj.loaderdemo;

import android.app.Application;

import com.example.hhj.loaderdemo.theme.SkinManager;

/**
 * @author 侯慧杰
 * @date 2017/11/26
 * @Description:
 */


public class MyApplication extends Application {
    private   static  MyApplication instance;
    public static MyApplication getInstance(){
        return  instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        SkinManager.getInstance().init(this);
    }
}
