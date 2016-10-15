package com.oy.util;

/**
 * Created by Administrator on 2016/9/25 0025.
 */
public interface Constants {

    /**
     * 选择城市
     */
    public static final String CHOICE_CITY = "http://ikft.house.qq.com/index.php?guid=866500021200250&devua=appkft_1080_1920_XiaomiMI4LTE_1.8.3_Android19&act=kftcitylistnew&channel=71&devid=866500021200250&appname=QQHouse&mod=appkft";
    /**
     * 首页WebView内容
     */
    public static final String FIRST_PAGE_WEBVIEW = "http://ikft.house.qq.com/index.php?guid=866500021200250&devua=appkft_1080_1920_XiaomiMI4LTE_1.8.3_Android19&devid=866500021200250&appname=QQHouse&mod=appkft&act=homepage&channel=71&cityid=%d";

    /**
     * 首页 ListView内容
     *
     * 1)进入时：reqnum=10,pageflag=0,buttonmore=0;
     * 2)点击查看更多时：reqnum=20,pageflag=0,buttonmore=1;
     * 3)刷新时：reqnum=20,pageflag=1,buttonmore=1;
     */
    public static final String FIRST_PAGE_LISTVIEW = "http://ikft.house.qq.com/index.php?guid=866500021200250&devua=appkft_1080_1920_XiaomiMI4LTE_1.8.3_Android19&devid=866500021200250&appname=QQHouse&mod=appkft&reqnum=%d&pageflag=0&act=newslist&channel=71&buttonmore=0&cityid=%d";
    /**
     * 资讯详情
     */
    public static final String NEWS_DETAIL = "http://ikft.house.qq.com/index.php?guid=866500021200250&devua=appkft_1080_1920_XiaomiMI4LTE_1.8.3_Android19&devid=866500021200250&appname=QQHouse&mod=appkft&act=newsdetail&channel=71&newsid=%s";
    /**
     * 资讯评论
     */
    public static final String NEWS_COMMENT = "http://ikft.house.qq.com/index.php?guid=866500021200250&devua=appkft_1080_1920_XiaomiMI4LTE_1.8.3_Android19&devid=866500021200250&appname=QQHouse&mod=appkft&reqnum=20&pageflag=0&act=newscomment&channel=71&targetid=%s";
    /**
     * 找新房
     */
    public static final String LOOKING_NEWHOUSE = "http://ikft.house.qq.com/index.php?guid=866500021200250&devua=appkft_1080_1920_XiaomiMI4LTE_1.8.3_Android19&rn=10&order=0&searchtype=normal&devid=866500021200250&page=%d&appname=QQHouse&mod=appkft&act=searchhouse&channel=71&cityid=%d";
    /**
     * 找新房 楼盘信息
     */
    public static final String NEW_HOUSE_INFO = "http://ikft.house.qq.com/index.php?guid=866500021200250&devua=appkft_1080_1920_XiaomiMI4LTE_1.8.3_Android19&hid=%s&devid=866500021200250&appname=QQHouse&mod=appkft&act=houseinfo&channel=71";
}
