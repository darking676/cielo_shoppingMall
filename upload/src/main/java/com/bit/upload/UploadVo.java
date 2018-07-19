package com.bit.upload;

import java.io.File;

public class UploadVo {

	int num;
	String writer;
	String sub;
	String con;
	File filename;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
	public File getFilename() {
		return filename;
	}
	public void setFilename(File filename) {
		this.filename = filename;
	}
	
	public UploadVo() {
		// TODO Auto-generated constructor stub
	}
	public UploadVo(int num, String writer, String sub, String con, File filename) {
		super();
		this.num = num;
		this.writer = writer;
		this.sub = sub;
		this.con = con;
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "UploadVo [num=" + num + ", writer=" + writer + ", sub=" + sub + ", con=" + con + ", filename="
				+ filename + "]";
	}
}
