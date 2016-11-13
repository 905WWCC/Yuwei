package com.product.yuwei.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.product.yuwei.R;
import com.product.yuwei.activity.local.CityIntroductionActivity;
import com.product.yuwei.activity.local.CityListActivity;
import com.product.yuwei.activity.local.LocalSearchActivity;
import com.product.yuwei.adapter.localadapter.AboutDelightsAdapter;
import com.product.yuwei.adapter.localadapter.ListViewAdapter;
import com.product.yuwei.adapter.localadapter.MustGoHallAadapter;
import com.product.yuwei.adapter.localadapter.MyAdapter;
import com.product.yuwei.view.localview.FadingScrollView;
import com.product.yuwei.bean.localbean.MyItemBean;
import com.product.yuwei.view.localview.MyItemClickListener;
import com.product.yuwei.view.localview.MyItemLongClickListener;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by teng on 10/14/16.
 */
public class LocalFragment extends Fragment implements View.OnClickListener,MyItemClickListener,MyItemLongClickListener {
    private ActionBar actionBar;
    private FadingScrollView fadingScrollView;
    private TextView city,search;
    private ImageView city_list;
    private RelativeLayout search_layout;
    private ListView rest_listview,must_go_hall_listview,about_visit_listview;
    // 定位相关
    LocationClient mLocClient;
    public MyLocationListenner myListener = new MyLocationListenner();
    MapView mMapView;
    BaiduMap mBaiduMap;
    // UI相关
    boolean isFirstLoc = true; // 是否首次定位

    RecyclerView mRecyclerView;
    private RelativeLayout unfold;
    private List<MyItemBean> mData;
    MyAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        ((AppCompatActivity)getActivity()).supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);

        View ret = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_local,container,false);
        View top = LayoutInflater.from(getActivity()).inflate(R.layout.local_top,container,false);
        //设置listview适配器
        ListViewAdapter listViewAdapter = new ListViewAdapter(getActivity());
        MustGoHallAadapter mustGoHallAadapter = new MustGoHallAadapter(getActivity());
        AboutDelightsAdapter aboutDelightsAdapter = new AboutDelightsAdapter(getActivity());
        rest_listview = (ListView)ret.findViewById(R.id.rest_listview);
        must_go_hall_listview = (ListView)ret.findViewById(R.id.must_go_hall_listview);
        about_visit_listview = (ListView)ret.findViewById(R.id.about_visit_listview);

        rest_listview.setAdapter(listViewAdapter);
        must_go_hall_listview.setAdapter(mustGoHallAadapter);
        about_visit_listview.setAdapter(aboutDelightsAdapter);

