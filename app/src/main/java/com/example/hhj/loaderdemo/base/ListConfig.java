package com.example.hhj.loaderdemo.base;

/**
 * Created by hhj on 2017/12/13.
 */

public class ListConfig {
    public boolean enableRefresh=true;
    public boolean enableLoadMore=true;
    public int emptyLayoutResId;
    public int netErrorResId;


    public ListConfig setEnableRefresh(boolean refresh){
        this.enableRefresh=refresh;
        return ListConfig.this;
    }

    public ListConfig setEnableLoadMore(boolean loadMore){
        this.enableLoadMore=loadMore;
        return ListConfig.this;
    }
    public ListConfig setEmptyLayoutResId(int resId){
        this.emptyLayoutResId=resId;
        return ListConfig.this;
    }
    public ListConfig setNetErrorResId(int resId){
        this.netErrorResId=resId;
        return ListConfig.this;
    }

}
