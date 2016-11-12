package com.product.yuwei.bean;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/10/29 0029.
 */
public class HotBase {

    public HotBase() {}

    private String name;
    private String cover;
    private int vote;
    private int fav;
    private int readnum;
    private int plnum;
    private int imgnum;
    private String text;
    private String author_uname;
    private String author_header;
    private String level;

    public HotBase(String name, String cover, int vote, int fav, int readnum, int plnum, int imgnum, String text, String author_uname, String author_header, String level) {
        this.name = name;
        this.cover = cover;
        this.vote = vote;
        this.fav = fav;
        this.readnum = readnum;
        this.plnum = plnum;
        this.imgnum = imgnum;
        this.text = text;
        this.author_uname = author_uname;
        this.author_header = author_header;
        this.level = level;
    }


    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public int getFav() {
        return fav;
    }

    public void setFav(int fav) {
        this.fav = fav;
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

    public int getReadnum() {
        return readnum;
    }

    public void setReadnum(int readnum) {
        this.readnum = readnum;
    }

    public int getPlnum() {
        return plnum;
    }

    public void setPlnum(int plnum) {
        this.plnum = plnum;
    }

    public int getImgnum() {
        return imgnum;
    }

    public void setImgnum(int imgnum) {
        this.imgnum = imgnum;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor_uname() {
        return author_uname;
    }

    public void setAuthor_uname(String author_uname) {
        this.author_uname = author_uname;
    }

    public String getAuthor_header() {
        return author_header;
    }

    public void setAuthor_header(String author_header) {
        this.author_header = author_header;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    private String att_uname;
    private String att_header;
    private String att_desc;
    private String att_vname;
    private String att_label_name1;
    private String att_label_name2;
    private String att_label_name3;

    public HotBase(JSONObject jsonObject){
        try {
            if (!jsonObject.isNull("uname")) {
                this.att_uname = jsonObject.getString("uname");
            }
            if (!jsonObject.isNull("header")) {
                this.att_header = jsonObject.getString("header");
            }
            if (!jsonObject.isNull("desc")) {
                this.att_desc = jsonObject.getString("desc");
            }
            if (!jsonObject.isNull("label")) {
                JSONArray label = jsonObject.getJSONArray("label");
                Log.e("label",label+"");
//                if (!jsonObject.isNull("name")){
//
//                }
                this.att_label_name1 = label.getJSONObject(0).getString("name");
                this.att_label_name2 = label.getJSONObject(1).getString("name");
                this.att_label_name3 = label.getJSONObject(2).getString("name");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getAtt_desc() {
        return att_desc;
    }

    public void setAtt_desc(String att_desc) {
        this.att_desc = att_desc;
    }

    public String getAtt_uname() {
        return att_uname;
    }

    public void setAtt_uname(String att_uname) {
        this.att_uname = att_uname;
    }

    public String getAtt_header() {
        return att_header;
    }

    public void setAtt_header(String att_header) {
        this.att_header = att_header;
    }

    public String getAtt_vname() {
        return att_vname;
    }

    public void setAtt_vname(String att_vname) {
        this.att_vname = att_vname;
    }

    public String getAtt_label_name1() {
        return att_label_name1;
    }

    public void setAtt_label_name1(String att_label_name1) {
        this.att_label_name1 = att_label_name1;
    }

    public String getAtt_label_name2() {
        return att_label_name2;
    }

    public void setAtt_label_name2(String att_label_name2) {
        this.att_label_name2 = att_label_name2;
    }

    public String getAtt_label_name3() {
        return att_label_name3;
    }

    public void setAtt_label_name3(String att_label_name3) {
        this.att_label_name3 = att_label_name3;
    }
}
