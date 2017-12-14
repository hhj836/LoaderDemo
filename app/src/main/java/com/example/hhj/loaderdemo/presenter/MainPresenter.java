package com.example.hhj.loaderdemo.presenter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.example.hhj.loaderdemo.MainActivity;
import com.example.hhj.loaderdemo.R;
import com.example.hhj.loaderdemo.fragment.FragmentMain;

/**
 * @author 侯慧杰
 * @date 2017/12/4
 * @Description:
 */


public class MainPresenter extends Presenter<MainActivity> {
    int i=0;
    Handler handler=new Handler(Looper.getMainLooper());
    boolean isload=true;
    boolean run=true;
    public void  someMethod(){

    }
    @Override
    public void onCreate(MainActivity mainActivity,Bundle bundle) {
        super.onCreate(mainActivity,bundle);
        if(bundle!=null){
            i=bundle.getInt("i");
        }



    }
    @Override
    public void onCreateView(MainActivity mainActivity) {
        super.onCreateView(mainActivity);
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
                                getView().showNum(i);
                            }
                        });

                    }
                }
            }.start();
            isload=true;
        }


    }

    @Override
    public void onSaveData(Bundle data) {
        data.putInt("i",i);
    }

    @Override
    public void onDestroyed() {
        run=false;


    }
}
