package com.product.yuwei.adapter.homeadapter;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**推荐页面上的顶部滑动图片的适配器
 * Created by dd on 2016/10/27.
 */

public class SidesPageAdapter extends PagerAdapter{
    private List<ImageView> imageList=new ArrayList<ImageView>();
    public SidesPageAdapter(Context context,String[] imgUrlList){
        for (int i = 0; i <imgUrlList.length ; i++) {
            ImageView imageView=new ImageView(context);
            Glide.with(context).load(imgUrlList[i]).into(imageView);
            imageList.add(imageView);

        }
    }

    @Override
    public int getCount() {
        //设置成最大，使用户看不到边界
        return Integer.MAX_VALUE;
    }

    /////////////////////////////////
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    //////////////////////////////////////////////

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    @Override
    public Object instantiateItem(final ViewGroup container, int position){
        //对ViewPager页号求模取出View列表中要显示的项
        position %= imageList.size();
        if (position<0){
            position = imageList.size()+position;
        }
        final ImageView view = imageList.get(position);
        //如果View已经在之前添加到了一个父组件，则必须先remove，否则会抛出IllegalStateException。
        ViewParent vp =view.getParent();
        if (vp!=null){
            ViewGroup parent = (ViewGroup)vp;
            parent.removeView(view);
        }
        container.addView(view);
        //add listeners here if necessary
        final int positionId=position;
        if (onItemClickListener != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = positionId;
                    onItemClickListener.onItemClick(view, pos);
                }
            });
        }

        return view;

    }
}
