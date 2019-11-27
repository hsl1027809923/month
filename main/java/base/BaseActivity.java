package base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/*
 *@auther:郝世龙
 *@Date: 2019-11-27
 *@Time:8:52
 *@Description:${activity基类}
 **/public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    //声明泛型
    public P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载视图
        setContentView(initLayout());
        //④　抽取Activity基类，在Activity基类中封装初始化P层的方法。
        p=initPresenter();
        //绑定方法
        if (p!=null){
            p.attach(this);
        }
        //初始化控件
        initView();
        //设置数据
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int initLayout();
    protected abstract P initPresenter();
    //解绑方法
//③　解决MVP内存泄漏。
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (p!=null){
            p.unbind();
            p=null;
        }
    }
}
