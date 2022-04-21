package com.team3.dto;

import java.sql.Date;

public class N_reservationVO {
	private String user_id;
	private int resr_number;
	private String resr_user_name;
	private String resr_user_tel;
	private String resr_store_name;
	private Date resr_date;
	private Date resr_time;
	private String resr_store_need;
	private Date resr_usingtime;
	private int resr_person;
	private String resr_info;
	private String resr_before_info;
	
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getResr_number() {
		return resr_number;
	}
	public void setResr_number(int resr_number) {
		this.resr_number = resr_number;
	}
	public String getResr_user_name() {
		return resr_user_name;
	}
	public void setResr_user_name(String resr_user_name) {
		this.resr_user_name = resr_user_name;
	}
	public String getResr_user_tel() {
		return resr_user_tel;
	}
	public void setResr_user_tel(String resr_user_tel) {
		this.resr_user_tel = resr_user_tel;
	}
	public String getResr_store_name() {
		return resr_store_name;
	}
	public void setResr_store_name(String resr_store_name) {
		this.resr_store_name = resr_store_name;
	}
	public Date getResr_date() {
		return resr_date;
	}
	public void setResr_date(Date resr_date) {
		this.resr_date = resr_date;
	}
	public Date getResr_time() {
		return resr_time;
	}
	public void setResr_time(Date resr_time) {
		this.resr_time = resr_time;
	}
	public String getResr_store_need() {
		return resr_store_need;
	}
	public void setResr_store_need(String resr_store_need) {
		this.resr_store_need = resr_store_need;
	}
	public Date getResr_usingtime() {
		return resr_usingtime;
	}
	public void setResr_usingtime(Date resr_usingtime) {
		this.resr_usingtime = resr_usingtime;
	}
	public int getResr_person() {
		return resr_person;
	}
	public void setResr_person(int resr_person) {
		this.resr_person = resr_person;
	}
	public String getResr_info() {
		return resr_info;
	}
	public void setResr_info(String resr_info) {
		this.resr_info = resr_info;
	}
	public String getResr_before_info() {
		return resr_before_info;
	}
	public void setResr_before_info(String resr_before_info) {
		this.resr_before_info = resr_before_info;
	}
	
	
	
	@Override
	public String toString() {
		return "N_reservationVO [user_id=" + user_id + ", resr_number=" + resr_number + ", resr_user_name="
				+ resr_user_name + ", resr_user_tel=" + resr_user_tel + ", resr_store_name=" + resr_store_name
				+ ", resr_date=" + resr_date + ", resr_time=" + resr_time + ", resr_store_need=" + resr_store_need
				+ ", resr_usingtime=" + resr_usingtime + ", resr_person=" + resr_person + ", resr_info=" + resr_info
				+ ", resr_before_info=" + resr_before_info + "]";
	}
	
}
