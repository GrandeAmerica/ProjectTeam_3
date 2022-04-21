package com.team3.dto;

public class B_userVO {
	private String user_id;
	private String user_password;
	private String user_name;
	private String user_email;
	private String user_tel;
	private String b_license;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public String getB_license() {
		return b_license;
	}
	public void setB_license(String b_license) {
		this.b_license = b_license;
	}
	
	@Override
	public String toString() {
		return "B_userVO [user_id=" + user_id + ", user_password=" + user_password + ", user_name=" + user_name + ", user_email="
				+ user_email + ", user_tel=" + user_tel + ", b_license=" + b_license + "]";
	}
	
}
