package com.product.yuwei.bean.homebean;

import java.util.Date;
import java.util.UUID;

/**模型 一般称为bean 或者model(好像是这样拼写的)
 * Created by dd on 2016/10/31.
 */

public class Crime {
    //看一下页面是不是包括了 标题 时间  还有勾选框
    private String Title;
    private java.util.Date Date;
    private boolean Solved;
    //以上三个变量代表了页面中的三个组件的值
    //为了区分每一组数据，我们有必要为每一组数据加上id
    private UUID ID;

    //以上我们建立好了变量 下面是构造方法，可以理解为启用这个类的入口
    public Crime(){
        ID= UUID.randomUUID();//通过随机产生id，赋予唯一id
        Date=new Date();//通过系统获得日期
    }
    ////////////////////////// toString() getter() setter() 方法都有快捷键 自己调用三种方法就完成了模型的构建


    @Override
    public String toString() {
        return "Crime{" +
                "mTitle='" + Title + '\'' +
                ", mDate=" + Date +
                ", mSolved=" + Solved +
                ", mID=" + ID +
                '}';
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public boolean isSolved() {
        return Solved;
    }

    public void setSolved(boolean solved) {
        Solved = solved;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }
}
