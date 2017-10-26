package com.secondLifeMarket.general.admin.model;

import java.io.Serializable;

public class ImageInfo implements Serializable{

	private static final long serialVersionUID = -7353158301629227626L;
	
	private String id;
	
	private String imageName;
	
	private String data;
	
	private byte[] imageByte;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public byte[] getImageByte() {
		return imageByte;
	}

	public void setImageByte(byte[] imageByte) {
		this.imageByte = imageByte;
	}

}
