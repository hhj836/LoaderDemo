package com.example.hhj.loaderdemo.fragment;

import android.os.Bundle;

import com.example.hhj.loaderdemo.base.PresenterImp;
import com.example.hhj.loaderdemo.base.list.BaseListFragment;
import com.example.hhj.loaderdemo.event.TestEvent;
import com.example.hhj.loaderdemo.presenter.TestListFragmentPresenter;
import com.example.hhj.loaderdemo.utils.RxBus;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by hhj on 2017/12/14.
 */
@PresenterImp(TestListFragmentPresenter.class)
public class TestListFragment extends BaseListFragment<TestListFragmentPresenter> {
    private int  i=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TestEvent  testEvent=new TestEvent();
        testEvent.name=++i+"--哈哈哈";
        RxBus.getInstance().post(testEvent);


    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
