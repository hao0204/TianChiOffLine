package com.shichaohao.model;

public class Item {
	
	private String item_id;
	private String item_geohash;
	private String item_category;
	
	Item(){
		
	}
	Item(String item_id, String item_geohash, String item_category){
		this.item_id = item_id;
		this.item_geohash = item_geohash;
		this.item_category = item_category;
	}
	
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getItem_geohash() {
		return item_geohash;
	}
	public void setItem_geohash(String item_geohash) {
		this.item_geohash = item_geohash;
	}
	public String getItem_category() {
		return item_category;
	}
	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}
}
