package com.example.hhj.loaderdemo.presenter;
import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.hhj.loaderdemo.MyApplication;
import com.example.hhj.loaderdemo.base.BaseActivity;
import com.example.hhj.loaderdemo.base.BaseFragment;
import com.example.hhj.loaderdemo.base.BaseListActivity;
import com.example.hhj.loaderdemo.utils.DataUtil;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by hhj on 2017/12/13.
 */

public abstract  class BaseListPresenter<ViewType extends BaseListActivity,AdapterType extends BaseQuickAdapter,M> extends Presenter<ViewType>
implements BaseQuickAdapter.RequestLoadMoreListener,SwipeRefreshLayout.OnRefreshListener{


    AdapterType adapter;
    private int page=0;
    public int getPage(){
        return  page;
    }
    public abstract RecyclerView.LayoutManager getLayoutManager();
    Observer<List<M>> mMoreSubscriber = new Observer<List<M>>() {

        @Override
        public void onError(Throwable e) {
            adapter.loadMoreComplete();
            Toast.makeText(MyApplication.getInstance(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onComplete() {

        }


        @Override
        public void onSubscribe(@NonNull Disposable d) {

        }

        @Override
        public void onNext(List<M> ms) {
            if(ms.size()>0){
                adapter.getData().addAll(ms);
                adapter.loadMoreComplete();
                page++;
            }
            if(ms.size()< DataUtil.PAGER_SIZE){
                adapter.loadMoreEnd();
            }

        }
    };

    Observer<List<M>> mRefreshSubscriber = new Observer<List<M>>() {

        @Override
        public void onError(Throwable e) {
            getView().stopRefresh();
            Toast.makeText(MyApplication.getInstance(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onComplete() {

        }


        @Override
        public void onSubscribe(@NonNull Disposable d) {

        }

        @Override
        public void onNext(List<M> ms) {
            getView().stopRefresh();
            adapter.getData().clear();
            if(ms.size()>0){
                adapter.setNewData(ms);
                page = 1;
            }else {
                getView().showEmpty();
            }


        }

    };
    public class  TipSpanSizeLookUp extends GridLayoutManager.SpanSizeLookup{
        @Override
        public int getSpanSize(int position) {
            if (position < adapter.getHeaderLayoutCount()||position>=adapter.getData().size()+adapter.getHeaderLayoutCount()) {
                return 2;
            }else{
                //默认该Content item占1格
                return 1;
            }
        }
    }
    @Override
    public void onCreate(ViewType view, Bundle savedInstanceState) {
        super.onCreate(view, savedInstanceState);
        if(adapter==null){
            adapter=createAdapter();
        }




    }

    @Override
    public void onCreateView(ViewType view) {
        super.onCreateView(view);
        RecyclerView.LayoutManager layoutManager=getLayoutManager();
        if(layoutManager instanceof GridLayoutManager){
            GridLayoutManager manager= (GridLayoutManager) layoutManager;
            manager.setSpanSizeLookup(new TipSpanSizeLookUp());
        }
        getView().getList().setLayoutManager(layoutManager);
    }

    public  AdapterType getAdapter(){
        if(adapter==null){
            adapter=createAdapter();
        }
        return  adapter;
    }
    public abstract AdapterType createAdapter();

    public Observer getMoreSubscriber(){

       return  mMoreSubscriber;


    }
    public Observer getRefreshSubscriber(){
        return  mRefreshSubscriber;

    }
    public void setOnItemClickListener(BaseQuickAdapter.OnItemClickListener onItemClickListener){
        adapter.setOnItemClickListener(onItemClickListener);

    }
    public void setOnItemChildLickListener(BaseQuickAdapter.OnItemChildClickListener onItemChildLickListener){
        adapter.setOnItemChildClickListener(onItemChildLickListener);
    }
    @Override
    public void onRefresh() {
        page=0;
    }

    @Override
    public void onLoadMoreRequested() {

    }
    public Context getContext(){
        if(getView() instanceof BaseActivity){
            return getView();
        }
        return  null;
    }
}
