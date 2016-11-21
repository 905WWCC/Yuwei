package com.product.yuwei.bean.localbean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/11/15 0015.
 */
public class MustEatBean {
    String name;
    String sum;
    String cover;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public MustEatBean(JSONObject jsonObject){

            try {
                if (!jsonObject.isNull("name")) {
                    this.name = jsonObject.getString("name");
                }
                if (!jsonObject.isNull("sum")) {
                    this.sum = jsonObject.getString("sum");
                }
                if (!jsonObject.isNull("cover")) {
                    this.cover = jsonObject.getString("cover");
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

    }
}
