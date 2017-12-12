package com.example.hhj.loaderdemo.base;

import com.example.hhj.loaderdemo.presenter.Presenter;

/**
 * Created by hhj on 2017/12/11.
 */

public class PresenterUtils  {
    public static <PresenterType extends Presenter> PresenterType fromViewClass(Class<?> viewClass) {
        PresenterImp annotation = viewClass.getAnnotation(PresenterImp.class);
        //noinspection unchecked
        if (annotation == null){

            throw new RuntimeException("You must declaration @PresenterImp for your View");
           // return null;

        }

        Class<PresenterType> presenterClass =  (Class<PresenterType>)annotation.value();

        PresenterType presenter;
        try {
            presenter = presenterClass.newInstance();
        }
        catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
        catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return presenter;
    }
}
