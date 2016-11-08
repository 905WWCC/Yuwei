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

import java.text.SimpleDateFormat;
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
        ViewHolder holder = null;

        if(convertView==null){
             holder = new ViewHolder();
            convertView=mLayoutInflater.inflate(R.layout.recommend_item,null);
            holder.itemImage= (ImageView) convertView.findViewById(R.id.id_item_iv);
            holder.itemTitle= (TextView) convertView.findViewById(R.id.id_item_title);
            holder.itemTime= (TextView) convertView.findViewById(R.id.id_item_time);
            holder.itemUName= (TextView) convertView.findViewById(R.id.id_item_uname);
            holder.itemUImage=(RoundImageView)convertView.findViewById(R.id.id_item_iv_user);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd",
                Locale.getDefault());
        String time=sdf.format(noteBean.getTime());
        holder.itemTime.setText(time);

        holder.itemUName.setText(noteBean.getAuthor_name());


        return convertView;
    }


    private class ViewHolder {
        public ImageView itemImage;
        public  TextView itemTitle;
        public  TextView itemTime;
        public  TextView itemUName;
        public RoundImageView itemUImage;
    }
}

