package com.product.yuwei.fragment.noteFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.product.yuwei.R;
import com.product.yuwei.bean.BaseFragment;

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

        //接口:   http://www.youyuwei.com/api/note?oauth_version=1.0&oauth_nonce=8955cab1-df21-4202-a014-40a4d10d0bea&oauth_consumer_key=5&device_type=android&screen_width=720&list=RefinedList&device_id=e0%3A19%3A1d%3A03%3A37%3Aa3&ver=6&ywsdk_ver=20140507&sys_ver=4.2.2&ver_code=37&channel_id=huawei&oauth_signature=vBcO9Ch4%2B57pdJWmhe9ZdghN7PQ%3D&x_auth_mode=client_auth&start=0&device_token=Antdyhaq_MpCmANq7deDciqg93h0cf7T1XBc6iO8GBNZ&oauth_signature_method=HMAC-SHA1&oauth_token=0_9837387abc33331ab&open_udid=e0%3A19%3A1d%3A03%3A37%3Aa3&app_ver=3.4&app_code=com.yuwei.android&oauth_timestamp=1477316526&screen_height=1280

        String path = "http://www.youyuwei.com/api/note?oauth_version=1.0&oauth_nonce=8955cab1-df21-4202-a014-40a4d10d0bea&oauth_consumer_key=5&device_type=android&screen_width=720&list=RefinedList&device_id=e0%3A19%3A1d%3A03%3A37%3Aa3&ver=6&ywsdk_ver=20140507&sys_ver=4.2.2&ver_code=37&channel_id=huawei&oauth_signature=vBcO9Ch4%2B57pdJWmhe9ZdghN7PQ%3D&x_auth_mode=client_auth&start=0&device_token=Antdyhaq_MpCmANq7deDciqg93h0cf7T1XBc6iO8GBNZ&oauth_signature_method=HMAC-SHA1&oauth_token=0_9837387abc33331ab&open_udid=e0%3A19%3A1d%3A03%3A37%3Aa3&app_ver=3.4&app_code=com.yuwei.android&oauth_timestamp=1477316526&screen_height=1280";

//        XHttpTool.getDataByPost(path,);

        return ret;
    }

    @Override
    public String getFragmentTitle() {
        return "热门";
    }
}
