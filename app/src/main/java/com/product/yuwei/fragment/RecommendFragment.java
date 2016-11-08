package com.product.yuwei.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.product.yuwei.R;
//import com.product.yuwei.adapter.homeadapter.HomeAdapter;
import com.product.yuwei.bean.homebean.Crime;
import com.product.yuwei.bean.homebean.RecomBaseBean;
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
    private RelativeLayout rlSearchBar;//搜索框
    //private HomeAdapter mAdapter;
     private RecomBaseBean baseBean;


    private String url="http://www.youyuwei.com/api/recommend?oauth_version=1.0&oauth_nonce=99264244-9aa0-42f5-b8b3-896403d88c44&oauth_consumer_key=5&device_type=android&screen_width=720&device_id=14%3Ab9%3A68%3A7b%3Acd%3Aa5&ver=6&ywsdk_ver=20140507&sys_ver=4.4.2&ver_code=37&channel_id=yingyongbao&oauth_signature=kU5oBZZOEQlY57e%2FERhOXsuovHU%3D&x_auth_mode=client_auth&device_token=AuvKGi2ypE9kxeNnDxvtiRQWfAqOe-l-VwdpLaqeDvJL&oauth_signature_method=HMAC-SHA1&oauth_token=0_9837387abc33331ab&open_udid=14%3Ab9%3A68%3A7b%3Acd%3Aa5&app_ver=3.4&app_code=com.yuwei.android&oauth_timestamp=1478436218&screen_height=1280";

    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取网络数据
        //使用异步 在异步线程中解析 异步线程中的将数据装填好，下面就可以使用数据了
        //解析数据并且set到bean 中

        HttpUtils http = new HttpUtils();
        http.send(HttpMethod.GET, url, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                //成功 ,将数据置于解析json的类中 并且执行
                try {
                     baseBean=RecomJsonPull.pullRecomjson(responseInfo.result);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(HttpException e, String s) {
                Toast.makeText(getContext(), "失败", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_recommend , container, false);
        mainListView= (ListView) view.findViewById(R.id.lv_fragment_recommend);
        baseBean.getNote_list();//这里的baseBean是空的





        initView();
        return view;
    }

    private void initView() {

    }




}
