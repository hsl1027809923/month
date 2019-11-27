package api;

/*
 *@auther:郝世龙
 *@Date: 2019-11-27
 *@Time:9:30
 *@Description:${DESCRIPTION}
 **/public class API {
    public String toUrl(String keyword,int page,int count){
        String url="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword="+keyword+"&page="+page+"&count="+count;
        return url;
    }
}
