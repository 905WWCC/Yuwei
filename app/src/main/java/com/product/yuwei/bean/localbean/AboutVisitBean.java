package com.product.yuwei.bean.localbean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/11/14 0014.
 */
public class AboutVisitBean {
    String name;
    String cover;
    String time;
    String uname;

    public AboutVisitBean(JSONObject jsonObject) {
        try {

            if (!jsonObject.isNull("name")) {
                this.name = jsonObject.getString("name");
            }
            if (!jsonObject.isNull("cover")) {
                this.cover = jsonObject.getString("cover");
            }
            if (!jsonObject.isNull("time")) {
                this.time = jsonObject.getString("time");
            }
            if (!jsonObject.isNull("author")) {
//                JSONArray author = jsonObject.getJSONArray("author");
                JSONObject author = jsonObject.getJSONObject("author");

                this.uname = author.getString("uname");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "AboutVisitBean{" +
                "name='" + name + '\'' +
                ", cover='" + cover + '\'' +
                ", time='" + time + '\'' +
                ", uname='" + uname + '\'' +
                '}';
    }
}
