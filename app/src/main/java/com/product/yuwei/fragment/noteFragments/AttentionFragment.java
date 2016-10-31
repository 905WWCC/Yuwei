package com.product.yuwei.fragment.noteFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.product.yuwei.R;
import com.product.yuwei.bean.BaseFragment;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class AttentionFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View ret = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_note_attention,container,false);

        return ret;

    }

    @Override
    public String getFragmentTitle() {
        return "关注";
    }
}
