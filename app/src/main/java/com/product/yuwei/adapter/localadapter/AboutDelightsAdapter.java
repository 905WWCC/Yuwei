package com.product.yuwei.adapter.localadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.product.yuwei.R;
import com.product.yuwei.bean.localbean.AboutVisitBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/5 0005.
 */
public class AboutDelightsAdapter extends BaseAdapter {
    private Context context;

    private List<AboutVisitBean> list;
    private LayoutInflater mInflater = null;

    public AboutDelightsAdapter(Context context,List<AboutVisitBean> list)
    {
        this.context = context;
        //根据context上下文加载布局，这里的是Demo17Activity本身，即this
        this.mInflater = LayoutInflater.from(context);
        this.list = list;

    }
    @Override
    public int getCount() {
        //How many items are in the data set represented by this Adapter.
        //在此适配器中所代表的数据集中的条目数
        int count = 0;
        if(list !=null){
            count = list.size();
        }
        return count;
    }
    @Override
    public Object getItem(int position) {
        // Get the data item associated with the specified position in the data set.
        //获取数据集中与指定索引对应的数据项
        return position;
    }
    @Override
    public long getItemId(int position) {
        //Get the row id associated with the specified position in the list.
        //获取在列表中与指定索引对应的行id
        return position;
    }
    static class ViewHolder
    {
        public ImageView img1,img2;
        public TextView title1,title2,title3,title4;
    }

    //Get a View that displays the data at the specified position in the data set.
    //获取一个在数据集中指定索引的视图来显示数据
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        //如果缓存convertView为空，则需要创建View
        if(convertView == null)
        {
            holder = new ViewHolder();
            //根据自定义的Item布局加载布局
            convertView = mInflater.inflate(R.layout.item_about_delights, null);
            holder.img1 = (ImageView)convertView.findViewById(R.id.cover);
            holder.img2 = (ImageView)convertView.findViewById(R.id.authorHeader);
            holder.title1 = (TextView)convertView.findViewById(R.id.homePageItemTitle);
            holder.title2 = (TextView)convertView.findViewById(R.id.name);
            holder.title3 = (TextView)convertView.findViewById(R.id.time);
            holder.title4 = (TextView)convertView.findViewById(R.id.authorName);
//                holder.info = (TextView)convertView.findViewById(R.id.info);
            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
            convertView.setTag(holder);
        }else
        {
            holder = (ViewHolder)convertView.getTag();
        }

        AboutVisitBean aboutVisitBean = list.get(position);
        String name = aboutVisitBean.getName();
        String time = aboutVisitBean.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String time1 = dateFormat.format(new Date(Long.parseLong(time) * 1000));

        String uname = aboutVisitBean.getUname();
//        holder.title1.setText(name);
        holder.title2.setText(name);
        holder.title3.setText(time1);
        holder.title4.setText(uname);

        Glide
                .with(context)
                .load(aboutVisitBean.getCover())
                .centerCrop()
                .into(holder.img1);
         Glide
                .with(context)
                .load(aboutVisitBean.getHeader())
                .centerCrop()
                .into(holder.img2);


        return convertView;
    }
}
