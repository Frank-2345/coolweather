package com.coolweather.app.db;

public class City {
	
	private int id ;
	private String city_name;
	private int city_code;
	private int province_id;
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setCity_name(String city_name){
		this.city_name = city_name;
	}
	
	public String getCity_name(){
		return this.city_name;
	}
	
	public void setCity_code(int city_code){
		this.city_code = city_code;
	}
	
	public	int getCity_code(){
		return this.city_code;
	}
	
	public void setProvince_id(int province_id){
		this.province_id = province_id;
	}
	
	public int getProvince_id(){
		return this.province_id;
	}

}
