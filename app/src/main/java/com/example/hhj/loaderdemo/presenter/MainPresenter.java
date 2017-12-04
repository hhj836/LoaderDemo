package com.example.hhj.loaderdemo.presenter;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.example.hhj.loaderdemo.MainActivity;

/**
 * @author 侯慧杰
 * @date 2017/12/4
 * @Description:
 */


public class MainPresenter implements Presenter<MainActivity> {
    int i=0;
    Handler handler=new Handler(Looper.getMainLooper());
    boolean isload;
    private MainActivity activity;
    boolean run=true;
    @Override
    public void onViewAttached(MainActivity mainActivity) {
        Log.e("MainPresenter","onViewAttached---");
        this.activity=mainActivity;
        if(!isload){
            new Thread(){
                @Override
                public void run() {
                    while (run){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        i++;
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                activity.showNum(i);
                                Log.e("MainPresenter","---"+i);
                            }
                        });

                    }
                }
            }.start();
            isload=true;
        }


    }

    @Override
    public void onViewDetached() {
        Log.e("MainPresenter","onViewDetached---");

    }

    @Override
    public void onDestroyed() {
        run=false;
        Log.e("MainPresenter","onViewDetached---");

    }
}
