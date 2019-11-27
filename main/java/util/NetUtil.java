package util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/*
 *@auther:郝世龙
 *@Date: 2019-11-27
 *@Time:9:07
 *@Description:${网络}
 **/public class NetUtil {
    //单例模式
    public static NetUtil netUtil=new NetUtil();
    private NetUtil() {
    }
    public static NetUtil getInstance(){
        return netUtil;
    }
    //⑥　封装网络状态判断方法，可以判断有网无网。
    public boolean getNet(Context context){
        ConnectivityManager manager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info!=null){
            return info.isConnected();
        }
        return false;
    }
}
