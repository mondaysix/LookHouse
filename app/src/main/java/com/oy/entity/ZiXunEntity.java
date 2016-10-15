package com.oy.entity;

import com.oy.adapter.TypeMoreAdapter;

/**
 * Created by Administrator on 2016/9/26 0026.
 */
public class ZiXunEntity implements TypeMoreAdapter.OnType {

    /**
     * id : HBJ2016052501825803
     * type : 1
     * title : 永定河孔雀城英国宫看图说房
     * summary : 永定河孔雀城英国宫看图说房·宜居花园
     * thumbnail : http://inews.gtimg.com/newsapp_ls/0/316314679_640330/0
     * groupthumbnail : http://inews.gtimg.com/newsapp_lsa/0/316314680_685160/0
     * commentcount : 22
     * imagecount : 26
     * commentid : 1410741801
     */

    private String id;
    private int type;
    private String title;
    private String summary;
    private String thumbnail;
    private String groupthumbnail;
    private int commentcount;
    private int imagecount;
    private String commentid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Override
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getGroupthumbnail() {
        return groupthumbnail;
    }

    public void setGroupthumbnail(String groupthumbnail) {
        this.groupthumbnail = groupthumbnail;
    }

    public int getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(int commentcount) {
        this.commentcount = commentcount;
    }

    public int getImagecount() {
        return imagecount;
    }

    public void setImagecount(int imagecount) {
        this.imagecount = imagecount;
    }

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }

    @Override
    public String toString() {
        return "ZiXunEntity{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", groupthumbnail='" + groupthumbnail + '\'' +
                ", commentcount=" + commentcount +
                ", imagecount=" + imagecount +
                ", commentid='" + commentid + '\'' +
                '}';
    }
}
