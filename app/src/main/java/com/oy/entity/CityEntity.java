package com.oy.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/26 0026.
 */
public class CityEntity implements Serializable{

    /**
     * cityid : 44
     * cityalias : anshan
     * cityname : 鞍山
     */

    private int cityid;
    private String cityname;
    private int type = 1;

    public CityEntity(int cityid, String cityname, int type) {
        this.cityid = cityid;
        this.cityname = cityname;
        this.type = type;
    }

    public CityEntity(String cityname, int type) {
        this.cityname = cityname;
        this.type = type;
    }

    public CityEntity() {
        super();
    }

    public int getCityid() {
        return cityid;
    }
    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
