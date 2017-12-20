package com.example.hhj.loaderdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.hhj.loaderdemo.activity.TestListActivity;
import com.example.hhj.loaderdemo.base.BaseActivity;
import com.example.hhj.loaderdemo.base.PresenterImp;
import com.example.hhj.loaderdemo.event.TestEvent;
import com.example.hhj.loaderdemo.fragment.FragmentMain;
import com.example.hhj.loaderdemo.presenter.MainPresenter;
import com.example.hhj.loaderdemo.utils.RxBus;
import com.trello.rxlifecycle2.android.ActivityEvent;


import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

@PresenterImp(MainPresenter.class)
public class MainActivity extends BaseActivity<MainPresenter>  {
    static  final String TAG=MainActivity.class.getSimpleName();
    @BindView(R.id.tv)
    TextView  textView;
    @BindView(R.id.content)
    FrameLayout content;
    @OnClick(R.id.btn)
    public void onBtnClick(){
       // RxBus.getInstance().post("");
      startActivity(new Intent().setClass(MainActivity.this, TestListActivity.class));

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new RxBus.EventObserverBuilder<TestEvent>().create(this.bindUntilEvent(ActivityEvent.PAUSE)).setConsumer(new Consumer<TestEvent>() {
            @Override
            public void accept(TestEvent testEvent) throws Exception {
                textView.setText(testEvent.name);

            }
        }).build(TestEvent.class);
        if(savedInstanceState==null){
               getSupportFragmentManager().beginTransaction().replace(R.id.content,new FragmentMain()).commit();
        }
        final BehaviorSubject<String> sb=BehaviorSubject.create();

      final Observable  ob=  sb.filter(new Predicate<String>() {
            @Override
            public boolean test(@NonNull String s) throws Exception {
                return s.equals("1");
            }
        });
         ObservableTransformer trans=new ObservableTransformer() {
             @Override
             public ObservableSource apply(@NonNull Observable upstream) {
                 Log.d("trans","trans--apply");
                 return upstream.takeUntil(ob);
             }
         };
   /*     sb.onNext("2");
        Observable.just("haha").doOnNext(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d("trans","trans--doOnNext");
            }
        }).compose(trans).subscribe(new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Object o) {
                Log.d("trans","trans--"+o.toString());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("trans","trans--"+e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d("trans","trans--onComplete");
            }
        });*/
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> e) throws Exception {

            }
        }).subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {

            }
        });
        Observable.just(1l,2l).compose(trans).doOnNext(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                Log.d("trans","接收数据--"+aLong);
                Thread.sleep(5000);
                Log.d("trans","睡眠完毕--"+aLong);


            }
        }).doOnNext(new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                Log.d("trans","doOnNext2--"+o.toString());
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Object o) {
                Log.d("trans","onNext--"+o.toString());

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("trans","onError--"+e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d("trans","trans--onComplete");
            }
        });
        Observable.timer(2,TimeUnit.SECONDS).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                sb.onNext("1");
                Log.d("trans","onNext--结束");
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();



    }

    @Override
    public boolean isSlideTitleBar() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    public void showNum(int num){
        textView.setText(num+"");
    }



}
