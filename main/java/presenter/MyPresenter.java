package presenter;

import com.bawei.haoshilong.MainActivity;
import com.google.gson.Gson;

import base.BasePresenter;
import bean.Shop;
import contract.Icontract;
import model.MyModel;

/*
 *@auther:郝世龙
 *@Date: 2019-11-27
 *@Time:9:02
 *@Description:${presneter层}
 **/public class MyPresenter extends BasePresenter implements Icontract.IPresneter {
    //实例化model层
    MyModel myModel;

    public MyPresenter() {
        myModel=new MyModel();
    }

    @Override
    public void success(String url) {
        myModel.modelGet(url, new Icontract.CallBack() {
            @Override
            public void success(String json) {
                //解析
                Gson gson=new Gson();
                Shop shop = gson.fromJson(json, Shop.class);
                //返回View层
                MainActivity activity= (MainActivity) v;
                activity.success(shop);
            }

            @Override
            public void error(String er) {

            }
        });
    }
}
