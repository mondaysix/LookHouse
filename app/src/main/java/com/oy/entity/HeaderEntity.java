package com.oy.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/26 0026.
 */
public class HeaderEntity implements Serializable {

    /**
     * type : 3
     * picurl : http://p.qpic.cn/estate/0/ce89633d768f84439d6d68dcbb45d8ff.jpg/0
     * title : 东五环四居现房
     * houseid : 9484
     */

    private String type;
    private String picurl;
    private String title;
    private String houseid;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid;
    }

    @Override
    public String toString() {
        return "HeaderEntity{" +
                "type='" + type + '\'' +
                ", picurl='" + picurl + '\'' +
                ", title='" + title + '\'' +
                ", houseid='" + houseid + '\'' +
                '}';
    }
}
