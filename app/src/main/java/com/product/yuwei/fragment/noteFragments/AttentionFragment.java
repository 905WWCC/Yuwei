package com.product.yuwei.fragment.noteFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.product.yuwei.R;
import com.product.yuwei.adapter.AttentionAdapter;
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
 * Created by Administrator on 2016/10/31 0031.
 */
public class AttentionFragment extends BaseFragment {

    private ListView listView;
    private List<HotBase> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View ret = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_note_attention,container,false);

        listView = (ListView) ret.findViewById(R.id.attention_listview);


        byte[] arr = getData();
        try {

            int id = 2;
            String json = new String(arr,"utf-8");
            list = JsonTool.parserData(json,id);


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AttentionAdapter adapter = new AttentionAdapter(getContext(),list);
        listView.setAdapter(adapter);

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
        return "关注";
    }
}
