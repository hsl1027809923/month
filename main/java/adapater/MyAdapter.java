package adapater;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.haoshilong.Main2Activity;
import com.bawei.haoshilong.MainActivity;
import com.bawei.haoshilong.R;
import com.bumptech.glide.Glide;

import java.util.List;

import bean.Shop;

/*
 *@auther:郝世龙
 *@Date: 2019-11-27
 *@Time:9:22
 *@Description:${适配器}
 **/public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    List<Shop.ResultBean> list;
    Context context;
    private String commodityName;
    MainActivity activity;

    //有参构造
    public MyAdapter(List<Shop.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
        activity= (MainActivity) context;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_layout,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {
        commodityName = list.get(i).getCommodityName();
        holder.item_text1.setText(commodityName+"");
        holder.item_text2.setText("$:"+list.get(i).getPrice()+"");
        //④　使用Glide完成图片加载，并配置站位图、错误图。
        Glide.with(context)
                .load(list.get(i).getMasterPic())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.item_img);
        //点击事件
        holder.linner_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context, Main2Activity.class);
                intent.putExtra("commodityName",list.get(i).getCommodityName());
                activity.startActivity(intent);
            }
        });
    }

    //③　使用接口回调完成RecycleView点击事件，点击跳转到图2详情。
    Onclick onclick;
    public void setOnclick(Onclick onclick){
        this.onclick=onclick;
    }
    public interface Onclick{
        void ClickHD();
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView item_img;
        TextView item_text1,item_text2;
        LinearLayout linner_layout;
        public Holder(@NonNull View itemView) {
            super(itemView);
            linner_layout=itemView.findViewById(R.id.linner_layout);
            item_img=itemView.findViewById(R.id.item_img);
            item_text1=itemView.findViewById(R.id.item_text1);
            item_text2=itemView.findViewById(R.id.item_text2);
        }
    }
}
