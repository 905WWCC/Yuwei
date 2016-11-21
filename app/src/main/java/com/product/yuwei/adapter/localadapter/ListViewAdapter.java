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
import com.product.yuwei.bean.localbean.LocalDataBean;
import com.product.yuwei.bean.localbean.LocalDataBean1;
import com.product.yuwei.bean.localbean.MapNearbyBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/5 0005.
 */
public class ListViewAdapter extends BaseAdapter {
//    private List<Map<String, Object>> data = getData();
    private LayoutInflater mInflater = null;
    private List<MapNearbyBean> list;
    private Context context;
//    private List<Map<String, Object>> getData()
//    {
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//        Map<String, Object> map;
//        for(int i=0;i<3;i++)
//        {
//            map = new HashMap<String, Object>();
//            map.put("img", R.drawable.ic_launcher);
//            map.put("title", "必去餐厅");
//            list.add(map);
//        }
//        return list;
//    }
    public ListViewAdapter(Context context,List<MapNearbyBean> list)
    {
        this.list = list;
        this.context = context;
        //根据context上下文加载布局，这里的是Demo17Activity本身，即this
        this.mInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        //How many items are in the data set represented by this Adapter.
        //在此适配器中所代表的数据集中的条目数
        return 3;
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
            convertView = mInflater.inflate(R.layout.rest_item, null);
            holder.img1 = (ImageView)convertView.findViewById(R.id.city_map_image);
            holder.img2 = (ImageView)convertView.findViewById(R.id.city_map_mark);
            holder.title1 = (TextView)convertView.findViewById(R.id.city_map_rest_km);
            holder.title2 = (TextView)convertView.findViewById(R.id.city_map_rest_name);
            holder.title3 = (TextView)convertView.findViewById(R.id.city_map_rest_cost);
            holder.title4 = (TextView)convertView.findViewById(R.id.city_map_rest_type);
//                holder.info = (TextView)convertView.findViewById(R.id.info);
            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
            convertView.setTag(holder);
        }else
        {
            holder = (ViewHolder)convertView.getTag();
        }


        int img[] ={
                R.mipmap.citymap_1,
                R.mipmap.citymap_2,
                R.mipmap.citymap_3
        };

        MapNearbyBean mapNearbyBean = list.get(position);
        String id = mapNearbyBean.getId();
        String name = mapNearbyBean.getName();
        String km = mapNearbyBean.getKm();
        int cost = mapNearbyBean.getCost();
        String type = mapNearbyBean.getType();

        holder.img2.setImageResource(img[position]);
        holder.title1.setText(km);
        holder.title2.setText(name);
        holder.title3.setText(cost+"元/人");
        holder.title4.setText(type);

        Glide
                .with(context)
                .load(mapNearbyBean.getCover())
                .centerCrop()
                .into(holder.img1);

        return convertView;
    }
}
