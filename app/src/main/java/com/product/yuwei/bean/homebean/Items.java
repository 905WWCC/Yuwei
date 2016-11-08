package com.product.yuwei.bean.homebean;

import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by dd on 2016/11/1.
 */

public class Items {
    private ArrayList<String> itemImageUrls;
    private ArrayList<String> itemTitleUrls;
    private ArrayList<String> itemTimeUrls;

    public ArrayList<String> getItemImageUrls() {
        return itemImageUrls;
    }

    public void setItemImageUrls(ArrayList<String> itemImageUrls) {
        this.itemImageUrls = itemImageUrls;
    }

    public ArrayList<String> getItemTitleUrls() {
        return itemTitleUrls;
    }

    public void setItemTitleUrls(ArrayList<String> itemTitleUrls) {
        this.itemTitleUrls = itemTitleUrls;
    }

    public ArrayList<String> getItemTimeUrls() {
        return itemTimeUrls;
    }

    public void setItemTimeUrls(ArrayList<String> itemTimeUrls) {
        this.itemTimeUrls = itemTimeUrls;
    }
}
