package com.example.hhj.loaderdemo.base;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.andexert.library.RippleView;
import com.example.hhj.loaderdemo.R;
import com.example.hhj.loaderdemo.theme.base.BaseSkinActivity;
import com.gyf.barlibrary.ImmersionBar;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;

/**
 * Created by hhj on 2017/12/6.
 */

public abstract  class BaseViewFragment extends RxFragment {



    private  ViewGroup baseView;
    public FragmentActivity mActivity;

    AppBarLayout appbar_base;
    FrameLayout fm_content_base;
    //按钮默认隐藏
    RippleView btn_left_base;
    RippleView btn_right_base;
    TextView tv_left_base;
    TextView   tv_right_base;
    TextView  tv_title_base;
    RelativeLayout rl_title_content_base;



    public abstract  int getLayoutId();
    public ViewGroup getBaseView() {
        return baseView;
    }
    //title布局中添加其他布局
    public int getTitleContentResId(){
        return  0;
    }
    /**
     * 是否显示titlebar
     * @return
     */
    public  boolean  isShowTitle(){
        return  true;
    }
    /**
     * 是否包含titlebar
     * @return
     */
    public boolean isContainsCommonViews(){
        return  false;
    }
    /**
     * 是否滑动titlebar
     * @return
     */
    public boolean isSlideTitleBar(){
        return  false;
    }

    @Override
    public void onAttach(Activity activity) {
        this.mActivity= (FragmentActivity) activity;
        super.onAttach(activity);

    }

    public void  disableTitleSlide(){
        if(appbar_base!=null&&appbar_base.getChildCount()>0&&appbar_base.getChildAt(0).getLayoutParams() instanceof AppBarLayout.LayoutParams){
            AppBarLayout.LayoutParams  layoutParams= (AppBarLayout.LayoutParams) appbar_base.getChildAt(0).getLayoutParams();
            layoutParams.setScrollFlags(0);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view=null;
        if(isContainsCommonViews()){
            view=inflater.inflate(R.layout.ac_base_view,null);
            appbar_base= view.findViewById(R.id.appbar_base);
            fm_content_base=  view.findViewById(R.id.fm_content_base);


            View titleView=View.inflate(mActivity,R.layout.base_title_view,null);
            addView(appbar_base,titleView);

            btn_left_base=  view.findViewById(R.id.btn_left_base);
            btn_left_base.setVisibility(View.INVISIBLE);
            btn_left_base.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
                @Override
                public void onComplete(RippleView rippleView) {
                    Toast.makeText(getContext(),"左边按钮点击",Toast.LENGTH_SHORT);
                }

            });
            btn_right_base=  view.findViewById(R.id.btn_right_base);
            btn_right_base.setVisibility(View.INVISIBLE);
            tv_left_base=  view.findViewById(R.id.tv_left_base);
            tv_right_base=  view.findViewById(R.id.tv_right_base);

            rl_title_content_base=  view.findViewById(R.id.rl_title_content_base);

            if(getTitleContentResId()!=0){
                View titleContent=mActivity.getLayoutInflater().inflate(getTitleContentResId(),null);
                rl_title_content_base.removeAllViews();
                addView(rl_title_content_base,titleContent);
            }else {
                tv_title_base=view.findViewById(R.id.tv_title_base);
            }
            if(getLayoutId()!=0){
                View content=getActivity().getLayoutInflater().inflate(getLayoutId(),null);
                fm_content_base.removeAllViews();
                fm_content_base.addView(content);
            }
            ButterKnife.bind(this,view);
            if(isShowTitle()){
                setTitleVisible();
            }else {
                setTitleGone();
            }
            if(!isSlideTitleBar()){
                disableTitleSlide();
            }
        }else {
            view=inflater.inflate(getLayoutId(),null);
            ButterKnife.bind(this,view);
        }
        baseView= (ViewGroup) view;

      //  initView();
        return view;
    }
    public void setTitleVisible(){
        appbar_base.setVisibility(View.VISIBLE);
    }
    public void setTitleGone(){
        appbar_base.setVisibility(View.GONE);
    }
    private void addView(ViewGroup parent,View child){
        parent.addView(child,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

    }
    public BaseViewFragment setBtnRightText(String s){
        btn_right_base.setVisibility(View.VISIBLE);
        tv_right_base.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        tv_right_base.setText(s);
        return  BaseViewFragment.this;


    }
    public BaseViewFragment setBtnRightImgRes(int res){
        btn_right_base.setVisibility(View.VISIBLE);
        tv_right_base.setBackgroundResource(res);
        tv_right_base.setText("");
        return  BaseViewFragment.this;
    }
    public BaseViewFragment setBtnLeftText(String s){
        tv_left_base.setBackground(new ColorDrawable(Color.TRANSPARENT));
        tv_left_base.setText(s);
        return  BaseViewFragment.this;

    }
    public BaseViewFragment setBtnLeftImgRes(int res){
        tv_left_base.setBackgroundResource(res);
        tv_left_base.setText("");
        return  BaseViewFragment.this;

    }
    public BaseViewFragment setOnBtnRightClickListener(RippleView.OnRippleCompleteListener onRippleCompleteListener){
        btn_right_base.setVisibility(View.VISIBLE);
        btn_right_base.setOnRippleCompleteListener(onRippleCompleteListener);
        return  BaseViewFragment.this;
    }
    public BaseViewFragment setOnBtnLeftClickListener(RippleView.OnRippleCompleteListener onRippleCompleteListener){
        btn_left_base.setOnRippleCompleteListener(onRippleCompleteListener);
        return  BaseViewFragment.this;
    }
}
