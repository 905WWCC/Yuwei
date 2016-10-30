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

    public static List<HotBase> parserData(String jsonString) throws JSONException {

        List<HotBase> list = new ArrayList<HotBase>();
        HotBase hotBase = new HotBase();

        JSONObject object = new JSONObject(jsonString);

        JSONObject data = object.getJSONObject("data");
        JSONArray dataList = data.getJSONArray("list");

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

        return list;
    }

}
