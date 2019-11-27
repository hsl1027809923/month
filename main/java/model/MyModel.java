package model;

import contract.Icontract;
import util.VolleyUtil;

/*
 *@auther:郝世龙
 *@Date: 2019-11-27
 *@Time:9:03
 *@Description:${model层}
 **/public class MyModel {
    public void modelGet(String url, Icontract.CallBack callBack){
        VolleyUtil.getInstance().toGet(url, callBack);
    }
}
