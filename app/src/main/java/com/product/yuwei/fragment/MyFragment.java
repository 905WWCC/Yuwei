package com.product.yuwei.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.product.yuwei.R;
import com.product.yuwei.bean.BaseFragment;

import java.util.zip.Inflater;

/**
 * Created by Administrator on 2016/10/17 0017.
 */
public class MyFragment extends BaseFragment{
    @Override
    public String getFragmentTitle() {
        return null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my,null,false);
        return view;
    }
}
