package contract;

import bean.Shop;

/*
 *@auther:郝世龙
 *@Date: 2019-11-27
 *@Time:9:11
 *@Description:${契约类}
 **/public interface Icontract {
    //V层
    public interface IView{
        void success(Shop shop);
    }
    //P层
    public interface IPresneter{
        void success(String url);
    }

    //CallBack
    public interface CallBack{
        void success(String json);
        void error(String er);
    }
}
