package com.product.yuwei.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.product.yuwei.R;
//import com.product.yuwei.adapter.homeadapter.HomeAdapter;
import com.product.yuwei.bean.homebean.Crime;

import java.util.ArrayList;
import java.util.List;

/**推荐页面的fragment，我可能习惯命名为homepage 或者是home
 * Created by teng on 10/14/16.
 */
public class RecommendFragment extends ListFragment {

    private ListView mainListView;//整体以listview实现
    private RelativeLayout rlSearchBar;//搜索框
  //  private HomeAdapter mAdapter;

    private ArrayList<Crime> Crimes;

    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        TestAdapter testAdapter= new TestAdapter(Crimes);
        setListAdapter(testAdapter);



      //  HomeAdapter homeAdapter =new HomeAdapter(getContext(),homeItemList);
        //mainListView.setAdapter(homeAdapter);
        //  setListAdapter((ListAdapter) homeAdapter);

    }
    public ArrayList<Crime> getCrimes(){
        Crimes = new ArrayList<Crime>();
        for (int i = 0; i < 100; i++) {
            Crime c = new Crime();
            c.setTitle("Crime #" + i);
            c.setSolved(i % 2 == 0); // 相差一
            Crimes.add(c);
        }
        return Crimes;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.list_item_crime,container,false);
       // initView();//总方法
        return view;
    }

    private void initView() {

    }



    private class TestAdapter extends ArrayAdapter<Crime>{
        public TestAdapter(ArrayList<Crime> Crimes){
            super(getActivity(),android.R.layout.simple_list_item_1,Crimes);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (null == convertView) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.fragment_recommend, null);
            }
            Crime c = getItem(position);
            //以下是为了引用绑定的组件，并且装备配数据
            TextView titleTextView =
                    (TextView)convertView.findViewById(R.id.crime_list_item_titleTextView);
            titleTextView.setText(c.getTitle());
            TextView dateTextView =
                    (TextView)convertView.findViewById(R.id.crime_list_item_dateTextView);
            dateTextView.setText(c.getDate().toString());
            CheckBox solvedCheckBox =
                    (CheckBox)convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
            solvedCheckBox.setChecked(c.isSolved());

            return convertView;
        }

    }


}
