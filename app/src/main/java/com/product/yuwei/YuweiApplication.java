package com.product.yuwei;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;
import com.product.yuwei.bean.HotBase;
import com.product.yuwei.bean.localbean.AboutVisitBean;
import com.product.yuwei.bean.localbean.LocalDataBean;
import com.product.yuwei.bean.localbean.LocalDataBean1;
import com.product.yuwei.bean.localbean.MustEatBean;

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
    public static List<LocalDataBean1> attLocalList = new ArrayList<>();
    public static List<AboutVisitBean> attAboutVisitList = new ArrayList<>();
    public static List<MustEatBean> attrMustEatList = new ArrayList<>();
    public static String local_text;
    public static int sum;
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


            InputStream in = getResources().openRawResource(R.raw.local_fragment_api);
            local_text = readText(in);
            JSONObject local_jsonObject = new JSONObject(local_text);
            JSONObject local_data = local_jsonObject.getJSONObject("data");
            JSONArray local_dataList = local_data.getJSONArray("list");
//            for (int j = 0; j < local_dataList.length(); j++) {
                JSONObject local_jsobject0 = local_dataList.getJSONObject(0);
                JSONObject local_jsobject1 = local_dataList.getJSONObject(1);
                JSONObject local_jsobject2 = local_dataList.getJSONObject(2);
                JSONObject local_jsobject3 = local_dataList.getJSONObject(3);
                JSONObject local_jsobject4 = local_dataList.getJSONObject(4);

                if(!local_jsobject2.isNull("content")){
                    JSONArray content = local_jsobject2.getJSONArray("content");
                    sum = content.length();
                    for (int i = 0; i < content.length(); i++){
                        JSONObject jo = content.getJSONObject(i);
                        MustEatBean mustEatBean = new MustEatBean(jo);
                        attrMustEatList.add(mustEatBean);
                    }
                }

                if(!local_jsobject3.isNull("content")){
                    JSONArray content = local_jsobject3.getJSONArray("content");
                    for (int i = 0; i < content.length(); i++){
                        JSONObject jo = content.getJSONObject(i);
                        LocalDataBean1 localDataBean1 = new LocalDataBean1(jo);
                        attLocalList.add(localDataBean1);
                    }
                }

                if(!local_jsobject4.isNull("content")){
                    JSONArray content = local_jsobject4.getJSONArray("content");
                    for (int i = 0; i<content.length(); i++){
                        JSONObject jo = content.getJSONObject(i);
                        AboutVisitBean aboutVisitBean = new AboutVisitBean(jo);
                        attAboutVisitList.add(aboutVisitBean);
                    }
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
