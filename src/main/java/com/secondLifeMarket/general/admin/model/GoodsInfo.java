package com.secondLifeMarket.general.admin.model;

import java.io.Serializable;

public class GoodsInfo implements Serializable{

	private static final long serialVersionUID = 4172294897607767501L;
	
	private String id;
	
	private String goodsName;
	
	private String goodsAttribute;
	
	private String goodsPrice;
	
	private String goodsOwner;
	
	private String goodsOwnerConnectWay;
	
	private String goodsImageName;
	
	private String goodsArea;
	
	private String goodsAddDate;
	
	private byte[] imageByte;
	
	private String goodsDic;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsAttribute() {
		return goodsAttribute;
	}

	public void setGoodsAttribute(String goodsAttribute) {
		this.goodsAttribute = goodsAttribute;
	}

	public String getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsOwner() {
		return goodsOwner;
	}

	public void setGoodsOwner(String goodsOwner) {
		this.goodsOwner = goodsOwner;
	}

	public String getGoodsOwnerConnectWay() {
		return goodsOwnerConnectWay;
	}

	public void setGoodsOwnerConnectWay(String goodsOwnerConnectWay) {
		this.goodsOwnerConnectWay = goodsOwnerConnectWay;
	}

	public String getGoodsImageName() {
		return goodsImageName;
	}

	public void setGoodsImageName(String goodsImageName) {
		this.goodsImageName = goodsImageName;
	}

	public String getGoodsArea() {
		return goodsArea;
	}

	public void setGoodsArea(String goodsArea) {
		this.goodsArea = goodsArea;
	}

	public String getGoodsAddDate() {
		return goodsAddDate;
	}

	public void setGoodsAddDate(String goodsAddDate) {
		this.goodsAddDate = goodsAddDate;
	}

	public byte[] getImageByte() {
		return imageByte;
	}

	public void setImageByte(byte[] imageByte) {
		this.imageByte = imageByte;
	}

	public String getGoodsDic() {
		return goodsDic;
	}

	public void setGoodsDic(String goodsDic) {
		this.goodsDic = goodsDic;
	}
	
	
}
