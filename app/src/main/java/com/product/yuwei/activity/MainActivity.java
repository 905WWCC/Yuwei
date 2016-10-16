package com.product.yuwei.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;

import com.product.yuwei.R;
import com.product.yuwei.fragment.LocalFragment;
import com.product.yuwei.fragment.NoteFragment;
import com.product.yuwei.fragment.RecommendFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    //按钮
    private RadioButton recommendButton;
    private RadioButton localButton;
    private RadioButton noteButton;

    //碎片
    private Fragment recommendFragment;
    private Fragment localFragment;
    private Fragment noteFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        recommendButton = (RadioButton) findViewById(R.id.recommend_button);
        localButton = (RadioButton) findViewById(R.id.local_button);
        noteButton = (RadioButton) findViewById(R.id.note_button);

        //监听
        recommendButton.setOnClickListener(this);
        localButton.setOnClickListener(this);
        noteButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.recommend_button:
                showCurrentFragment(1);
                break;
            case R.id.local_button:
                showCurrentFragment(2);
                break;
            case R.id.note_button:
                showCurrentFragment(3);
                break;
        }
    }

    private void showCurrentFragment(int i){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (i){
            case 1:
                if (recommendFragment == null) {
                    recommendFragment = new RecommendFragment();
                } else {
                    fragmentTransaction.replace(R.id.frame_layout,recommendFragment);
                }
                break;
            case 2:
                if (localFragment == null) {
                    localFragment = new LocalFragment();
                } else {
                    fragmentTransaction.replace(R.id.frame_layout,localFragment);
                }
                break;
            case 3:
                if (noteFragment == null) {
                    noteFragment = new NoteFragment();
                } else {
                    fragmentTransaction.replace(R.id.frame_layout,noteFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }

}

