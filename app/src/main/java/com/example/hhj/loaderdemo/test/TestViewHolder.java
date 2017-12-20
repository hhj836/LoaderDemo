package com.example.hhj.loaderdemo.test;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hhj.loaderdemo.R;
import com.example.hhj.loaderdemo.utils.DataUtil;

/**
 * Created by hhj on 2017/12/15.
 */

public class TestViewHolder extends com.jude.easyrecyclerview.adapter.BaseViewHolder<DataUtil.Data> {
    private TextView id;
    private TextView name;
    public TestViewHolder(ViewGroup parents) {
        super(parents, R.layout.test_list);
        id=$(R.id.id);
        name=$(R.id.name);
    }

    @Override
    public void setData(DataUtil.Data data) {
        super.setData(data);
        id.setText(data.id+"");
        name.setText(data.name+"-name");


    }
}
