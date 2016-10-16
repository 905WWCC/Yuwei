package com.product.yuwei.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.product.yuwei.bean.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 2016/10/16 0016.
 */
public class CommonFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragments;

    public CommonFragmentPagerAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        int count = 0;
        if (fragments != null) {
            count = fragments.size();
        }
        return count;
    }

    //获得每个fragment的标题

    @Override
    public CharSequence getPageTitle(int position) {
        String ret = null;

        BaseFragment baseFragment = fragments.get(position);

        ret = baseFragment.getFragmentTitle();

        return ret;
    }
}
