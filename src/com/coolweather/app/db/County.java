package com.coolweather.app.db;

public class County {
	
	private int id ;
	private String county_name;
	private int county_code;
	private int city_id;
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setCounty_name(String county_name){
		this.county_name = county_name;
	}
	
	public String getCounty_name(){
		return this.county_name;
	}
	
	public void setCounty_code(int county_code){
		this.county_code = county_code;
	}
	
	public	int getCounty_code(){
		return this.county_code;
	}
	
	public void setCity_id(int city_id){
		this.city_id = city_id;
	}
	
	public int getCity_id(){
		return this.city_id;
	}

}
