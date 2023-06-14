package com.gt.comments.model;

import java.sql.Timestamp;

public class CommentsVO {

	private int cno;
	private String id;
	private String comment_text;
	private Timestamp regdate;
	private int bno;
	
	public CommentsVO() {
		
	}
	public CommentsVO(int cno, String id, String comment_text, Timestamp regdate, int bno) {
		super();
		this.cno = cno;
		this.id = id;
		this.comment_text = comment_text;
		this.regdate = regdate;
		this.bno = bno;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComment_text() {
		return comment_text;
	}
	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	
	
}
