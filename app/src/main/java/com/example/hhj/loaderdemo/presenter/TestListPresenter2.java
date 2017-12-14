package com.example.hhj.loaderdemo.presenter;

import android.os.Bundle;

import com.example.hhj.loaderdemo.R;
import com.example.hhj.loaderdemo.activity.TestListActivity;
import com.example.hhj.loaderdemo.fragment.TestListFragment;

/**
 * Created by hhj on 2017/12/14.
 */

public class TestListPresenter2 extends Presenter<TestListActivity> {
    TestListFragment testListFragment;
    @Override
    public void onCreate(TestListActivity view, Bundle savedInstanceState) {
        super.onCreate(view, savedInstanceState);
      /*  if(testListFragment==null){
            testListFragment=new TestListFragment();

        }*/
        getView().getSupportFragmentManager().beginTransaction().replace(R.id.fm_content_base,new TestListFragment()).commitAllowingStateLoss();
    }
}
