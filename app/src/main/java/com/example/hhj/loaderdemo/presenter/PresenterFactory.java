package com.example.hhj.loaderdemo.presenter;

/**
 * @author 侯慧杰
 * @date 2017/12/4
 * @Description:
 */


public interface PresenterFactory<T extends Presenter> {
    T create();
}