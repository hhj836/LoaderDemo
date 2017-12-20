package com.example.hhj.loaderdemo.test;

import android.view.ViewGroup;

import com.example.hhj.loaderdemo.utils.DataUtil;
import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListActivity;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by hhj on 2017/12/15.
 */
@RequiresPresenter(TestBeanPresenter.class)
public class TestBeamActivity extends BeamListActivity<TestBeanPresenter,DataUtil.Data>{
    @Override
    protected BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        return new TestViewHolder(parent);
    }
}
