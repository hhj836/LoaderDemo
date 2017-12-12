package com.example.hhj.loaderdemo.presenter;

import android.os.Bundle;

/**
 * @author 侯慧杰
 * @date 2017/12/4
 * @Description:
 */


public class Presenter <ViewType> {
    ViewType view;
    public ViewType getView(){
        return  view;
    };
    public void onCreate(ViewType view,Bundle savedInstanceState){
        this.view=view;

    };
    public void onCreateView(ViewType view){
        this.view=view;
    };
    public void onResume(){}
    public void onSaveData(Bundle outState){}
    public void onPause(){}
    public void onStop(){}
    public void onDestroyed(){};

}
