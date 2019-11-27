package util;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

import app.MyApp;
import contract.Icontract;

/*
 *@auther:郝世龙
 *@Date: 2019-11-27
 *@Time:9:05
 *@Description:${Volley}
 **/public class VolleyUtil {
    //创建队列
    RequestQueue queue= Volley.newRequestQueue(MyApp.context);
    //单例模式
    public static VolleyUtil util=new VolleyUtil();
    private VolleyUtil() {
    }
    public static VolleyUtil getInstance(){
        return util;
    }
    //⑤　封装Volley的get和post。
    //get请求
    public void toGet(String url,final Icontract.CallBack callBack){
        StringRequest request=new StringRequest(0, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.error(error.getMessage());
            }
        });
        queue.add(request);
    }
    //post请求
    public void toPost(String url , final Map<String,String>map, final Icontract.CallBack callBack){
        StringRequest request=new StringRequest(1, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.error(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        queue.add(request);
    }


}
