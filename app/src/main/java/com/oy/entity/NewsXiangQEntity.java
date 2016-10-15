package com.oy.entity;

import com.oy.adapter.TypeMoreAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public class NewsXiangQEntity{

    /**
     * retcode : 0
     * retmsg : 成功
     * id : HSZ2016092800792803
     * title : 深圳“小扭腰”明年底启用 建筑高达248.9米
     * source : 深圳新闻网
     * time : 2016-09-28 07:54:00
     * url : http://xw.qq.com/house/20160928007928/HSZ2016092800792803
     * surl : http://m.house.qq.com/a/HSZ2016092800792803/
     * content : [{"type":2,"value":"http://inews.gtimg.com/newsapp_bt/0/623861588/640"},{"type":1,"value":"▲深圳地铁科技大厦采用了\u201c小扭腰\u201d的别致造型。"},{"type":1,"value":"深圳晚报讯（记者 刘万专）虽然待字闺中，已然芳名远扬，说的就是南山区科技园拔地而起的深圳地铁科技大厦项目（俗称\u201c小扭腰\u201d）。昨日，2016年深圳市\u201c质量月\u201d观摩交流会在此举行。\n　　本次观摩交流会由深圳市住房和建设局主办，深圳地铁集团有限公司、中建八局广州公司承办。来自市、区住建部门及质量监督机构、建筑业协会和建设、施工、监理单位等到场，人数达800人。观摩现场，设置了质量样板引路展示区、BIM+互联网技术展示区和创\u201c国优\u201d工艺动画可视化体验区，项目开发了26层机电、幕墙、精装实体过程质量观摩层，工作人员进行了详细讲解。\n　　据了解，该项目自开工以来，先后接受了来自深圳市工务署、东莞市建筑业协会、深圳地铁集团、万科集团、碧桂园、深圳大学研究生院等单位观摩交流，取得了较好的社会效应。\n　　深圳地铁科技大厦项目位于南山区科技园，其建筑面积达12.9万平方米，高248.9米，是深圳地铁首个自主开发的超高层地铁上盖物业，集甲级写字楼、五星级酒店、商业、片区交通枢纽为一体，为南山区科技园地标性建筑物之一。\n　　项目主体结构采用\u201c钢筋混凝土框架-核心筒+伸臂桁架\u201d体系建筑，外形犹如\u201c小扭腰\u201d。深圳地铁1号线横穿其裙楼地下结构，施工工艺要求高。工程于2014年12月8日开工，已于2016年3月30日完成主体封顶，预计2017年底竣工营业。"}]
     */

    private String id;
    private String title;
    private String source;
    private String time;
    /**
     * type : 2
     * value : http://inews.gtimg.com/newsapp_bt/0/623861588/640
     */

    private List<ContentBean> content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "NewsXiangQEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", source='" + source + '\'' +
                ", time='" + time + '\'' +
                ", content=" + content +
                '}';
    }
    public static class ContentBean  implements TypeMoreAdapter.OnType {
        public int type;
        public String value;
        @Override
        public int getType() {
            return type-1;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "ContentBean{" +
                    "type=" + type +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
}
