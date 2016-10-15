package com.oy.entity;

import com.oy.adapter.TypeMoreAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public class XinFangEntity implements TypeMoreAdapter.OnType {

    /**
     * fid : 9535
     * fcover : http://p0.qpic.cn/estate/0/96d774235c065ea84e0ba058b3b72464.jpg/180
     * fname : 永定河孔雀城英国宫
     * faddress : 固安大广高速（固安出口）西侧
     * fregion : 大北京
     * lng : 116.326704
     * lat : 39.470533
     * fsellstatus : 2
     * istencentdiscount : 0
     * faroundhighprice : 0
     * faroundlowprice : 0
     * groupbuynum : 0
     * bookmark : [{"tag":"看房团","type":1},{"tag":"3.5万抵7万","type":2},{"tag":"豪华社区","type":3}]
     * price_pre : 均价
     * price_value : 20000
     * price_unit : 元/平
     * fpricedisplaystr : 20000元/平
     * panoid :
     * heading :
     * pitch :
     * has_agent : 1
     * hui : 1
     */

    private String fid;
    private String fcover;
    private String fname;
    private String faddress;
    private String fregion;
    private String fpricedisplaystr;
    private int hui;
    private int has_agent;
    /**
     * tag : 看房团
     * type : 1
     */

    private List<BookmarkBean> bookmark;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFcover() {
        return fcover;
    }

    public void setFcover(String fcover) {
        this.fcover = fcover;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFaddress() {
        return faddress;
    }

    public void setFaddress(String faddress) {
        this.faddress = faddress;
    }

    public String getFregion() {
        return fregion;
    }

    public void setFregion(String fregion) {
        this.fregion = fregion;
    }

    public String getFpricedisplaystr() {
        return fpricedisplaystr;
    }

    public void setFpricedisplaystr(String fpricedisplaystr) {
        this.fpricedisplaystr = fpricedisplaystr;
    }

    public int getHui() {
        return hui;
    }

    public void setHui(int hui) {
        this.hui = hui;
    }

    public int getHas_agent() {
        return has_agent;
    }

    public void setHas_agent(int has_agent) {
        this.has_agent = has_agent;
    }

    public List<BookmarkBean> getBookmark() {
        return bookmark;
    }

    public void setBookmark(List<BookmarkBean> bookmark) {
        this.bookmark = bookmark;
    }

    @Override
    public String toString() {
        return "XinFangEntity{" +
                "fid='" + fid + '\'' +
                ", fcover='" + fcover + '\'' +
                ", fname='" + fname + '\'' +
                ", faddress='" + faddress + '\'' +
                ", fregion='" + fregion + '\'' +
                ", fpricedisplaystr='" + fpricedisplaystr + '\'' +
                ", hui=" + hui +
                ", bookmark=" + bookmark +
                '}';
    }

    @Override
    public int getType() {
        return 0;
    }

    public static class BookmarkBean {
        private String tag;
        private int type;

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}


