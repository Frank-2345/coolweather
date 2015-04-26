package com.coolweather.app.db;

public class Province {
	
	private int id ;
	private String province_name;
	private int province_code;
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setProvince_name(String province_name){
		this.province_name = province_name;
	}
	
	public String getProvince_name(){
		return this.province_name;
	}
	
	public void setProvince_code(int province_code){
		this.province_code = province_code;
	}
	
	public	int getProvince_code(){
		return this.province_code;
	}
	
//	public void setProvince_id(int province_id){
//		this.province_id = province_id;
//	}
//	
//	public int getProvince_id(){
//		return this.province_id;
//	}

}
