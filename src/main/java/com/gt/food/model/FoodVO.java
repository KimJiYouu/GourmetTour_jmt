package com.gt.food.model;

import java.sql.Timestamp;

public class FoodVO {
	
	private int fno;
	private String id;
	private String food;
	private String title;
	private String writing;
	private String region;
	private Timestamp regdate;
	private String address;
	private String open;
	private int hit;
	
	public FoodVO() {
		
	}

	public FoodVO(int fno, String id, String food, String title, String writing, String region, Timestamp regdate,
			String address, String open, int hit) {
		super();
		this.fno = fno;
		this.id = id;
		this.food = food;
		this.title = title;
		this.writing = writing;
		this.region = region;
		this.regdate = regdate;
		this.address = address;
		this.open = open;
		this.hit = hit;
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriting() {
		return writing;
	}

	public void setWriting(String writing) {
		this.writing = writing;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	
}
