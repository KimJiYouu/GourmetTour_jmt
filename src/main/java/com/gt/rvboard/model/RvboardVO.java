package com.gt.rvboard.model;

import java.sql.Timestamp;

public class RvboardVO {
	private int bno;
	private String id;
	private String title;
	private String writing;
	private int hit;
	private Timestamp regdate;
	
	public RvboardVO() {
		
	}


	public RvboardVO(int bno, String id, String title, String writing, int hit, Timestamp regdate) {
		super();
		this.bno = bno;
		this.id = id;
		this.title = title;
		this.writing = writing;
		this.hit = hit;
		this.regdate = regdate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getwriting() {
		return writing;
	}

	public void setwriting(String writing) {
		this.writing = writing;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	
	
}
