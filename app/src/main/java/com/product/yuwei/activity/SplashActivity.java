package com.product.yuwei.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.product.yuwei.R;

/**
 * Created by Administrator on 2016/10/17 0017.
 */
public class SplashActivity extends Activity {

    private ImageView logo;
    private ImageView bi;
    private ImageView lvtu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        logo = (ImageView) findViewById(R.id.start_logo);
        bi = (ImageView) findViewById(R.id.start_bi);
        lvtu = (ImageView) findViewById(R.id.start_lvtu);





        //设置加载动画透明度渐变从(0.1不显示-1.0完全显示)
        AlphaAnimation logoAnimation = new AlphaAnimation(0.4f,1.0f);
        //设置动画时间 例如5000 是5秒
        logoAnimation.setDuration(100);
        //组件和动画关联
        logo.setAnimation(logoAnimation);

        logoAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {


                bi.setImageResource(R.drawable.start_bi);
                AlphaAnimation biAnimation = new AlphaAnimation(0.1f,1.0f);
                biAnimation.setDuration(500);
                bi.setAnimation(biAnimation);

                biAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        lvtu.setImageResource(R.drawable.start_lvtu);
                        AlphaAnimation lvtuAnimation = new AlphaAnimation(0.1f,1.0f);
                        lvtuAnimation.setDuration(1000);
                        lvtu.setAnimation(lvtuAnimation);

                        lvtuAnimation.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                Intent intent = new Intent(SplashActivity.this,GuideActivity.class);
                                startActivity(intent);
                                finish();
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {
                            }
                        });

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
}
