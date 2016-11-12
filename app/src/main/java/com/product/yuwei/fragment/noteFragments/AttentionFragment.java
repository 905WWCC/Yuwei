package com.product.yuwei.fragment.noteFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.product.yuwei.R;
import com.product.yuwei.YuweiApplication;
import com.product.yuwei.adapter.AttentionAdapter;
import com.product.yuwei.bean.BaseFragment;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class AttentionFragment extends BaseFragment {

    private ListView attList;

    private Context context;

    public AttentionFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View ret = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_note_attention,container,false);

        attList = (ListView) ret.findViewById(R.id.attention_listview);

        if (YuweiApplication.attBasesList != null) {
            AttentionAdapter adapter = new AttentionAdapter(context,YuweiApplication.attBasesList);
            attList.setAdapter(adapter);
        }

        return ret;
    }

    @Override
    public String getFragmentTitle() {
        return "关注";
    }
}
