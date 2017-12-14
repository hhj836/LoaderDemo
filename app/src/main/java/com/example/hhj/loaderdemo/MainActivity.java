package com.example.hhj.loaderdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.hhj.loaderdemo.activity.TestListActivity;
import com.example.hhj.loaderdemo.base.BaseActivity;
import com.example.hhj.loaderdemo.base.PresenterImp;
import com.example.hhj.loaderdemo.fragment.FragmentMain;
import com.example.hhj.loaderdemo.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.OnClick;
@PresenterImp(MainPresenter.class)
public class MainActivity extends BaseActivity<MainPresenter>  {
    static  final String TAG=MainActivity.class.getSimpleName();
    @BindView(R.id.tv)
    TextView  textView;
    @BindView(R.id.content)
    FrameLayout content;
    @OnClick(R.id.btn)
    public void onBtnClick(){
      startActivity(new Intent().setClass(MainActivity.this, TestListActivity.class));

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null){
               getSupportFragmentManager().beginTransaction().replace(R.id.content,new FragmentMain()).commit();
        }
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
