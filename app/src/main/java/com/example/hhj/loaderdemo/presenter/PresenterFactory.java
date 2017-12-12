package com.example.hhj.loaderdemo.presenter;

import android.os.Bundle;

/**
 * @author 侯慧杰
 * @date 2017/12/4
 * @Description:
 */


public interface PresenterFactory<T extends Presenter,IView> {
    T create(IView view,Bundle bundle);
}