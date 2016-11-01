package com.product.yuwei.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.product.yuwei.R;
import com.product.yuwei.bean.HotBase;

import java.util.List;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class AttentionAdapter extends BaseAdapter {

    private Context context;
    private List<HotBase> list;

    public AttentionAdapter(Context context, List<HotBase> list) {
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
            ret = LayoutInflater.from(context).inflate(R.layout.fragment_note_att_list,parent,false);
        }

        ViewHolder viewHolder = (ViewHolder) ret.getTag();

        if (viewHolder == null) {
            viewHolder = new ViewHolder();
            viewHolder.unameText = (TextView) ret.findViewById(R.id.att_list_uname);
            viewHolder.vnameText = (TextView) ret.findViewById(R.id.att_list_vname);
            viewHolder.descText = (TextView) ret.findViewById(R.id.att_list_desc);
            viewHolder.labelText = (TextView) ret.findViewById(R.id.att_list_label);
            viewHolder.image = (ImageView) ret.findViewById(R.id.att_list_image);
        }

        HotBase hotBase = list.get(position);

        String uname = hotBase.getAtt_uname();
        String vname = hotBase.getAtt_vname();
        String desc = hotBase.getAtt_desc();
        String label1 = hotBase.getAtt_label_name1();
        String label2 = hotBase.getAtt_label_name2();
        String label3 = hotBase.getAtt_label_name3();

        Log.e("uname",uname);
        Log.e("vname",vname);
        Log.e("desc",desc);


        Glide
                .with(context)
                .load(hotBase.getAtt_header())
                .centerCrop()
                .into(viewHolder.image);

        viewHolder.unameText.setText(uname);
        viewHolder.vnameText.setText(vname);
        viewHolder.descText.setText(desc);
        viewHolder.labelText.setText(label1 + label2 + label3);


        return ret;
    }

    private static class ViewHolder{
        public TextView unameText,vnameText,descText,labelText;
        public ImageView image;
    }


}
