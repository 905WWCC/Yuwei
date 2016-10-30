package com.product.yuwei.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.product.yuwei.R;
import com.product.yuwei.bean.HotBase;

import java.util.List;

/**
 * Created by Administrator on 2016/10/24 0024.
 */
public class HotGridAdapter extends BaseAdapter {

    private Context context;
    private List<HotBase> list;

    public HotGridAdapter(Context context, List<HotBase> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        int count = 0;
        if (list != null) {
            count = list.size();
        }
        return count;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View ret = null;

        if (convertView != null) {
            ret = convertView;
        } else {
            ret = LayoutInflater.from(context).inflate(R.layout.fragment_note_hot_grid,parent,false);
        }

        ViewHolder viewHolder = (ViewHolder) ret.getTag();
        if (viewHolder == null) {
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) ret.findViewById(R.id.hot_text);
            viewHolder.imageView = (ImageView) ret.findViewById(R.id.hot_image);
            ret.setTag(viewHolder);
        }

        HotBase hotBase = list.get(position);

        String text = hotBase.getText();

        Glide
                .with(context)
                .load(hotBase.getCover())
                .centerCrop()
                .into(viewHolder.imageView);

        viewHolder.textView.setText(text);

        return ret;
    }

    private static class ViewHolder{
        public LinearLayout header,end;
        public TextView textView;
        public ImageView imageView;
    }

}
