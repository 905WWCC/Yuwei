package com.product.yuwei.adapter.homeadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.product.yuwei.R;
import com.product.yuwei.adapter.HotGridAdapter;
import com.product.yuwei.bean.homebean.HomeItem;
import com.product.yuwei.bean.homebean.RecomBaseBean;
import com.product.yuwei.bean.homebean.RecomNoteBean;
import com.product.yuwei.bean.localbean.MyViewHolder;
import com.wx.ovalimageview.RoundImageView;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**主页的适配器
 * Created by dd on 2016/10/26.
 */

public class HomeAdapter extends BaseAdapter {

    private Context context;
    private List<RecomNoteBean> note_list;
    private LayoutInflater mLayoutInflater;
    private final static int WANT_TO=1; //想去的
    private final static int BOOK=2;//全球美食中文
    private final static int GRIDVIEW=3;//滑动九宫格
    private final static int RANK=4;//米其林榜单
    private final static  int LIST=5;//最后的列表
    //刷新list列表的参数
    public void refreshData(List<RecomNoteBean> note_list) {
        this.note_list=note_list;
        notifyDataSetChanged();
    }

    public HomeAdapter(Context context , List<RecomNoteBean> note_list){
        this.context=context;
        this.note_list=note_list;
    }
    @Override
    public int getCount(){
        return note_list.size();
    }
    //获取对应ID项对应的Item
    @Override
    public Object getItem(int position){
        return note_list== null ? null : note_list.get(position);
    }
    //获得视图的id
    @Override
    public long getItemId(int position){
        return position;
    }
    //getview是最关键的方法
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view=null;


        if(convertView!=null){
            view =convertView;
        }else{
            view =LayoutInflater.from(context).inflate(R.layout.recommend_item,parent,false);

        }
        ViewHolder holder = (ViewHolder) view.getTag();
        if(holder==null){
            holder=new ViewHolder();
            holder.itemImage= (ImageView) view.findViewById(R.id.id_item_iv);
            holder.itemTitle= (TextView) view.findViewById(R.id.id_item_title);
            holder.itemTime= (TextView) view.findViewById(R.id.id_item_time);
            holder.itemUName= (TextView) view.findViewById(R.id.id_item_uname);
            holder.itemUImage= (ImageView) view.findViewById(R.id.id_item_iv_user);
        }

        //取出数据
        RecomNoteBean noteBean=note_list.get(position);

        Glide
                .with(context)
                .load(noteBean.getCover())
                .centerCrop()
                .into(holder.itemImage);
        Glide
                .with(context)
                .load(noteBean.getAuthor_img())
                .centerCrop()
                .into(holder.itemUImage);
        holder.itemTitle.setText(noteBean.getName());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd",Locale.getDefault());
        String strtime= noteBean.getTime();
        long ltime=Long.valueOf(strtime);

        String time=sdf.format(new Date(ltime*1000L));//这里传入要long并且1000倍才行，不然将显示最初时间
        holder.itemTime.setText(time);
        holder.itemTitle.setText(noteBean.getName());
        holder.itemUName.setText(noteBean.getAuthor_name());
        return view;
    }


    private class ViewHolder {
        public ImageView itemImage;
        public  TextView itemTitle;
        public  TextView itemTime;
        public  TextView itemUName;
        public ImageView itemUImage;
    }
}

