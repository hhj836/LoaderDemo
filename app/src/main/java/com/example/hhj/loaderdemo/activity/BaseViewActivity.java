package com.example.hhj.loaderdemo.activity;

import android.os.Bundle;

import com.example.hhj.loaderdemo.theme.base.BaseSkinActivity;

/**
 * Created by hhj on 2017/12/6.
 */

public abstract  class BaseViewActivity extends BaseSkinActivity{
    public abstract  int getLayoutId();
    public abstract  void initView();
    //title布局中添加其他布局
    public int getTitleContentResId(){
        return  0;
    }
    /**
     * 是否显示titlebar
     * @return
     */
    public  boolean  isShowTitle(){
        return  false;
    }
    /**
     * 是否包含titlebar
     * @return
     */
    public boolean isContainsCommonViews(){
        return  true;
    }
    /**
     * 是否滑动titlebar
     * @return
     */
    public boolean isSlideTitleBar(){
        return  false;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
