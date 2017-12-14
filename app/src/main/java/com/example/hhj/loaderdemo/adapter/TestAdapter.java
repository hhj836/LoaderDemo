package com.example.hhj.loaderdemo.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.hhj.loaderdemo.R;
import com.example.hhj.loaderdemo.utils.DataUtil;

import java.util.List;

/**
 * Created by hhj on 2017/12/14.
 */

public class TestAdapter extends BaseQuickAdapter<DataUtil.Data,BaseViewHolder> {
    public TestAdapter(@Nullable List<DataUtil.Data> data) {
        super(R.layout.test_list, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, DataUtil.Data item) {
        helper.setText(R.id.id,item.id+"").setText(R.id.name,item.name);

    }
}
