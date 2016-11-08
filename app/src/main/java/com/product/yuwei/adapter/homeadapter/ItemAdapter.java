/*
package com.product.yuwei.adapter.homeadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.product.yuwei.R;
import com.product.yuwei.bean.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

*/
/**下面列表项的适配器
 * Created by dd on 2016/11/1.
 *//*


public class ItemAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater;
    private List<ItemBean> mDataList;

    public ItemAdapter（Context context,List<ItemBean> list）{
        mLayoutInflater = LayoutInflater.from(context);
        mDataList = list;
    }


    // 获取数据量
    @Override
    public int getCount() {
        return mDataList.size();
    }
    // 获取对应ID项对应的Item
    @Override
    public Object getItem(int position) {
        return mDataList.get(position);
    }
    // 获取对应项ID
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
        // 由于我们只需要将XML转化为View，并不涉及到具体的布局，所以第二个参数通常设置为null
            convertView = mLayoutInflater.inflate(R.layout.item, null);
            holder.img = (ImageView) convertView.findViewById(R.id.iv_image);
            holder.title = (TextView) convertView.findViewById(R.id.tv_title);
            holder.content = (TextView) convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        // 取出bean对象
        ItemBean bean = mDataList.get(position);
        // 设置控件的数据
        holder.img.setImageResource(bean.itemImageResid);
        holder.title.setText(bean.itemTitle);
        holder.content.setText(bean.itemContent);
        Log.d("xys", String.valueOf(mSumTime));
        return convertView;
    }
    class ViewHolder{
        public ImageView img;
        public TextView title;
        public TextView content;
    }
}
*/
