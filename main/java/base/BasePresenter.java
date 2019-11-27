package base;

/*
 *@auther:郝世龙
 *@Date: 2019-11-27
 *@Time:8:54
 *@Description:${presenter基类}
 **/public class BasePresenter<V extends BaseActivity> {
    //声明泛型
    public V v;
    //绑定方法
    public void attach(V v){
        this.v=v;
    }
    //③　解决MVP内存泄漏。
    //解绑方法
    public void unbind(){
        if (v!=null){
            v=null;
        }
    }
}
