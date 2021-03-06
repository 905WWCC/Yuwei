package com.product.yuwei.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.product.yuwei.R;
import com.product.yuwei.activity.MainActivity;
import com.product.yuwei.bean.PreferenceUtil;
import com.product.yuwei.utils.Contrants;

import java.util.List;

/**
 * Created by Administrator on 2016/10/18 0018.
 */
public class GuidePagerAdapter extends PagerAdapter {

    private List<View> views;
    private Activity context;

    public GuidePagerAdapter(List<View> views, Activity context) {
        this.views = views;
        this.context = context;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }


    /*
    *   实例化页卡，如果变成最后一页，则获取它的button并且添加点击事件
    * */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position), 0);

        if (position == views.size() - 1) {

            Button enterButton = (Button) container.findViewById(R.id.guide_enter);

            enterButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PreferenceUtil.setBoolean(context, Contrants.SHOW_GUIDE, true);
                    Intent intent = new Intent(context,MainActivity.class);
                    context.startActivity(intent);
                    context.finish();
                }
            });

        }
        return views.get(position);
    }
}