//        fadingScrollView=(FadingScrollView)ret.findViewById(R.id.root);
//        initActionBar();
//        setActionBarLayout(R.layout.local_top);
        init(ret);

        init_top_data(top);
        initView(ret);
        initData();
        return ret;

    }

    private void init_top_data(View v) {
        search_layout = (RelativeLayout)v.findViewById(R.id.search_layout);
        city = (TextView)v. findViewById(R.id.city);
        city_list = (ImageView)v. findViewById(R.id.city_list);
        //设置点击事件
        search_layout.setOnClickListener(this);
        city.setOnClickListener(this);
        city_list.setOnClickListener(this);
    }

    public void init(View v){

        // 地图初始化
        mMapView = (MapView)v. findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        // 开启定位图层
        mBaiduMap.setMyLocationEnabled(true);
        // 定位初始化
        //地图上比例尺
        mMapView.showScaleControl(false);
        // 隐藏缩放控件
        mMapView.showZoomControls(false);
        mLocClient = new LocationClient(getActivity());
        mLocClient.registerLocationListener(myListener);
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);
        option.setAddrType("all");// 返回的定位结果包含地址信息
        mLocClient.setLocOption(option);
        mLocClient.start();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_layout:
                Intent intent = new Intent();
                intent.setClass(getActivity(),LocalSearchActivity.class);
                startActivity(intent);
            case R.id.city:
                Intent intent_city = new Intent();
                intent_city.setClass(getActivity(), CityListActivity.class);
                startActivity(intent_city);
            case R.id.city_list:
                Intent intent_cityChoose = new Intent();
                intent_cityChoose.setClass(getActivity(), CityIntroductionActivity.class);
                startActivity(intent_cityChoose);
        }
    }



    public void setActionBarLayout(int layoutId ){

        if( actionBar != null){

            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);


            LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = inflater.inflate(layoutId, null);
            ActionBar.LayoutParams layout = new  ActionBar.LayoutParams(android.app.ActionBar.LayoutParams.MATCH_PARENT,
                    android.app.ActionBar.LayoutParams.MATCH_PARENT);
            actionBar.setCustomView(v,layout);
        }
    }
    //初始化Actionbar
    void initActionBar(){

        TypedArray actionbarSizeTypedArray = getActivity().obtainStyledAttributes(new int[] { android.R.attr.actionBarSize });
        float height = actionbarSizeTypedArray.getDimension(0, 0);
        fadingScrollView.setFadingOffset((int) height);

        actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();

        ColorDrawable bgDrawable=new ColorDrawable(getResources().getColor(R.color.transparent));
        fadingScrollView.bindingActionBar(actionBar);
        try {
            fadingScrollView.setActionBarBgDrawable(bgDrawable);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 定位SDK监听函数
     */
    public class MyLocationListenner implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            // map view 销毁后不在处理新接收的位置
            if (location == null || mMapView == null) {
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                            // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(100).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mBaiduMap.setMyLocationData(locData);
            city.setText(location.getCity().substring(0, 2));
            //是否首次定位
            if (isFirstLoc) {
                isFirstLoc = false;
                LatLng ll = new LatLng(location.getLatitude(),
                        location.getLongitude());
                MapStatus.Builder builder = new MapStatus.Builder();
                builder.target(ll).zoom(18.0f);
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
                city.setText(location.getCity().substring(0, 2));
            }
        }

    }

    @Override
    public void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    public void onResume() {
        mMapView.onResume();
        super.onResume();
    }
    @Override
    public void onDestroy() {
        // 退出时销毁定位
        mLocClient.stop();
        // 关闭定位图层
        mBaiduMap.setMyLocationEnabled(false);
        mMapView.onDestroy();
        mMapView = null;
        super.onDestroy();
    }



    private void initView(View v){
        mRecyclerView = (RecyclerView)v.findViewById(R.id.recyclerView);
        unfold = (RelativeLayout)v.findViewById(R.id.unfold);
        unfold.setOnClickListener(new MyListener());
        mRecyclerView.setLayoutManager(new GridLayoutManager(mRecyclerView.getContext(), 2, GridLayoutManager.VERTICAL, false));
//		mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }
    //recyclerview中的展开点击事件
    private class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(mAdapter.getItemCount() == 2){
                mAdapter.addItemNum(mData.size());
                mAdapter.notifyDataSetChanged();
            }else {
                mAdapter.addItemNum(2);
                mAdapter.notifyDataSetChanged();
            }

        }
    }
    private void initData(){
        this.mData = new ArrayList<MyItemBean>();
        for(int i=0;i<6;i++){
            MyItemBean bean = new MyItemBean();
            bean.tv = "wws"+i;
            mData.add(bean);
        }
        this.mAdapter = new MyAdapter(mData);
        this.mRecyclerView.setAdapter(mAdapter);
//		RecyclerView.ItemDecoration decoration = new MyDecoration(this);
//		this.mRecyclerView.addItemDecoration(decoration);
        this.mAdapter.setOnItemClickListener(this);
        this.mAdapter.setOnItemLongClickListener(this);
    }

    /**
     * Item click
     */
    @Override
    public void onItemClick(View view, int postion) {
        MyItemBean bean = mData.get(postion);
        if(bean != null){
            Toast.makeText(getActivity(), bean.tv, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemLongClick(View view, int postion) {
        MyItemBean bean = mData.get(postion);
        if(bean != null){
            Toast.makeText(getActivity(), "LongClick "+bean.tv, Toast.LENGTH_SHORT).show();
        }
    }

}
