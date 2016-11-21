package com.product.yuwei.bean.localbean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/13 0013.
 */
public class LocalDataBean{
    public static List<LocalDataBean1> localDataBeans = new ArrayList<>();
    public LocalDataBean() {
    }
    private String type;
    private String name;

    private String summary;

    private int cost;

    private String cover;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }



    public LocalDataBean(JSONObject jsonObject)  {
        try {
            if (!jsonObject.isNull("type")) {
                this.type = jsonObject.getString("type");
            }
            if (!jsonObject.isNull("content")) {
                JSONArray content = jsonObject.getJSONArray("content");
                for (int i = 0; i < content.length(); i++) {
                    JSONObject jo = content.getJSONObject(i);
                    LocalDataBean1 localDataBean1 = new LocalDataBean1(jo);
                    localDataBeans.add(localDataBean1);
//                        this.name = content.getJSONObject(i).getString("name");
//                        this.summary = content.getJSONObject(i).getString("summary");
//                        this.cover = content.getJSONObject(i).getString("cover");
//                        this.cost = content.getJSONObject(i).getInt("cost");
                    }
                }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    @Override
    public String toString() {
        return "LocalDataBean{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", summary='" + summary + '\'' +
                ", cost=" + cost +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

//    public void getData(){
//        return LocalDataBean1.
//    }

}
