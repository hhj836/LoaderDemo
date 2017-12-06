package com.example.hhj.loaderdemo.theme.attr;

import android.view.View;

public class SkinAttr
{
    String resName;
    SkinAttrType attrType;


    public SkinAttr(SkinAttrType attrType, String resName)
    {
        this.resName = resName;
        this.attrType = attrType;
    }

    public void apply(View view)
    {
        attrType.apply(view, resName);
    }
}
