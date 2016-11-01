package com.product.yuwei.net;

import com.product.yuwei.bean.HotBase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/30 0030.
 */
public class JsonTool {

    public static List<HotBase> parserData(String jsonString,int id) throws JSONException {

        List<HotBase> list = new ArrayList<HotBase>();
        HotBase hotBase = new HotBase();

        JSONObject object = new JSONObject(jsonString);

        JSONObject data = object.getJSONObject("data");
        JSONArray dataList = data.getJSONArray("list");

        switch (id){
            case 1:
                for (int i = 0; i < dataList.length(); i++) {
                    JSONObject jsonObject = dataList.getJSONObject(i);

                    String name = jsonObject.getString("name");
                    String cover = jsonObject.getString("cover");
                    int plnum = jsonObject.getInt("plnum");
                    int imgnum = jsonObject.getInt("imgnum");
                    int readnum = jsonObject.getInt("readnum");
                    String text = jsonObject.getString("text");

                    //作者
                    JSONObject author = jsonObject.getJSONObject("author");
                    String uname = author.getString("uname");
                    String header = author.getString("header");
                    String level = author.getString("level");

                    hotBase.setName(name);
                    hotBase.setCover(cover);
                    hotBase.setPlnum(plnum);
                    hotBase.setImgnum(imgnum);
                    hotBase.setReadnum(readnum);
                    hotBase.setText(text);
                    hotBase.setAuthor_uname(uname);
                    hotBase.setAuthor_header(header);
                    hotBase.setLevel(level);

                    list.add(hotBase);
                }
                break;
            case 2:

                for (int i = 0; i < dataList.length(); i++) {

                    JSONObject jsonObject = dataList.getJSONObject(i);

                    String att_uname = jsonObject.getString("uname");
                    String att_header = jsonObject.getString("header");
                    String att_desc = jsonObject.getString("desc");
                    String att_vname = jsonObject.getString("vname");

                    JSONArray label = jsonObject.getJSONArray("label");
                    String att_label_name1 = label.getJSONObject(0).getString("name");
                    String att_label_name2 = label.getJSONObject(1).getString("name");
                    String att_label_name3 = label.getJSONObject(2).getString("name");


                    hotBase.setAtt_header(att_header);
                    hotBase.setAtt_uname(att_uname);
                    hotBase.setAtt_desc(att_desc);
                    hotBase.setAtt_vname(att_vname);
                    hotBase.setAtt_label_name1(att_label_name1);
                    hotBase.setAtt_label_name2(att_label_name2);
                    hotBase.setAtt_label_name3(att_label_name3);

                    list.add(hotBase);

                }
                break;

        }



        return list;
    }

}
