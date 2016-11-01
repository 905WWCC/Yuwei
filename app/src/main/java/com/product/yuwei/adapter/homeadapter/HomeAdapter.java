package com.product.yuwei.adapter.homeadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.product.yuwei.bean.homebean.HomeItem;

import java.util.List;

/**主页的适配器
 * Created by dd on 2016/10/26.
 */

public class HomeAdapter extends BaseAdapter {
    private Context context;
    private List<HomeItem> homeItemList;
    private final static int WANT_TO=1; //想去的
    private final static int BOOK=2;//全球美食中文
    private final static int GRIDVIEW=3;//滑动九宫格
    private final static int RANK=4;//米其林榜单
    private final static  int LIST=5;//最后的列表



    public HomeAdapter(Context context , List<HomeItem> homeItemList){
        this.context=context;
        this.homeItemList=homeItemList;
    }
    @Override
    public int getCount(){
        return homeItemList.size();
    }
    //获得视图
    @Override
    public Object getItem(int position){
        return homeItemList== null ? null : homeItemList.get(position);
    }
    //获得视图的id
    @Override
    public long getItemId(int position){
        return position;
    }
    //getview是最关键的方法
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup){
        HomeItem homeItem=homeItemList.get(position);//position是滑动的时候所处的位置，
        LayoutInflater inflater=LayoutInflater.from(context);
        return convertView;
    }


}

