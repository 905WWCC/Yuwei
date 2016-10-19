package com.product.yuwei.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.product.yuwei.R;
import com.product.yuwei.adapter.GuidePagerAdapter;
import com.product.yuwei.bean.PreferenceUtil;
import com.product.yuwei.utils.Contrants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/18 0018.
 */
public class GuideActivity extends Activity {

    //是否显示引导界面
    boolean isShow = false;

    private ViewPager guideViewPager;
    private LinearLayout cricleLayout;
    private Button guideEnterButton;

    //页面的集合
    private List<View> views;

    //viewPager下面的小圆圈
    private ImageView[] cricleImageViews;

    //adapter
    private GuidePagerAdapter guidePagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        //得到Preference存储的数据
        isShow = PreferenceUtil.getBoolean(this, Contrants.SHOW_GUIDE);
//        isShow = false;
        if (isShow){
            //进入主页面
            Intent intent = new Intent(GuideActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            initView();
        }
    }

    //进入引导页面
    private void initView(){

        guideViewPager = (ViewPager) findViewById(R.id.guide_view_pager);
        cricleLayout = (LinearLayout) findViewById(R.id.cricle_layout);

        views = new ArrayList<View>();

        LayoutInflater inflater = LayoutInflater.from(this);
        views.add(inflater.inflate(R.layout.activity_guide_first,null));
        views.add(inflater.inflate(R.layout.activity_guide_second,null));
//        views.add(inflater.inflate(R.layout.activity_guide_third,null));
        views.add(inflater.inflate(R.layout.activity_guide_fourth, null));

        guidePagerAdapter = new GuidePagerAdapter(views,this);
        cricleImageViews = new ImageView[views.size()];
        drawCricle();

        guideViewPager.setAdapter(guidePagerAdapter);
        guideViewPager.addOnPageChangeListener(new GuidePageChangeListener());

    }

    //画圆圈
    private void drawCricle(){
        int num = views.size();

        for (int i = 0; i < num; i++) {

            //实例化每一个cricleImageViews[i]
            cricleImageViews[i] = new ImageView(this);
            if (i == 0) {
                cricleImageViews[i].setImageResource(R.mipmap.white_dot);
            }else {
                cricleImageViews[i].setImageResource(R.mipmap.dark_dot);
            }
            //设置每个小圈的间隔
            cricleImageViews[i].setPadding(7,7,7,7);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER_VERTICAL;
            //让每个小圆圈都在LinearLayout中间垂直
            cricleLayout.addView(cricleImageViews[i],params);
        }

    }

    private class GuidePageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //如果是当前页面，将小圆圈改变颜色
            for (int i = 0; i < cricleImageViews.length; i++) {
                if (position != i) {
                    cricleImageViews[i].setImageResource(R.mipmap.dark_dot);
                }else {
                    cricleImageViews[position].setImageResource(R.mipmap.white_dot);
                }
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

}
