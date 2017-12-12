package com.example.hhj.loaderdemo.presenter;

import android.os.Bundle;
import android.util.Log;

import com.example.hhj.loaderdemo.fragment.FragmentMain;

/**
 * Created by hhj on 2017/12/11.
 */

public class MainFragmentPresenter extends Presenter<FragmentMain> {
    @Override
    public void onCreate(FragmentMain view, Bundle bundle) {
        super.onCreate(view,bundle);
        Log.e("MainFragmentPresenter","onCreate");
    }

    @Override
    public void onCreateView(FragmentMain view) {
        super.onCreateView(view);
        Log.e("MainFragmentPresenter","onCreateView");
    }
}
