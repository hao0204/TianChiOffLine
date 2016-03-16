package com.shichaohao.model;

public class User {
	
	private String user_id; //用户标识
	private String item_id; //商品标识
	private String behavior_type; //用户对商品的行为类型.包括浏览、收藏、加购物车、购买，对应取值分别是1、2、3、4。
	private String user_geohash; //用户位置的空间标识，可以为空
	private String item_category; //商品分类标识
	private String time; //行为时间
	
	public User(){
	}
	public User(String user_id, String item_id, String behavior_type,
			String user_geohash, String item_category, String time) {
		super();
		this.user_id = user_id;
		this.item_id = item_id;
		this.behavior_type = behavior_type;
		this.user_geohash = user_geohash;
		this.item_category = item_category;
		this.time = time;
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
	public String getBehavior_type() {
		return behavior_type;
	}
	public void setBehavior_type(String behavior_type) {
		this.behavior_type = behavior_type;
	}
	public String getUser_geohash() {
		return user_geohash;
	}
	public void setUser_geohash(String user_geohash) {
		this.user_geohash = user_geohash;
	}
	public String getItem_category() {
		return item_category;
	}
	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
