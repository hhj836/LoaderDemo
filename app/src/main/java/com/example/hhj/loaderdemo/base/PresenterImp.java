package com.example.hhj.loaderdemo.base;

import com.example.hhj.loaderdemo.presenter.Presenter;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by hhj on 2017/12/11.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface PresenterImp {
    Class<? extends Presenter> value();
}

