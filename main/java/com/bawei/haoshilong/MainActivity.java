package com.bawei.haoshilong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URLEncoder;

import adapater.MyAdapter;
import api.API;
import base.BaseActivity;
import base.BasePresenter;
import bean.Shop;
import contract.Icontract;
import presenter.MyPresenter;
import util.NetUtil;

/*
 *@auther:郝世龙
 *@Date: 2019-11-27
 *@Time:8:54
 *@Description:${主页面}
 **/
public class MainActivity extends BaseActivity implements Icontract.IView {
    //声明
    RecyclerView recy_view;
    private MyPresenter myPresenter;
    EditText editText;
    LiusLayout lius_layout;

    //设置数据
    @Override
    protected void initData() {
        //⑥　封装网络状态判断方法，可以判断有网无网。
        boolean net = NetUtil.getInstance().getNet(this);
        if (net){
            //有网
            API api=new API();
            String str = URLEncoder.encode("板鞋");
            myPresenter.success(api.toUrl(str,1,5));

        }else {
            Toast.makeText(this, "请检查网络", Toast.LENGTH_SHORT).show();
        }
    }
    //初始化控件
    @Override
    protected void initView() {
        recy_view=findViewById(R.id.recy_view);
        //布局管理器
        recy_view.setLayoutManager(new LinearLayoutManager(this));
        editText=findViewById(R.id.edit_main1);
        lius_layout=findViewById(R.id.lius_layout);

    }
    //加载布局
    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }
    //初始化P层方法
    @Override
    protected BasePresenter initPresenter() {
        myPresenter = new MyPresenter();
        return myPresenter;
    }

    @Override
    public void success(Shop shop) {
        MyAdapter adapter=new MyAdapter(shop.getResult(),this);
        recy_view.setAdapter(adapter);
    }


    public void ssbut(View view) {
        String string = editText.getText().toString();
        //流式布局
        lius_layout.addTag(string);
        //搜索
        API api=new API();
        String str = URLEncoder.encode(string);
        myPresenter.success(api.toUrl(str,1,5));
    }
}
