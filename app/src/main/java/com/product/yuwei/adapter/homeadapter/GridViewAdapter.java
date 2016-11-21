package com.product.yuwei.adapter.homeadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.platform.comapi.map.C;
import com.bumptech.glide.Glide;
import com.product.yuwei.R;
import com.product.yuwei.bean.homebean.RecomHotBean;
import com.product.yuwei.bean.homebean.RecomNoteBean;

import java.util.List;

/**滑动九宫格的适配器
 * Created by dd on 2016/10/27.
 */

public class GridViewAdapter extends BaseAdapter{
    private Context context;
    private List<RecomHotBean> recomHotBeenlist;
    //传入集合数据，然后解析

    public void refreshData(List<RecomHotBean> recomHotBeenlist) {
        this.recomHotBeenlist=recomHotBeenlist;
        notifyDataSetChanged();
    }
    public GridViewAdapter(Context context,List<RecomHotBean> recomHotBeenlist){
        this.context=context;
        this.recomHotBeenlist=recomHotBeenlist;

    }

    @Override
    public int getCount() {
        return recomHotBeenlist.size();
    }

    @Override
    public Object getItem(int position) {
        return recomHotBeenlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=null;
        if(convertView!=null){
            view=convertView;
        }else{
            view= LayoutInflater.from(context).inflate(R.layout.recommed_griditem,parent,false);
        }
        ViewHolder hodler = (ViewHolder) view.getTag();
        if (hodler==null){
            hodler=new ViewHolder();
            hodler.itemImage= (ImageView) view.findViewById(R.id.grid_item_iv);
            hodler.itemDetail= (TextView) view.findViewById(R.id.grid_item_detail);
            hodler.itemTitle= (TextView) view.findViewById(R.id.grid_item_title);
            view.setTag(hodler);

        }
        //填充数据
        RecomHotBean hotbean=recomHotBeenlist.get(position);

        Glide
                .with(context)
                .load(hotbean.getCover())
                .centerCrop()
                .into(hodler.itemImage);
        hodler.itemTitle.setText(hotbean.getName());
        hodler.itemDetail.setText(hotbean.getSummary());

        return view;
    }
    private class ViewHolder{
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

    }
}
