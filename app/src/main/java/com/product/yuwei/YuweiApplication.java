package com.product.yuwei;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;
import com.product.yuwei.bean.HotBase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.x;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by teng on 10/14/16.
 */
public class YuweiApplication extends Application {

    public static List<HotBase> attBasesList = new ArrayList<>();
    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
        //初始化
        x.Ext.init(this);
        //设置是否输出debug
        x.Ext.setDebug(BuildConfig.DEBUG);


        try {
            InputStream is = getResources().openRawResource(R.raw.attention_fragment_api);
            String text = readText(is);
            JSONObject jsonObject = new JSONObject(text);
            JSONObject data1 = jsonObject.getJSONObject("data");
            JSONArray dataList1 = data1.getJSONArray("list");
            for (int i = 0; i < dataList1.length(); i++) {
                JSONObject js = dataList1.getJSONObject(i);
                HotBase hotBase = new HotBase(js);
                attBasesList.add(hotBase);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String readText(InputStream is) throws IOException {
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuffer buffer = new StringBuffer("");
        String str;

        while ((str = bufferedReader.readLine()) != null){
            buffer.append(str);
        }

        return buffer.toString();
    }

}
