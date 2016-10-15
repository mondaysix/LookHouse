package com.oy.kanfang;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.oy.activity.BaseActivity;
import com.oy.adapter.CityAdapter;
import com.oy.database.MySqliteOpenHelper;
import com.oy.entity.CityEntity;
import com.oy.util.AbsAsyncTask;
import com.oy.util.Constants;
import com.oy.util.JSONUtil;
import com.oy.widget.CombineView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnItemClick;
import de.halfbit.pinnedsection.PinnedSectionListView;

/**
 * Created by Administrator on 2016/9/26 0026.
 */
public class ChoiceCityActivity extends BaseActivity implements AbsAsyncTask.OnDownListener, CombineView.TextOnSelectedListener{
    private CityAdapter cityAdapter;
    @BindView(R.id.lv_city)
    public PinnedSectionListView lv_city;
    @BindView(R.id.combineView)
    public CombineView combineView;
    //数据库操作
    public SQLiteDatabase sqLiteDatabase;
    public MySqliteOpenHelper sqliteOpenHelper;
    List<CityEntity> cityEntities = new ArrayList<>();
    List<CityEntity> cityFromDatabase = new ArrayList<>();
    @Override
    protected int setContentId() {
        return R.layout.layout_choosecity;
    }

    @Override
    protected void init() {
        //初始化读取数据库
        sqliteOpenHelper = new MySqliteOpenHelper(this,"City.db","city");
        sqLiteDatabase = sqliteOpenHelper.getReadableDatabase();
        cityAdapter = new CityAdapter(this);
        lv_city.setAdapter(cityAdapter);
    }

    @Override
    protected void loadData() {
        //下载城市之前查询数据库中是否存在这些城市
        cityFromDatabase = getCityFromDatabase();
        if (cityFromDatabase.size()==0){
            new AbsAsyncTask(AbsAsyncTask.DownType.JSON).setOnDownListener(this).execute(Constants.CHOICE_CITY);
        }
        else {
            cityAdapter.setCities(cityFromDatabase);
        }
    }
    public List<CityEntity> getCityFromDatabase(){

             Cursor cursor = sqLiteDatabase.query("city",new String[]{"_id" ,"cityId","cityName","type"},null, null, null, null, null);
                while(cursor.moveToNext()){
                int cityid = cursor.getInt(cursor.getColumnIndex("cityId"));
                String cityName = cursor.getString(cursor.getColumnIndex("cityName"));
                int type = cursor.getInt(cursor.getColumnIndex("type"));
                CityEntity cityEntity = new CityEntity(cityid,cityName,type);
                cityEntities.add(cityEntity);
            }
            cursor.close();
        return  cityEntities;
    }

    @Override
    protected void onItemListener() {
        //侧边栏的点击事件
        combineView.setTextChangeListener(this);
    }

    /**
     * listview item点击事件
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @OnItemClick(R.id.lv_city)
    public void ItemClick(AdapterView<?> parent, View view, int position, long id){
        CityEntity cityEntity = (CityEntity) cityAdapter.getItem(position);
        Intent intent = new Intent();
        intent.putExtra("cityEntity",cityEntity);
        setResult(0x456,intent);
        finish();
    }
    @Override
    public Object downJSON(String json) {
        if (json!=null){
            return JSONUtil.getJSON(json);
        }
        return null;
    }

    @Override
    public void paresJSON(Object datas) {
        if (datas!=null){
            List<CityEntity> citiesList = (List<CityEntity>) datas;
            for (CityEntity city : citiesList){
                int type = city.getType();
                int cityid = city.getCityid();
                String cityName = city.getCityname();
                //把城市列表存入数据库
                if (queryData(cityid)){
                    //如果存在数据库中就不添加

                }
                else {
                    ContentValues values = new ContentValues();
                    values.put("cityId",cityid);
                    values.put("cityName",cityName);
                    values.put("type",type);
                    Log.d("msg","cityId"+cityid);
                    Log.d("msg","cityName"+cityid);
                    Log.d("msg","type"+cityid);
                    sqLiteDatabase.insert("city",null,values);
                }
            }
            cityAdapter.setCities(citiesList);
        }
    }
    private Boolean queryData(int cityid) {
        Cursor cursor = sqLiteDatabase.query("city", new String[]{"_id" ,"cityId","cityName","type"}, "cityId=?", new String[]{String.valueOf(cityid)}, null, null, null);
        while(cursor.moveToNext()){
            int cityDb = cursor.getInt(cursor.getColumnIndex("cityId"));
            if (cityid == cityDb ){
                return true;
            }
        }
        return false;
    }

    @Override
    public void getSelectText(String str) {
        int id = cityAdapter.queryId(str);
        lv_city.setSelection(id);
    }
}
