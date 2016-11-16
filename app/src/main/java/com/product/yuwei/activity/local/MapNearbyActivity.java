package com.product.yuwei.activity.local;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.product.yuwei.R;

public class MapNearbyActivity extends Activity {

    private TextView restAddress,restAddressE,zhinanTitle,zhinanText,chakan,restCost,rest_time_tv,restTele,tv1,reasonTv,search_text;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_nearby);
        init();
    }

    private void init() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        Toast.makeText(getApplicationContext(),id,Toast.LENGTH_SHORT).show();
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

    }
}
