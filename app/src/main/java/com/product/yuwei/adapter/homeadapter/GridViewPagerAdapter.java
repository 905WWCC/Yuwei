package com.product.yuwei.adapter.homeadapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;


import com.product.yuwei.bean.homebean.RecomPageBean;

import java.util.List;

/**gridView
 * Created by dd on 2016/11/13.
 */

public class GridViewPagerAdapter extends PagerAdapter {
    private List<View> gLists;//此处应该是view的集合
    private Context context;


    public void refreshData(List<View> gLists) {
        this.gLists=gLists;
        notifyDataSetChanged();
    }


    public GridViewPagerAdapter(Context context, List<View> gLists) {
        this.context=context;
        this.gLists = gLists;
    }



    @Override
    public int getCount() {
        return gLists.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(gLists.get(position));
        return gLists.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((View) object);
    }

}

