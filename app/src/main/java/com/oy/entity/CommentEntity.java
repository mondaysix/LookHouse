package com.oy.entity;

import com.oy.adapter.TypeMoreAdapter;

/**
 * Created by Administrator on 2016/9/29.
 */
public class CommentEntity implements TypeMoreAdapter.OnType {

    /**
     * id : 6186793595108399123
     * time : 昨天 15:08:58
     * timestamp : 1475046538
     * content : 我买房子呵呵
     * nick : M梦中~的小雨伞
     * head : http://wx.qlogo.cn/mmopen/PiajxSqBRaELtbRh8HFfywP5V7dYTI0Bb39AQZGZoDu13JBjL0wehWHSYES0IOqALxqQAo8vcZLoABdYRxE8adg/46
     * region : 腾讯网友
     * isreply : 1
     * replynick : 虚名小哥
     * replycontent : 想买华夏的房子可以私下联系我，
     */

    private String id;
    private String time;
    private int timestamp;
    private String content;
    private String nick;
    private String head;
    private String region;
    private int isreply;
    private String replynick;
    private String replycontent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getIsreply() {
        return isreply;
    }

    public void setIsreply(int isreply) {
        this.isreply = isreply;
    }

    public String getReplynick() {
        return replynick;
    }

    public void setReplynick(String replynick) {
        this.replynick = replynick;
    }

    public String getReplycontent() {
        return replycontent;
    }

    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent;
    }

    @Override
    public String toString() {
        return "CommentEntity{" +
                "id='" + id + '\'' +
                ", time='" + time + '\'' +
                ", timestamp=" + timestamp +
                ", content='" + content + '\'' +
                ", nick='" + nick + '\'' +
                ", head='" + head + '\'' +
                ", region='" + region + '\'' +
                ", isreply=" + isreply +
                ", replynick='" + replynick + '\'' +
                ", replycontent='" + replycontent + '\'' +
                '}';
    }

    @Override
    public int getType() {
        return 0;
    }
}
