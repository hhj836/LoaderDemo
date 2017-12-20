package com.example.hhj.loaderdemo.base;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.example.hhj.loaderdemo.R;
import com.example.hhj.loaderdemo.theme.base.BaseSkinActivity;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.ButterKnife;

/**
 * Created by hhj on 2017/12/6.
 */

public abstract  class BaseViewActivity extends BaseSkinActivity {
    AppBarLayout appbar_base;
    FrameLayout fm_content_base;

    RippleView btn_left_base;
    RippleView btn_right_base;//右按钮默认隐藏
    TextView tv_left_base;
    TextView   tv_right_base;
    TextView  tv_title_base;
    RelativeLayout rl_title_content_base;



    public abstract  int getLayoutId();
    //app bar 布局内容。如图：片沉浸式
    @Deprecated
    public int getAppBarContentResId(){

        return  0;
    }
    public View  getContentView(){
        return  null;
    }
    /**
     * 是否设置系统栏颜色
     * @return
     */
    public boolean isAutoSetStatusBarColor(){
        return  true;
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
        return  true;
    }
    /**
     * 是否滑动titlebar
     * @return
     */
    public boolean isSlideTitleBar(){
        return  false;
    }
    public void  disableTitleSlide(){
        if(appbar_base!=null&&appbar_base.getChildCount()>0&&appbar_base.getChildAt(0).getLayoutParams() instanceof AppBarLayout.LayoutParams){
            AppBarLayout.LayoutParams  layoutParams= (AppBarLayout.LayoutParams) appbar_base.getChildAt(0).getLayoutParams();
            layoutParams.setScrollFlags(0);
        }

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(isAutoSetStatusBarColor()){
            ImmersionBar.with(this)
                    .statusBarColor(R.color.colorPrimary)
                    .fitsSystemWindows(true).init();

        }
        if(isContainsCommonViews()){
            setContentView(R.layout.ac_base_view);
            fm_content_base= findViewById(R.id.fm_content_base);
            appbar_base=  findViewById(R.id.appbar_base);
            if(getAppBarContentResId()!=0){
                View appbarContent=View.inflate(BaseViewActivity.this,getAppBarContentResId(),null);
                addView(appbar_base,appbarContent);
            }else {
                View titleView=View.inflate(BaseViewActivity.this,R.layout.base_title_view,null);
                addView(appbar_base,titleView);
                btn_left_base=  findViewById(R.id.btn_left_base);
                btn_left_base.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
                    @Override
                    public void onComplete(RippleView rippleView) {
                       // finish();
                    }
                });
                btn_right_base= findViewById(R.id.btn_right_base);
                tv_left_base= findViewById(R.id.tv_left_base);

                tv_right_base=  findViewById(R.id.tv_right_base);
                tv_title_base=  findViewById(R.id.tv_title_base);
                rl_title_content_base=  findViewById(R.id.rl_title_content_base);
                if(getTitleContentResId()!=0){
                    View titleContent=getLayoutInflater().inflate(getTitleContentResId(),null);
                    rl_title_content_base.removeAllViews();
                    addView(rl_title_content_base,titleContent);
                }
                if(!isShowTitle()){
                    setTitleGone();
                }

            }
            if(getLayoutId()!=0){
                addView(fm_content_base,View.inflate(BaseViewActivity.this,getLayoutId(),null));
            }
            if(getContentView()!=null){
                addView(fm_content_base,getContentView());
            }
            if(!isSlideTitleBar()){
                disableTitleSlide();
            }
        }else {
            if(getLayoutId()!=0){
                setContentView(getLayoutId());
            }
            if(getContentView()!=null){
                setContentView(getContentView());
            }

        }
        ButterKnife.bind(this);

    }
    public void setTitleGone(){
        appbar_base.setVisibility(View.GONE);
    }
    private void addView(ViewGroup parent,View child){
        parent.addView(child,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

    }
    public BaseViewActivity setBtnRightText(String s){
        btn_right_base.setVisibility(View.VISIBLE);
        tv_right_base.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        tv_right_base.setText(s);
        return  BaseViewActivity.this;


    }
    public BaseViewActivity setBtnRightImgRes(int res){
        btn_right_base.setVisibility(View.VISIBLE);
        tv_right_base.setBackgroundResource(res);
        tv_right_base.setText("");
        return  BaseViewActivity.this;
    }
    public BaseViewActivity setBtnLeftText(String s){
        tv_left_base.setBackground(new ColorDrawable(Color.TRANSPARENT));
        tv_left_base.setText(s);
        return  BaseViewActivity.this;

    }
    public BaseViewActivity setBtnLeftImgRes(int res){
        tv_left_base.setBackgroundResource(res);
        tv_left_base.setText("");
        return  BaseViewActivity.this;

    }
    public BaseViewActivity setOnBtnRightClickListener(RippleView.OnRippleCompleteListener onRippleCompleteListener){
        btn_right_base.setVisibility(View.VISIBLE);
        btn_right_base.setOnRippleCompleteListener(onRippleCompleteListener);
        return  BaseViewActivity.this;
    }
    public BaseViewActivity setOnBtnLeftClickListener(RippleView.OnRippleCompleteListener onRippleCompleteListener){
        btn_left_base.setOnRippleCompleteListener(onRippleCompleteListener);
        return  BaseViewActivity.this;
    }
}
