package com.product.yuwei.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
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

        Glide
                .with(context)
                .load(hotBase.getAtt_header())
                .centerCrop()
                .into(viewHolder.image);

        viewHolder.unameText.setText(uname);
        viewHolder.vnameText.setText(vname);
        viewHolder.descText.setText(desc);

        if (label3 == null) {
            viewHolder.labelText.setText(backgroundColor(label1) + "  " + backgroundColor(label2));
        } else {
            viewHolder.labelText.setText(backgroundColor(label1) + "  " + backgroundColor(label2) + "   " + backgroundColor(label3));
        }


        return ret;
    }
    private static class ViewHolder{
        public TextView unameText,vnameText,descText,labelText;
        public ImageView image;
    }

    private SpannableStringBuilder backgroundColor(String str){
        int bstart1 = str.indexOf("图片高手");
        int bend1 = bstart1+"图片高手".length();

        int bstart2 = str.indexOf("餐厅拔草先锋");
        int bend2 = bstart2+"餐厅拔草先锋".length();

        int bstart3 = str.indexOf("米其林餐厅爱好者");
        int bend3 = bstart3+"米其林餐厅爱好者".length();

        int bstart4 = str.indexOf("盘点贴专注者");
        int bend4 = bstart4+"盘点贴专注者".length();

        int bstart5 = str.indexOf("有故事的童鞋");
        int bend5 = bstart5+"有故事的童鞋".length();

        SpannableStringBuilder style = new SpannableStringBuilder(str);

        if (str.equals("图片高手")){
            style.setSpan(new BackgroundColorSpan(Color.GREEN),bstart1,bend1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        else if (str.equals("餐厅拔草先锋")){
            style.setSpan(new BackgroundColorSpan(Color.RED),bstart2,bend2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        else if (str.equals("米其林餐厅爱好者")){
            style.setSpan(new BackgroundColorSpan(Color.YELLOW),bstart3,bend3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        else if (str.equals("盘点贴专注者")){
            style.setSpan(new BackgroundColorSpan(Color.BLUE),bstart4,bend4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        else if (str.equals("有故事的童鞋")){
            style.setSpan(new BackgroundColorSpan(Color.GRAY),bstart5,bend5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        return style;
    }

}
