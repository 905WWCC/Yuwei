package com.product.yuwei.bean.homebean;

/**用来存放主页顶部滑动图片的地址的模型层
 * Created by dd on 2016/10/26.
 */

public class Homepage_Slide {
    private String homepage_url1;
    private String homepage_url2;
    private String homepage_url3;
    private String homepage_url4;
    private String[] imgUrlList;
    public Homepage_Slide(){

    }

    public String[] getImgUrlList() {
        return imgUrlList;
    }

    public void setImgUrlList(String[] imgUrlList) {
        this.imgUrlList = imgUrlList;
    }

    public String getHomepage_url1() {
        return homepage_url1;
    }

    public String getHomepage_url2() {
        return homepage_url2;
    }

    public String getHomepage_url3() {
        return homepage_url3;
    }

    public String getHomepage_url4() {
        return homepage_url4;
    }

    public void setHomepage_url1(String homepage_url1) {
        this.homepage_url1 = homepage_url1;
    }

    public void setHomepage_url2(String homepage_url2) {
        this.homepage_url2 = homepage_url2;
    }

    public void setHomepage_url3(String homepage_url3) {
        this.homepage_url3 = homepage_url3;
    }

    public void setHomepage_url4(String homepage_url4) {
        this.homepage_url4 = homepage_url4;
    }
}
