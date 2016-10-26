package com.product.yuwei.fragment.noteFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.product.yuwei.R;
import com.product.yuwei.bean.BaseFragment;
import com.product.yuwei.net.RequestListener;
import com.product.yuwei.net.XHttpTool;

import org.xutils.http.RequestParams;

/**
 * Created by Administrator on 2016/10/20 0020.
 */
public class HotFragment extends BaseFragment {

    private GridView hotTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View ret = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_note_hot, container, false);

        hotTitle = (GridView) ret.findViewById(R.id.hot_title);

        //第三个页面
        RequestParams path = new RequestParams("http://www.youyuwei.com/api/localcity?oauth_version=1.0&oauth_nonce=f65474ce-64b6-4f20-beb9-4a0109ba9da7&oauth_consumer_key=5&device_type=android&screen_width=720&lng=110.923366&device_id=e0%3A19%3A1d%3A03%3A37%3Aa3&ver=6&ywsdk_ver=20140507&sys_ver=4.2.2&ver_code=37&channel_id=huawei&oauth_signature=aDc2AYbhOjt%2FURiCnUdAaybChnc%3D&x_auth_mode=client_auth&device_token=Antdyhaq_MpCmANq7deDciqg93h0cf7T1XBc6iO8GBNZ&oauth_signature_method=HMAC-SHA1&oauth_token=0_9837387abc33331ab&open_udid=e0%3A19%3A1d%3A03%3A37%3Aa3&lat=21.677562&app_ver=3.4&app_code=com.yuwei.android&oauth_timestamp=1477474544&screen_height=1280");

        XHttpTool.getDataByPost(path, new RequestListener() {
            @Override
            public void onSuccess(String result) {
                //返回的东西，Json解析后说软件是盗版的
                Log.e("data",result);
            }
        });

//        XHttpTool.getDataByGet(path, new RequestListener() {
//            @Override
//            public void onSuccess(String result) {
//                Log.e("data",result);
//            }
//        });


        return ret;
    }

    @Override
    public String getFragmentTitle() {
        return "热门";
    }
}
