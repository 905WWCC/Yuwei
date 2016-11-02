package com.product.yuwei.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.product.yuwei.R;
import com.product.yuwei.bean.BaseFragment;

/**
 * Created by teng on 10/14/16.
 */
public class LocalFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View ret = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_local,container,false);


        return ret;

    }

    @Override
    public String getFragmentTitle() {
        return "本地";
    }
}
