package com.bawei.haoshilong;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*
 *@auther:郝世龙
 *@Date: 2019-11-27
 *@Time:9:22
 *@Description:${webview  js交互}
 **/
public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button but_main2;
    private WebView webview_main2;
    private String stringExtra;
    EditText edit_main2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        stringExtra = getIntent().getStringExtra("commodityName");
    }

    @SuppressLint("JavascriptInterface")
    private void initView() {
        but_main2 = (Button) findViewById(R.id.but_main2);
        webview_main2 = (WebView) findViewById(R.id.webview_main2);
        edit_main2=findViewById(R.id.edit_main2);
        but_main2.setOnClickListener(this);
        //允许加载js
        webview_main2.getSettings().setJavaScriptEnabled(true);
        //加载本地html
        webview_main2.loadUrl("file:///android_asset/info.html");
        webview_main2.addJavascriptInterface(new Onclick(),"android");
    }
    public class Onclick{
        @JavascriptInterface
        public void buyNow(int id){
            //使用log输出js传递过来的参数。
            Log.i("aa", "buyNow: "+id);
    //③　点击立即购买，js方法会调用android的buyNow方法。
            Toast.makeText(Main2Activity.this, ""+id, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_main2:
                String string = edit_main2.getText().toString();
//②　点击修改库存按钮，调用js的changeNum方法，把输入框中填入的数据传递给changeNum方法
                webview_main2.loadUrl("javascript:changeNum('"+string+"')");
                break;
        }
    }
}
