package com.example.hhj.loaderdemo.presenter;
import android.os.Bundle;
import com.example.hhj.loaderdemo.R;
import com.example.hhj.loaderdemo.activity.TestListActivity;
import com.example.hhj.loaderdemo.fragment.TestListFragment;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by hhj on 2017/12/14.
 */

public class TestListPresenter2 extends Presenter<TestListActivity> {
    RecyclerArrayAdapter recyclerArrayAdapter;
    @Override
    public void onCreate(TestListActivity view, Bundle savedInstanceState) {
        super.onCreate(view, savedInstanceState);

    }

    @Override
    public void onCreateView(TestListActivity view) {

        super.onCreateView(view);
      /*  if(recyclerArrayAdapter==null){
            recyclerArrayAdapter=new RecyclerArrayAdapter(view) {
                @Override
                public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                    return new TestViewHolder(parent);
                }
            };
        }

        getView().getListView().setAdapter(recyclerArrayAdapter);
        List<DataUtil.Data> list=new ArrayList<>();
        for(int i=0;i<100;i++){
            DataUtil.Data data=new DataUtil.Data();
            data.id=i;
            data.name=i+"";
            list.add(data);
        }
        recyclerArrayAdapter.addAll(list);*/

    }
}
