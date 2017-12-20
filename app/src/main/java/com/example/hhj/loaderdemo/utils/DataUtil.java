package com.example.hhj.loaderdemo.utils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;

/**
 * Created by hhj on 2017/12/14.
 */

public class DataUtil {
    public static final  int PAGER_SIZE=100;
    public static Observable<List<Data>> getDataList(int page){
        if(page>3){
            return Observable.create(new ObservableOnSubscribe<List<Data>>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<List<Data>> e) throws Exception {
                            e.onNext(new ArrayList<Data>());
                }
            });
        }

        List<Data>  dataList=new ArrayList<>();
        for(int i=page*PAGER_SIZE;i<page*PAGER_SIZE+PAGER_SIZE;i++){
            Data data=new Data();
            data.id=i;
            data.name=i+"-name";
            dataList.add(data);

        }

        return Observable.just(dataList);
        }


    public static class Data{
        public int id;
        public String name;

    }
}
