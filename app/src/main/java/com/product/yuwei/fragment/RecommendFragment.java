package com.product.yuwei.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.ListView;

import android.widget.Toast;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.product.yuwei.R;

import com.product.yuwei.adapter.homeadapter.HomeAdapter;
import com.product.yuwei.bean.homebean.RecomBaseBean;
import com.product.yuwei.bean.homebean.RecomNoteBean;
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
    private HomeAdapter homeAdapter;
    private ViewPager sViewPager;
    private String url="http://www.youyuwei.com/api/recommend?oauth_version=1.0&oauth_nonce=5f2698b2-12b6-4798-807c-aba26a1c78d4&oauth_consumer_key=5&device_type=android&screen_width=720&device_id=14%3Ab9%3A68%3A7b%3Acd%3Aa5&ver=6&ywsdk_ver=20140507&sys_ver=4.4.2&ver_code=37&channel_id=yingyongbao&oauth_signature=0tvWZoG5D6CjUYSE12ij61IxeVM%3D&x_auth_mode=client_auth&device_token=AuvKGi2ypE9kxeNnDxvtiRQWfAqOe-l-VwdpLaqeDvJL&oauth_signature_method=HMAC-SHA1&oauth_token=0_9837387abc33331ab&open_udid=14%3Ab9%3A68%3A7b%3Acd%3Aa5&app_ver=3.4&app_code=com.yuwei.android&oauth_timestamp=1478830995&screen_height=1280";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_recommend , container, false);
        mainListView= (ListView) view.findViewById(R.id.lv_fragment_recommend);
        rlSearchBar= (LinearLayout) view.findViewById(R.id.id_ll_want);
        sViewPager= (ViewPager) view.findViewById(R.id.id_recommend_vp);

        noteBeanlist=new ArrayList<RecomNoteBean>();
        getData();
       // addHeadView();
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

    private void addMQLView() {
        View mqlView=View.inflate(getContext(),R.layout.recommend_miqilin,null);
        mainListView.addHeaderView(mqlView);
    }

    private void addGridView() {
        View girdView=View.inflate(getContext(),R.layout.recommend_viewpager,null);
        mainListView.addHeaderView(girdView);
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
                //成功 ,将数据置于解析json的类中 并且执行
                try {
                   // dealData(responseInfo.result);
                    RecomBaseBean baseBean=RecomJsonPull.pullRecomjson(responseInfo.result);
                    noteBeanlist = baseBean.getNote_list();
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
    private void dealData(String result) throws JSONException {

        RecomJsonPull pulljson=new RecomJsonPull();
        RecomBaseBean baseBean=pulljson.pullRecomjson(result);
        noteBeanlist = baseBean.getNote_list();
        //list集合加入数据后刷新adapter;不刷新则获取不到数据；
        homeAdapter.refreshData(noteBeanlist);
    }





}
