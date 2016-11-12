package com.product.yuwei.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;

import com.product.yuwei.R;
import com.product.yuwei.fragment.LocalFragment;
import com.product.yuwei.fragment.MyFragment;
import com.product.yuwei.fragment.NoteFragment;
import com.product.yuwei.fragment.RecommendFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //按钮
    private RadioButton recommendButton;
    private RadioButton localButton;
    private RadioButton noteButton;
    private RadioButton myButton;

    //碎片
    private Fragment recommendFragment;
    private Fragment localFragment;
    private Fragment noteFragment;
    private Fragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        recommendButton = (RadioButton) findViewById(R.id.recommend_button);
        localButton = (RadioButton) findViewById(R.id.local_button);
        noteButton = (RadioButton) findViewById(R.id.note_button);
        myButton = (RadioButton) findViewById(R.id.mine_button);


        //监听
        recommendButton.setOnClickListener(this);
        localButton.setOnClickListener(this);
        noteButton.setOnClickListener(this);
        myButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        restartButton();
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
            case R.id.mine_button:
                showCurrentFragment(4);
                break;
        }
    }

    private void showCurrentFragment(int i){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hideFragments(fragmentTransaction);
        switch (i){
            case 1:
                Drawable recommend_click = ContextCompat.getDrawable(getApplication(),R.mipmap.tab_more_recommend);
                recommendButton.setCompoundDrawablesWithIntrinsicBounds(null, recommend_click, null, null);
                recommendButton.setTextColor(0xffFFA500);
                if (recommendFragment == null) {
                    recommendFragment = new RecommendFragment();
                    fragmentTransaction.add(R.id.frame_layout,recommendFragment);
                } else {
                    fragmentTransaction.show(recommendFragment);
                }
                break;
            case 2:
                Drawable local_click = ContextCompat.getDrawable(getApplication(),R.mipmap.local_or);
                localButton.setCompoundDrawablesWithIntrinsicBounds(null, local_click, null, null);
                localButton.setTextColor(0xffFFA500);
                if (localFragment == null) {
                    localFragment = new LocalFragment();
                    fragmentTransaction.add(R.id.frame_layout,localFragment);
                } else {
                    fragmentTransaction.show(localFragment);
                }
                break;
            case 3:
                Drawable note_click = ContextCompat.getDrawable(getApplication(),R.mipmap.bottom_note_orange);
                noteButton.setCompoundDrawablesWithIntrinsicBounds(null, note_click, null, null);
                noteButton.setTextColor(0xffFFA500);
                if (noteFragment == null) {
                    noteFragment = new NoteFragment(this);
                    fragmentTransaction.add(R.id.frame_layout,noteFragment);
                } else {
                    fragmentTransaction.show(noteFragment);
                }
                break;
            case 4:
                Drawable my_click = ContextCompat.getDrawable(getApplication(),R.mipmap.tab_mine_orange);
                myButton.setCompoundDrawablesWithIntrinsicBounds(null, my_click, null, null);
                myButton.setTextColor(0xffFFA500);
                if (myFragment == null) {
                    myFragment = new MyFragment();
                    fragmentTransaction.add(R.id.frame_layout,myFragment);
                } else {
                    fragmentTransaction.show(myFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }
    public void restartButton(){
        Drawable recommend = ContextCompat.getDrawable(getApplication(),R.mipmap.tab_recommend);
        Drawable local = ContextCompat.getDrawable(getApplication(),R.mipmap.local_white);
        Drawable note = ContextCompat.getDrawable(getApplication(),R.mipmap.bottom_note);
        Drawable mine = ContextCompat.getDrawable(getApplication(), R.mipmap.tab_mine);
        recommendButton.setCompoundDrawablesWithIntrinsicBounds(null, recommend, null, null);
        localButton.setCompoundDrawablesWithIntrinsicBounds(null, local, null, null);
        noteButton.setCompoundDrawablesWithIntrinsicBounds(null, note, null, null);
        myButton.setCompoundDrawablesWithIntrinsicBounds(null, mine, null, null);
        recommendButton.setTextColor(0xff404040);
        localButton.setTextColor(0xff404040);
        noteButton.setTextColor(0xff404040);
        myButton.setTextColor(0xff404040);
    }
    //隐藏所有的Fragment,避免fragment混乱
    private void hideFragments(FragmentTransaction transaction) {
        if (recommendFragment != null) {
            transaction.hide(recommendFragment);
        }
        if (localFragment != null) {
            transaction.hide(localFragment);
        }
        if (noteFragment !=null){
            transaction.hide(noteFragment);
        }
        if (myFragment != null) {
            transaction.hide(myFragment);
        }
    }




}

