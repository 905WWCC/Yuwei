package com.product.yuwei.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.product.yuwei.R;
import com.product.yuwei.bean.HotBase;

import java.text.SimpleDateFormat;
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
            viewHolder.nameText = (TextView) ret.findViewById(R.id.hot_author_name);
            viewHolder.authorImage = (ImageView) ret.findViewById(R.id.hot_author);
            viewHolder.numText = (TextView) ret.findViewById(R.id.hot_num);
            ret.setTag(viewHolder);
        }


        HotBase hotBase = list.get(position);


        String text = hotBase.getText();
        String author = hotBase.getAuthor_uname();
        String level = hotBase.getLevel();
        int readnum = hotBase.getReadnum();
        int plnum = hotBase.getPlnum();
        int imgnum = hotBase.getImgnum();


        String cover = hotBase.getCover();

        Glide
                .with(context)
                .load(cover)
                .centerCrop()
                .into(viewHolder.imageView);

        Glide
                .with(context)
                .load(hotBase.getAuthor_header())
                .centerCrop()
                .into(viewHolder.authorImage);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new java.util.Date());

        viewHolder.nameText.setText(author + " \t\t LV" + level + " \t\t " + date);
        viewHolder.textView.setText(text);
        viewHolder.numText.setText("关注" + readnum+ "收藏" + plnum);

        return ret;
    }

    private static class ViewHolder{
        public TextView textView,nameText,numText;
        public ImageView imageView,authorImage;
    }

}
