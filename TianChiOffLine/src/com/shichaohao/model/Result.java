package com.shichaohao.model;

public class Result {
	private String user_id;
	private String item_id;
	
	public Result(){
	}
	
	public Result(String user_id, String item_id) {
		super();
		this.user_id = user_id;
		this.item_id = item_id;
	}

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	
}
