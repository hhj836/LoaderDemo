package com.example.hhj.loaderdemo;

import android.util.Log;

import com.example.hhj.loaderdemo.utils.DataUtil;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

/**
 * Created by hhj on 2017/12/18.
 */

public class RxTest {
    public void testRx(){
        Consumer consumer1=new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                Log.d("Consumer","consumer1");
            }
        };
        Consumer consumer2=new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                Log.d("Consumer","consumer2");
            }
        };


        PublishSubject  observable=PublishSubject.create();
        observable.subscribe(consumer1);
        observable.subscribe(consumer2);

        AtomicReference<DataUtil.Data> data=new AtomicReference<>(new DataUtil.Data());



    }
}
