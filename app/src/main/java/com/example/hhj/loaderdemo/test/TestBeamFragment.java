package com.example.hhj.loaderdemo.test;

import android.view.ViewGroup;

import com.example.hhj.loaderdemo.utils.DataUtil;
import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListFragment;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by hhj on 2017/12/15.
 */
@RequiresPresenter(TestBeanPresenter.class)
public class TestBeamFragment extends BeamListFragment {
    @Override
    protected BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        return new TestViewHolder(parent);
    }
}
