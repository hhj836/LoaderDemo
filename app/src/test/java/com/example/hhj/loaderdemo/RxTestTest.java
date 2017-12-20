package com.example.hhj.loaderdemo;

import android.util.Log;

import org.junit.Test;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

import static org.junit.Assert.*;

/**
 * Created by hhj on 2017/12/18.
 */
public class RxTestTest {
    @Test
    public void testRx() throws Exception {
        System.out.print("testRx");
        Consumer consumer1=new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                System.out.print("consumer1");
            }
        };
        Consumer consumer2=new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                System.out.print("consumer2");
            }
        };

        PublishSubject observable=PublishSubject.create();
        observable.subscribe(consumer1);
        observable.subscribe(consumer2);
        observable.onNext("");
    }

}