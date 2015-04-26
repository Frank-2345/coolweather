package com.coolweather.app.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

//CoolWeather类，把常用的数据库操作封装起来，以便操作。

public class CoolWeatherDB {
	
	public static String DB_NAME = "cool_weather";
	public static int VERSION = 1;
	private static CoolWeatherDB coolWeatherDB;
	private SQLiteDatabase db ;
	
	private CoolWeatherDB(Context context){
		//OpenHelper里面其实就有个SQLiteDB了
		
		CoolWeatherOpenHelper coolWeatherOpenHelper = new CoolWeatherOpenHelper(context, DB_NAME, null, VERSION);
		db = coolWeatherOpenHelper.getWritableDatabase();
	}
	
	public synchronized static CoolWeatherDB getInstance(Context context){
		if(coolWeatherDB == null){
			coolWeatherDB = new CoolWeatherDB(context);
		}
		return coolWeatherDB;
	}
	/*
	 * 将Province实例输入数据库
	 * */
	public void saveProvince(Province province){
		ContentValues values = new ContentValues();
		values.put("province_name", province.getProvince_name());
		values.put("province_code", province.getProvince_code());
//		values.put("province_id", province.getProvince_id());
		db.insert("Province", null, values);
	}
	
	/*
	 * 从数据库中读出所有的省份信息
	 * */
	public List<Province> loadProvinces(){
		List Provinces = new ArrayList<Province>();
		Cursor cursor = db.query("Province", null, null, null, null, null, null);
		if(cursor.moveToFirst()){
			do{
				Province province = new Province();
				province.setId(cursor.getInt(cursor.getColumnIndex("id")));
				province.setProvince_name(cursor.getString(cursor.getColumnIndex("province_name")));
				province.setProvince_code(cursor.getInt(cursor.getColumnIndex("province_code")));
//				province.setProvince_id(cursor.getInt(cursor.getColumnIndex("province_id")));
				Provinces.add(province);
			}while(cursor.moveToNext());
		}
		return Provinces;
	}
	
	/*
	 * 将City实例输入数据库
	 * */
	public void saveCity(City city){
		ContentValues values = new ContentValues();
		values.put("city_name", city.getCity_name());
		values.put("city_code", city.getCity_code());
		values.put("province_id", city.getProvince_id());
		db.insert("City", null, values);
	}
	
	/*
	 * 从数据库中读出指定Province的City信息
	 * */
	public List<City> loadCities(int province_id){
		List<City> cities = new ArrayList<City>();
		Cursor cursor = db.query("City", null, "province_id = ?", new String[]{String.valueOf(province_id)}, null, null, null);
		if(cursor.moveToFirst()){
			do{
				City city = new City();
				city.setId(cursor.getInt(cursor.getColumnIndex("id")));
				city.setCity_name(cursor.getString(cursor.getColumnIndex("city_name")));
				city.setCity_code(cursor.getInt(cursor.getColumnIndex("city_code")));
				city.setProvince_id(cursor.getInt(cursor.getColumnIndex("province_id")));
				cities.add(city);
			}while(cursor.moveToNext());
		}
		return cities;
	}
	
	public void saveCounty(County county){
		ContentValues values = new ContentValues();
		values.put("id", county.getId());
		values.put("county_name", county.getCounty_name());
		values.put("county_code", county.getCounty_code());
		values.put("city_id", county.getCity_id());
		db.insert("County", null, values);
	}
	
	public List<County> loadCounties(int city_id){
		List<County> counties = new ArrayList<County>();
		//Cursor的本质有点像是部分Table
		Cursor cursor = db.query("County", null, "city_id = ?"	, new String[]{String.valueOf(city_id)}, null, null, null);
		if(cursor.moveToFirst()){
			do{
				County county = new County();	//在这里定义好
				county.setCity_id(cursor.getInt(cursor.getColumnIndex("city_id")));
				county.setCounty_name(cursor.getString(cursor.getColumnIndex("county_name")));
				county.setCounty_code(cursor.getInt(cursor.getColumnIndex("county_code")));
				counties.add(county);	//加入List
			}while(cursor.moveToNext());
		}
		
		return counties;
	}
}
