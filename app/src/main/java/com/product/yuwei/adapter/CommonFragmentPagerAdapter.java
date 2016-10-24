package com.product.yuwei.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.product.yuwei.bean.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 2016/10/20 0020.
 */
public class CommonFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> list;

    public CommonFragmentPagerAdapter(FragmentManager fm,List<BaseFragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        int count = 0;
        if (list != null) {
            count = list.size();
        }
        return count;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;

        BaseFragment baseFragment = list.get(position);
        title = baseFragment.getFragmentTitle();

        return title;
    }
}
