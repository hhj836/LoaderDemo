package com.example.hhj.loaderdemo.test;

import android.support.annotation.NonNull;

import com.example.hhj.loaderdemo.utils.DataUtil;
import com.jude.beam.expansion.list.BeamListActivityPresenter;
import com.jude.beam.expansion.list.BeamListFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;


/**
 * Created by hhj on 2017/12/15.
 */

public class TestBeanPresenter extends BeamListActivityPresenter<TestBeamActivity,DataUtil.Data> {
    @Override
    protected void onCreateView(@NonNull TestBeamActivity view) {
        super.onCreateView(view);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        List<DataUtil.Data> list=new ArrayList<>();
        for(int i=0;i<100;i++){
            DataUtil.Data data=new DataUtil.Data();
            data.id=i;
            data.name=i+"";
            list.add(data);
        }
        Observable.just(list).subscribe(getRefreshSubscriber());
    }
}
