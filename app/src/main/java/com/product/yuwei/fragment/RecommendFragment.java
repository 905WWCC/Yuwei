package com.product.yuwei.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.product.yuwei.R;

import com.product.yuwei.adapter.homeadapter.GridViewAdapter;
import com.product.yuwei.adapter.homeadapter.GridViewPagerAdapter;
import com.product.yuwei.adapter.homeadapter.HomeAdapter;
import com.product.yuwei.adapter.homeadapter.SidesPageAdapter;
import com.product.yuwei.bean.homebean.RecomBaseBean;
import com.product.yuwei.bean.homebean.RecomHotBean;
import com.product.yuwei.bean.homebean.RecomNoteBean;
import com.product.yuwei.bean.homebean.RecomPageBean;
import com.product.yuwei.tool.RecomJsonPull;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**推荐页面的fragment，我可能习惯命名为homepage 或者是home
 * Created by teng on 10/14/16.
 */
public class RecommendFragment extends Fragment {

    private ListView mainListView;//整体以listview实现
    private LinearLayout rlSearchBar;//搜索框
    private List<RecomNoteBean> noteBeanlist;
    private List<String> baseTotTitleList;
    private List<RecomHotBean> hotBeanlist1;
    private List<RecomHotBean> hotBeenlist2;
    private List<RecomHotBean> hotBeanLIst3;
    private List<RecomHotBean> hotBeanLIst4;
    private List<RecomHotBean> hotBeanLIst5;
    private HomeAdapter homeAdapter;
    private GridViewAdapter gridViewAdapter;
    private GridViewPagerAdapter gridViewPagerAdapter;
    private GridViewPagerAdapter sidesPageAdapter;
    private List<List<RecomHotBean>> baseHotBean;
    private  List<View> gridViewList;
    private List<RecomPageBean> pageBeanList;
    private List<View> pageViewlist;
    private ImageView pageView;
    private ViewPager sViewPager;
    private String url="http://www.youyuwei.com/api/recommend?oauth_version=1.0&oauth_nonce=81f948ae-eb53-447e-8aed-1025e8855f29&oauth_consumer_key=5&device_type=android&screen_width=720&device_id=14%3Ab9%3A68%3A7b%3Acd%3Aa5&ver=6&ywsdk_ver=20140507&sys_ver=4.4.2&ver_code=37&channel_id=yingyongbao&oauth_signature=a2qFC%2BnuTU%2BIKz7JRo5RzOW%2FTr8%3D&x_auth_mode=client_auth&device_token=AuvKGi2ypE9kxeNnDxvtiRQWfAqOe-l-VwdpLaqeDvJL&oauth_signature_method=HMAC-SHA1&oauth_token=0_9837387abc33331ab&open_udid=14%3Ab9%3A68%3A7b%3Acd%3Aa5&app_ver=3.4&app_code=com.yuwei.android&oauth_timestamp=1479543503&screen_height=1280";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_recommend , container, false);
        mainListView= (ListView) view.findViewById(R.id.lv_fragment_recommend);
        rlSearchBar= (LinearLayout) view.findViewById(R.id.id_ll_want);
        //sViewPager= (ViewPager) view.findViewById(R.id.id_recommend_vp);

        noteBeanlist=new ArrayList<RecomNoteBean>();
        getData();
        addSlidPageView();
        addSearchView();
        addWantoView();
        addMQLView();
        addGridView();
        addBanView();
        addTitleView();
        homeAdapter=new HomeAdapter(getContext(),noteBeanlist);
        mainListView.setAdapter(homeAdapter);
       /* mainListView.setOnScrollListener(new AbsListView.OnScrollListener(){
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i){

            }

            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem,int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem >= 3) {
                    rlSearchBar.setVisibility(View.VISIBLE);
                } else {
                    rlSearchBar.setVisibility(View.GONE);
                }
            }
        });*/
        return view;
    }

    private void addSlidPageView() {
        pageViewlist=new ArrayList<>();
        View view =View.inflate(getContext(),R.layout.recommend_head_vp,null);
        ViewPager viewpager= (ViewPager) view.findViewById(R.id.id_recommend_head_vp);
        sidesPageAdapter=new GridViewPagerAdapter(getContext(),pageViewlist);
        viewpager.setAdapter(sidesPageAdapter);
        mainListView.addHeaderView(view);


    }


    private void addMQLView() {
        View mqlView=View.inflate(getContext(),R.layout.recommend_miqilin,null);
        mainListView.addHeaderView(mqlView);


    }

    private void addGridView() {
       // View girdView=View.inflate(getContext(),R.layout.recommend_viewpager,null);
        gridViewList=new ArrayList<>();
        View gView= LayoutInflater.from(getActivity()).inflate(R.layout.recommend_viewpager, null);
        ViewPager viewPager= (ViewPager) gView.findViewById(R.id.id_recommend_vp);
        GridView gridView= (GridView) gView.findViewById(R.id.id_recommend_gv);
        //遍历数组产生GridView 然后组装GridView
        gridViewPagerAdapter=new GridViewPagerAdapter(getContext(),gridViewList);
        viewPager.setAdapter(gridViewPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("测试代码", "onPageScrolled滑动中" + position);
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("测试代码", "onPageSelected选中了" + position);

            }


            @Override
            public void onPageScrollStateChanged(int state) {

                if (state == ViewPager.SCROLL_STATE_DRAGGING) {
                    //正在滑动   pager处于正在拖拽中

                    Log.d("测试代码", "onPageScrollStateChanged=======正在滑动" + "SCROLL_STATE_DRAGGING");

                } else if (state == ViewPager.SCROLL_STATE_SETTLING) {
                    //pager正在自动沉降，相当于松手后，pager恢复到一个完整pager的过程
                    Log.d("测试代码", "onPageScrollStateChanged=======自动沉降" + "SCROLL_STATE_SETTLING");

                } else if (state == ViewPager.SCROLL_STATE_IDLE) {
                    //空闲状态  pager处于空闲状态
                    Log.d("测试代码", "onPageScrollStateChanged=======空闲状态" + "SCROLL_STATE_IDLE");
                }


            }
        });

        gridView.setAdapter(gridViewAdapter);

        mainListView.addHeaderView(gView);
    }

    private void addWantoView() {
        View wanView=View.inflate(getContext(),R.layout.recommend_item_wantgo,null);
        mainListView.addHeaderView(wanView);

    }

    private void addSearchView() {
        View searchView =View.inflate(getContext(),R.layout.recommend_search,null);
        mainListView.addHeaderView(searchView);
    }

    private void addBanView() {
        View banView =View.inflate(getContext(),R.layout.recommend_note_ban,null);
        mainListView.addHeaderView(banView);
    }

    private void addTitleView() {
        View titleView =View.inflate(getContext(),R.layout.recommend_note_title,null);
        mainListView.addHeaderView(titleView);
    }

    private void getData() {
        HttpUtils http = new HttpUtils();
        http.send(HttpMethod.GET, url, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                try {
                    RecomBaseBean baseBean=RecomJsonPull.pullRecomjson(responseInfo.result);
                    noteBeanlist = baseBean.getNote_list();
                    baseHotBean=baseBean.getBaseHotBean();

                    baseTotTitleList=baseBean.getBaseHotTitle();
                    pageBeanList=baseBean.getList_page();


                    //解出baseHotBean数据，
                    for (int i = 0; i <baseHotBean.size() ; i++) {
                        GridView gv=new GridView(getContext());
                        gv.setAdapter(new GridViewAdapter(getContext(),baseHotBean.get(i)));
                        //gridViewAdapter=new GridViewAdapter(getContext(),baseHotBean.get(i));
                     //   gridViewAdapter.refreshData(baseHotBean.get(i));//将json数据传入适配器

                        //下面设置一下gv ，一些布局上的设置
                        gv.setGravity(Gravity.CENTER);
                        gv.setClickable(true);
                        gv.setFocusable(true);
                        gv.setNumColumns(3);
                        //置于list中
                        gridViewList.add(gv);
                    }
                    for (int i = 0; i <pageBeanList.size() ; i++) {
                        ImageView page=new ImageView(getContext());
                        Glide
                                .with(getContext())
                                .load(pageBeanList.get(i).getImg())
                                .centerCrop()
                                .into(page);
                        pageViewlist.add(page);

                    }

                    sidesPageAdapter.refreshData(pageViewlist);
                    gridViewPagerAdapter.refreshData(gridViewList);//将GridView数据传入适配器中

                    //list集合加入数据后刷新adapter;不刷新则获取不到数据；
                    homeAdapter.refreshData(noteBeanlist);



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(HttpException e, String s) {
                Toast.makeText(getContext(), "失败", Toast.LENGTH_LONG).show();
            }
            @Override
            public void onLoading(long total, long current, boolean isUploading) {
                // TODO Auto-generated method stub
                super.onLoading(total, current, isUploading);
            }
        });
    }






}
