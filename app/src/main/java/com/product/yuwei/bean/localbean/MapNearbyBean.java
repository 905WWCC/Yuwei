package com.product.yuwei.bean.localbean;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
public class MapNearbyBean {


    String id;
    String address;
    String open_time;
    String reason;
    String desc;
    String phone;
    String name;
    String cover;
    String type;
    String km;
    int cost;
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpen_time() {
        return open_time;
    }

    public void setOpen_time(String open_time) {
        this.open_time = open_time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public MapNearbyBean(JSONObject jsonObject) {
        try {
            if (!jsonObject.isNull("id")) {
                this.id = jsonObject.getString("id");
            }
            if (!jsonObject.isNull("name")) {
                this.name = jsonObject.getString("name");
            }
            if (!jsonObject.isNull("type")) {
                this.type = jsonObject.getString("type");
            }
            if (!jsonObject.isNull("cover")) {
                this.cover = jsonObject.getString("cover");
            }
            if (!jsonObject.isNull("cost")) {
                this.cost = jsonObject.getInt("cost");
            }
            if (!jsonObject.isNull("km")) {
                this.km = jsonObject.getString("km");
            }
            if (!jsonObject.isNull("address")) {
                this.address = jsonObject.getString("address");
            }
            if (!jsonObject.isNull("open_time")) {
                this.open_time = jsonObject.getString("open_time");
            }
            if (!jsonObject.isNull("reason")) {
                this.reason = jsonObject.getString("reason");
            }
            if (!jsonObject.isNull("desc")) {
                this.desc = jsonObject.getString("desc");
            }
            if (!jsonObject.isNull("phone")) {
                this.phone = jsonObject.getString("phone");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
