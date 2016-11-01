package com.product.yuwei.fragment.noteFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.product.yuwei.R;
import com.product.yuwei.adapter.HotGridAdapter;
import com.product.yuwei.bean.BaseFragment;
import com.product.yuwei.bean.HotBase;
import com.product.yuwei.net.JsonTool;

import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Administrator on 2016/10/20 0020.
 */
public class HotFragment extends BaseFragment {

    private GridView hotTitle;
    private List<HotBase> list;

    private Context context;

    public HotFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View ret = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_note_hot, container, false);

        hotTitle = (GridView) ret.findViewById(R.id.hot_title);

        //获得数据
        byte[] arr = getData();
        try {

            int id = 1;
            String json = new String(arr,"utf-8");
            list = JsonTool.parserData(json,id);
            Log.e("listData",list+"");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        HotGridAdapter adapter = new HotGridAdapter(context,list);
        hotTitle.setAdapter(adapter);

        return ret;
    }

    private byte[] getData() {
        InputStream in = getResources().openRawResource(R.raw.hot_fragment_api);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        byte[] arr = new byte[1024];
        int len = 0;
        try {
            while ((len = in.read(arr))!= -1){
                bos.write(arr,0,len);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bos.toByteArray();
    }

    @Override
    public String getFragmentTitle() {
        return "热门";
    }
}
