package com.product.yuwei.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.product.yuwei.R;
import com.product.yuwei.adapter.CommonFragmentPagerAdapter;
import com.product.yuwei.bean.BaseFragment;
import com.product.yuwei.fragment.noteFragments.AttentionFragment;
import com.product.yuwei.fragment.noteFragments.HotFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by teng on 10/14/16.
 */
public class NoteFragment extends BaseFragment {
    private Context context;

    public NoteFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View ret = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_note, container, false);

        TabLayout tabLayout = (TabLayout) ret.findViewById(R.id.note_tablayout);
        ViewPager viewPager = (ViewPager) ret.findViewById(R.id.note_viewpager);

        List<BaseFragment> fragments = new ArrayList<BaseFragment>();

        fragments.add(new HotFragment(context));
        fragments.add(new AttentionFragment(context));

        CommonFragmentPagerAdapter adapter = new CommonFragmentPagerAdapter(getChildFragmentManager(),fragments);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        return ret;
    }
    @Override
    public String getFragmentTitle() {
        return "美食游记";
    }
}
