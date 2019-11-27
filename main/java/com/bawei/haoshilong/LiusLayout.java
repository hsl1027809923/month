package com.bawei.haoshilong;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/*
 *@auther:郝世龙
 *@Date: 2019-11-27
 *@Time:10:48
 *@Description:${流式布局}
 **/public class LiusLayout extends ViewGroup {
    Context context;
    private int widthPixels;

    public LiusLayout(Context context) {
        super(context);
        this.context=context;
        init(context);
    }

    public LiusLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init(context);
    }

    public LiusLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        init(context);
    }

    public void init(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        widthPixels = displayMetrics.widthPixels;
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //获取全部子控件
        int childCount = getChildCount();
        int left=0;
        int right=0;
        int top=0;
        int botton=0;
        int space=0;
        for (int i = 0; i < getChildCount(); i++) {
            //获取每个子控件
            View childAt = getChildAt(i);
            //测量
            childAt.measure(0,0);
            //获取宽高
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredWidth = childAt.getMeasuredWidth();
            //计算
            left=space+right;
            right=left+measuredWidth;
            if (right>widthPixels){
                left=space;
                right=left+measuredWidth;
                top=space+botton;
            }
            botton=measuredHeight+top;
            childAt.layout(left,top,right,botton);
        }
    }
    public void addTag(String tag){
        TextView textView=new TextView(context);
        textView.setText(tag);
        textView.setTextColor(Color.RED);
        textView.setTextSize(20);
        textView.setPadding(12,12,12,12);
        textView.setBackgroundColor(Color.YELLOW);
        addView(textView);
    }
}
