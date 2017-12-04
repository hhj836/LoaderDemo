package com.example.hhj.loaderdemo.presenter;

/**
 * @author 侯慧杰
 * @date 2017/12/4
 * @Description:
 */


public class SomeFactoryImpl implements PresenterFactory<MainPresenter> {
    @Override
    public MainPresenter create() {
        return new MainPresenter();
    }
}
