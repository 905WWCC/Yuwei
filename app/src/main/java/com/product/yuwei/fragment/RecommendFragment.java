package com.product.yuwei.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.product.yuwei.R;
import com.product.yuwei.adapter.homeadapter.HomeAdapter;
import com.product.yuwei.bean.BaseFragment;
import com.product.yuwei.bean.homebean.HomeItem;

import java.util.ArrayList;
import java.util.List;

/**推荐页面的fragment，我可能习惯命名为homepage 或者是home
 * Created by teng on 10/14/16.
 */
public class RecommendFragment extends BaseFragment {

    private ListView mainListView;//整体以listview实现
    private RelativeLayout rlSearchBar;//搜索框
    private HomeAdapter mAdapter;
    private List<HomeItem> homeItemList=new ArrayList<>();

    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //HomeAdapter homeAdapter =new HomeAdapter(this,homeItemLIst);
        //mainListView.setAdapter((ListAdapter) homeAdapter);
        //  setListAdapter((ListAdapter) homeAdapter);
        initView();//总方法


    }

    private void initView() {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View ret = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_recommend,container,false);

        return ret;

    }

    public String getFragmentTitle() {
        return "推荐";
    }
}
