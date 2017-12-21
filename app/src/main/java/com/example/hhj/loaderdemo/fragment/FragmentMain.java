package com.example.hhj.loaderdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.Loader;
import android.util.Log;

import com.example.hhj.loaderdemo.R;
import com.example.hhj.loaderdemo.base.BaseFragment;
import com.example.hhj.loaderdemo.base.PresenterImp;
import com.example.hhj.loaderdemo.presenter.MainFragmentPresenter;
import com.example.hhj.loaderdemo.utils.RxBus;
import com.trello.rxlifecycle2.android.FragmentEvent;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by hhj on 2017/12/11.
 */
@PresenterImp(MainFragmentPresenter.class)
public class FragmentMain extends BaseFragment<MainFragmentPresenter> {
    final static String TAG="takeUntil";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final BehaviorSubject<String> sb=BehaviorSubject.create();
        final Observable<String> ob=  sb.filter(new Predicate<String>() {
            @Override
            public boolean test(@NonNull String s) throws Exception {
                return s.equals("stop");
            }
        });
        ObservableTransformer<String,String> takeUntilTransformer=new ObservableTransformer<String,String>() {
            @Override
            public ObservableSource<String> apply(@NonNull Observable<String> upstream) {
                return upstream.takeUntil(ob);
            }
        };
        Observable.just("data").doOnNext(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG,"第一个doOnNext---睡眠");
                  Thread.sleep(5000);
                Log.d(TAG,"第一个doOnNext---醒来");

            }
        }).doOnNext(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG,"第二个doOnNext---");

            }
        }).compose(takeUntilTransformer).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                Log.d(TAG,"subscribe---onNext---");
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d(TAG,"subscribe---onComplete---");

            }
        });
        Observable.timer(2, TimeUnit.SECONDS).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                sb.onNext("stop");
                Log.d(TAG,"发射-stop");
            }
        });






    }

    @Override
    public boolean isContainsCommonViews() {
        return super.isContainsCommonViews();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fm_main;
    }

}
