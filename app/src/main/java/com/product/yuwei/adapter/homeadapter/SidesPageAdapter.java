package com.product.yuwei.adapter.homeadapter;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.product.yuwei.bean.homebean.RecomBaseBean;
import com.product.yuwei.bean.homebean.RecomPageBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**推荐页面上的顶部滑动图片的适配器
 * Created by dd on 2016/10/27.
 */

public class SidesPageAdapter extends PagerAdapter{

    private List<RecomPageBean> imageBeanList;
    private List<ImageView> imageList;
    public SidesPageAdapter(Context context,List<RecomPageBean> imageBeanList){
        for (int i = 0; i <imageBeanList.size() ; i++) {
            ImageView imageView=new ImageView(context);
            Glide.with(context).load(imageBeanList.get(i).getImg()).into(imageView);
            imageList.add(imageView);

        }
    }

    @Override
    public int getCount() {
        //设置成最大，使用户看不到边界
        return Integer.MAX_VALUE;
    }
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0==arg1;
    }
    @Override
    public void destroyItem(ViewGroup container, int position,Object object) {
        //Warning：不要在这里调用removeView
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
