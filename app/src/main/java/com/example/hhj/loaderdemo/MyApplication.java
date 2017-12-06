package com.example.hhj.loaderdemo;

import android.app.Application;

import com.example.hhj.loaderdemo.theme.SkinManager;

/**
 * @author 侯慧杰
 * @date 2017/11/26
 * @Description:
 */


public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SkinManager.getInstance().init(this);
    }
}
