package com.product.yuwei.bean;

/**
 * Created by Administrator on 2016/10/29 0029.
 */
public class HotBase {

    public HotBase() {
    }

    private String name;
    private String cover;
    private int readnum;
    private int plnum;
    private int imgnum;
    private String text;
    private String author_uname;
    private String author_header;
    private String level;

    public HotBase(String name, String cover, int readnum, int plnum, int imgnum, String text, String author_uname, String author_header, String level) {
        this.name = name;
        this.cover = cover;
        this.readnum = readnum;
        this.plnum = plnum;
        this.imgnum = imgnum;
        this.text = text;
        this.author_uname = author_uname;
        this.author_header = author_header;
        this.level = level;
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
}
