package com.product.yuwei.activity.local;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.product.yuwei.R;

public class MapNearbyActivity extends Activity implements View.OnClickListener{
    private RelativeLayout rest_more_layout;
    private TextView restAddress,restAddressE,zhinanTitle,zhinanText,chakan,restCost,rest_time_tv,restTele,tv1,reasonTv,search_text;
    private ImageView image;
    private String rest_desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_nearby);
        init();
    }

    private void init() {

        Bundle intent = getIntent().getExtras();
        String rest_id = intent.getString("rest_id");
        String rest_name = intent.getString("rest_name");
        int rest_cost = intent.getInt("rest_cost");

        String rest_cover = intent.getString("rest_cover");
        String rest_address = intent.getString("rest_address");
        String rest_open_time = intent.getString("rest_open_time");
        String rest_reason = intent.getString("rest_reason");
        rest_desc = intent.getString("rest_desc");
        String rest_phone = intent.getString("rest_phone");
        rest_more_layout = (RelativeLayout) findViewById(R.id.rest_more_layout);
        rest_more_layout.setOnClickListener(this);
        restAddress = (TextView) findViewById(R.id.restAddress);
        restAddressE = (TextView) findViewById(R.id.restAddressE);
        zhinanTitle = (TextView) findViewById(R.id.zhinanTitle);
        zhinanText = (TextView) findViewById(R.id.zhinanText);
        chakan = (TextView) findViewById(R.id.chakan);
        restCost = (TextView) findViewById(R.id.restCost);
        rest_time_tv = (TextView) findViewById(R.id.rest_time_tv);
        restTele = (TextView) findViewById(R.id.restTele);
        tv1 = (TextView) findViewById(R.id.tv1);
        reasonTv = (TextView) findViewById(R.id.reasonTv);
        search_text = (TextView) findViewById(R.id.search_text);
        image = (ImageView) findViewById(R.id.image);

        restAddress.setText(rest_address);
        restCost.setText(!String.valueOf(rest_cost).isEmpty()?("人均" + rest_cost + "元"):"暂无");
        rest_time_tv.setText(rest_open_time);
        rest_time_tv.setText("营业时间:"+(!rest_open_time.isEmpty()?rest_open_time:"暂无"));
        restTele.setText(!rest_phone.isEmpty() ? rest_phone:"暂无");
        reasonTv.setText(!rest_reason.isEmpty() ? rest_reason : "暂无");
//        image.setImageResource(Integer.parseInt(rest_cover));
        Glide
                .with(getApplicationContext())
                .load(rest_cover)
                .centerCrop()
                .into(image);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rest_more_layout:
//                Dialog alertDialog = new AlertDialog.Builder(this).
                    AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
                        builder.setIcon(R.mipmap.dish_reason).
                        setTitle("推荐理由").
                        setMessage(rest_desc).
                        create();
                        builder.show();
//                alertDialog.getWindow().setLayout(300,200);
//                WindowManager.LayoutParams params =
//                        alertDialog.getWindow().getAttributes();
//                params.width = 200;
//                params.height = 200;


        }
    }
}
