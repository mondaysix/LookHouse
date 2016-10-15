package com.oy.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.oy.entity.CityEntity;
import com.oy.entity.CommentEntity;
import com.oy.entity.HeaderEntity;
import com.oy.entity.HouseEntity;
import com.oy.entity.NewsXiangQEntity;
import com.oy.entity.XinFangEntity;
import com.oy.entity.ZiXunEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/26 0026.
 */
public class JSONUtil {
    private static String[] label = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    public static  List<CityEntity> getJSON(String json){
        List<CityEntity> cities = new ArrayList<>();
        try {

            JSONObject jsonObject =  new JSONObject(json).getJSONObject("cities");
            for (int i = 0; i < label.length; i++) {

                JSONArray jsonArray = jsonObject.optJSONArray(label[i]);
                if (jsonArray!=null){
                    CityEntity cityLabel = new CityEntity(label[i],0);
                    cities.add(cityLabel);
                    TypeToken<List<CityEntity>> tt = new TypeToken<List<CityEntity>>(){};
                    List<CityEntity> cityList = new Gson().fromJson(jsonArray.toString(),tt.getType());
                    cities.addAll(cityList);
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return cities ;
    }
    public static  String str;
    /**
     * 解析资讯新闻
     * @param json
     * @return
     */
    public static List<ZiXunEntity> getJSONZiXun(String json){
        try {
            JSONArray ja = new JSONObject(json).getJSONArray("data");
            TypeToken<List<ZiXunEntity>> tt = new TypeToken<List<ZiXunEntity>>(){};
            return new Gson().fromJson(ja.toString(),tt.getType());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 解析头部viewPager数据
     */
    public static List<HeaderEntity> getJSONHeader(String json){
        try {
           JSONArray jsonArray =  new JSONObject(json).getJSONArray("data");
            TypeToken<List<HeaderEntity>> tt = new TypeToken<List<HeaderEntity>>(){};
            return new Gson().fromJson(jsonArray.toString(),tt.getType());

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static NewsXiangQEntity getJSONXiangQ(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            NewsXiangQEntity newsXiangQ = new NewsXiangQEntity();
            
            newsXiangQ.setId(jsonObject.getString("id"));
            newsXiangQ.setTitle(jsonObject.getString("title"));
            newsXiangQ.setSource(jsonObject.getString("source"));
            newsXiangQ.setTime(jsonObject.getString("time"));
            JSONArray content = jsonObject.getJSONArray("content");
            TypeToken<List<NewsXiangQEntity.ContentBean>> tt = new TypeToken<List<NewsXiangQEntity.ContentBean>>(){};
             newsXiangQ.setContent((List<NewsXiangQEntity.ContentBean>) new Gson().fromJson(content.toString(),tt.getType()));
            return newsXiangQ;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static List<XinFangEntity> getJSONXinFang(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
             str = jsonObject.getString("total");

            JSONArray jsonArray = jsonObject.getJSONArray("data");
            TypeToken<List<XinFangEntity>> tt = new TypeToken<List<XinFangEntity>>(){};
            return new Gson().fromJson(jsonArray.toString(),tt.getType());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String getTotal(){
        return str;
    }
    public static List<CommentEntity> getJSONComment(String json){
        /**
         * "id": "6187077041525432781",
         "time": "31分钟前",
         "timestamp": 1475114117,
         "content": "主要是股市太不靠谱造成的，钱从股票流出到了房地产",
         "nick": "落伍！",
         "head": "http://q1.qlogo.cn/g?b=qq&k=lKLy8MdkN1Ps6ial4PRTw1w&s=40&t=1475078400",
         "region": "盘锦",
         "isreply": 0,
         "replynick": "",
         "replycontent": ""
         */
        TypeToken<List<CommentEntity>> tt = new TypeToken<List<CommentEntity>>(){};
        try {
            JSONArray jsonArray = new JSONObject(json).getJSONObject("data").getJSONArray("comments");
            return new Gson().fromJson(jsonArray.toString(),tt.getType());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
    /**
     * 新房楼盘信息
     */
    public static HouseEntity getJSONHouse(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            HouseEntity houseEntity = new HouseEntity();
            houseEntity.setName(jsonObject.getString("name"));
            houseEntity.setPrice(jsonObject.getString("price"));
            houseEntity.setDiscount(jsonObject.getString("discount"));
            houseEntity.setTitle(jsonObject.getString("title"));
            houseEntity.setSummary(jsonObject.getString("summary"));
            houseEntity.setUrl(jsonObject.getString("url"));
            JSONArray jsonArray = jsonObject.getJSONArray("pic");
            TypeToken<List<HouseEntity.PicBean>> tt = new TypeToken<List<HouseEntity.PicBean>>(){};
            houseEntity.setPic((List<HouseEntity.PicBean>) new Gson().fromJson(jsonArray.toString(), tt.getType()));
           JSONObject jsonObject1 =  jsonObject.getJSONObject("unitlist");
            HouseEntity.UnitlistBean unitlistBean = new HouseEntity.UnitlistBean();
            unitlistBean.setNum(jsonObject1.getInt("num"));
            JSONArray data = jsonObject1.getJSONArray("data");
            TypeToken<List<HouseEntity.UnitlistBean.DataBean>> typeToken = new TypeToken<List<HouseEntity.UnitlistBean.DataBean>>(){};
            unitlistBean.setData((List<HouseEntity.UnitlistBean.DataBean>) new Gson().fromJson(data.toString(), typeToken.getType()));
            houseEntity.setUnitlist(unitlistBean);
            houseEntity.setCommentnum(jsonObject.getString("commentnum"));
            houseEntity.setPrice_pre(jsonObject.getString("price_pre"));
            houseEntity.setPrice_unit(jsonObject.getString("price_unit"));
            return houseEntity;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
