package com.product.yuwei.bean.localbean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/11/14 0014.
 */
public class LocalDataBean1 implements data{
    String name;
    String summary;
    String cover;
    String type;
    int cost;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
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

    //构造自己内部方法
    public LocalDataBean1(JSONObject jsonObject){
        try {
            if (!jsonObject.isNull("name")) {
                this.name = jsonObject.getString("name");
            }
            if (!jsonObject.isNull("summary")) {
                this.summary = jsonObject.getString("summary");
            }
            if (!jsonObject.isNull("cover")) {
                this.cover = jsonObject.getString("cover");
            }
            if (!jsonObject.isNull("type")) {
                this.type = jsonObject.getString("type");
            }
            if (!jsonObject.isNull("cost")) {
                this.cost = jsonObject.getInt("cost");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void callbackdata(String name,String summary,String cover,int cost) {
        this.name = name;
        this.summary = summary;
        this.cover = cover;
        this.cost = cost;
    }
}
