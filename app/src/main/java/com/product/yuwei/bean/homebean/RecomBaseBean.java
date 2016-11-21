package com.product.yuwei.bean.homebean;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dd on 2016/11/6.
 */

public class RecomBaseBean {
    private List<RecomHotBean> list_hot1;
    private List<RecomHotBean> list_hot2;
    private List<RecomHotBean> list_hot3;
    private List<RecomHotBean> list_hot4;
    private List<RecomHotBean> list_hot5;
    private List<RecomPageBean> list_page;
    private String hot1_title;
    private String hot2_title;
    private String hot3_title;
    private String hot4_title;
    private String hot5_title;
    private String note_title;
    private String note_subtitle;
    private List<RecomNoteBean> note_list;
    private List<String> baseHotTitle;

    private List<List<RecomHotBean>> baseHotBean;//用来存放list_hot 的list

    public List<String> getBaseHotTitle() {
        baseHotTitle=new ArrayList<>();
        baseHotTitle.add(hot1_title);
        baseHotTitle.add(hot2_title);
        baseHotTitle.add(hot3_title);
        baseHotTitle.add(hot4_title);
        baseHotTitle.add(hot5_title);
        return baseHotTitle;
    }

    public void setBaseHotTitle(List<String> baseHotTitle) {

        this.baseHotTitle = baseHotTitle;
    }


    public  RecomBaseBean(){}


    public List<List<RecomHotBean>> getBaseHotBean() {
        baseHotBean=new ArrayList<List<RecomHotBean>>();
        baseHotBean.add(list_hot1);
        baseHotBean.add(list_hot2);
        baseHotBean.add(list_hot3);
        baseHotBean.add(list_hot4);
        baseHotBean.add(list_hot5);
        return baseHotBean;
    }
    public void setBaseHotBean(List<List<RecomHotBean>> baseHotBean) {
        baseHotBean.add(list_hot1);
        baseHotBean.add(list_hot2);
        baseHotBean.add(list_hot3);
        baseHotBean.add(list_hot4);
        baseHotBean.add(list_hot5);
        this.baseHotBean = baseHotBean;
    }



    public List<RecomHotBean> getList_hot1() {
        return list_hot1;
    }

    public void setList_hot1(List<RecomHotBean> list_hot1) {
        this.list_hot1 = list_hot1;
    }

    public List<RecomHotBean> getList_hot2() {
        return list_hot2;
    }

    public void setList_hot2(List<RecomHotBean> list_hot2) {
        this.list_hot2 = list_hot2;
    }

    public List<RecomHotBean> getList_hot3() {
        return list_hot3;
    }

    public void setList_hot3(List<RecomHotBean> list_hot3) {
        this.list_hot3 = list_hot3;
    }

    public List<RecomHotBean> getList_hot4() {
        return list_hot4;
    }

    public void setList_hot4(List<RecomHotBean> list_hot4) {
        this.list_hot4 = list_hot4;
    }

    public List<RecomHotBean> getList_hot5() {
        return list_hot5;
    }

    public void setList_hot5(List<RecomHotBean> list_hot5) {
        this.list_hot5 = list_hot5;
    }

    public List<RecomPageBean> getList_page() {
        return list_page;
    }

    public void setList_page(List<RecomPageBean> list_page) {
        this.list_page = list_page;
    }

    public String getHot1_title() {
        return hot1_title;
    }

    public void setHot1_title(String hot1_title) {
        this.hot1_title = hot1_title;
    }

    public String getHot2_title() {
        return hot2_title;
    }

    public void setHot2_title(String hot2_title) {
        this.hot2_title = hot2_title;
    }

    public String getHot3_title() {
        return hot3_title;
    }

    public void setHot3_title(String hot3_title) {
        this.hot3_title = hot3_title;
    }

    public String getHot4_title() {
        return hot4_title;
    }

    public void setHot4_title(String hot4_title) {
        this.hot4_title = hot4_title;
    }

    public String getHot5_title() {
        return hot5_title;
    }

    public void setHot5_title(String hot5_title) {
        this.hot5_title = hot5_title;
    }

    public String getNote_title() {
        return note_title;
    }

    public void setNote_title(String note_title) {
        this.note_title = note_title;
    }

    public String getNote_subtitle() {
        return note_subtitle;
    }

    public void setNote_subtitle(String note_subtitle) {
        this.note_subtitle = note_subtitle;
    }

    public List<RecomNoteBean> getNote_list() {
        return note_list;
    }

    public void setNote_list(List<RecomNoteBean> note_list) {
        this.note_list = note_list;
    }





}
