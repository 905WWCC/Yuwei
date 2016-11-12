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

        List<HotBase> list = null;

        switch (id){
            case 1:
                list = new ArrayList<HotBase>();
                HotBase hotBase = null;
                JSONObject object = new JSONObject(jsonString);

                JSONObject data = object.getJSONObject("data");
                JSONArray dataList = data.getJSONArray("list");
                for (int i = 0; i < dataList.length(); i++) {
                    JSONObject jsonObject = dataList.getJSONObject(i);

                    hotBase = new HotBase();

                    String name = jsonObject.getString("name");
                    String cover = jsonObject.getString("cover");
                    int vote = jsonObject.getInt("vote");
                    int fav = jsonObject.getInt("fav");
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
                    hotBase.setVote(vote);
                    hotBase.setFav(fav);
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
                list = new ArrayList<HotBase>();
                HotBase hotBase1 = null;
                JSONObject object1 = new JSONObject(jsonString);

                JSONObject data1 = object1.getJSONObject("data");
                JSONArray dataList1 = data1.getJSONArray("list");

                for (int i = 0; i < dataList1.length(); i++) {

                    JSONObject jsonObject = dataList1.getJSONObject(i);

                    hotBase1 = new HotBase();

                    String att_uname = jsonObject.getString("uname");
                    String att_header = jsonObject.getString("header");
                    String att_desc = jsonObject.getString("desc");
                    String att_vname = jsonObject.getString("vname");

                    JSONArray label = jsonObject.getJSONArray("label");
                    String att_label_name1 = label.getJSONObject(0).getString("name");
                    String att_label_name2 = label.getJSONObject(1).getString("name");
                    String att_label_name3 = label.getJSONObject(2).getString("name");


                    hotBase1.setAtt_header(att_header);
                    hotBase1.setAtt_uname(att_uname);
                    hotBase1.setAtt_desc(att_desc);
                    hotBase1.setAtt_vname(att_vname);
                    hotBase1.setAtt_label_name1(att_label_name1);
                    hotBase1.setAtt_label_name2(att_label_name2);
                    hotBase1.setAtt_label_name3(att_label_name3);

                    list.add(hotBase1);
                }
                break;
        }
        return list;
    }

}
