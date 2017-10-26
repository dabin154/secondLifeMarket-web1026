package com.secondLifeMarket.general.admin.webapp.controller.goods.searcher;

import java.io.Serializable;

import com.secondLifeMarket.general.admin.model.GoodsInfo;
import com.secondLifeMarket.general.admin.util.framework.Page;

public class GoodsSearcher extends Page<GoodsInfo> implements Serializable{

	private static final long serialVersionUID = -4297081824466236310L;
	
	private String goodsAttribute;
	
	private String goodsArea;
	
	private String goodsName;
	
	private String startDate;
	
	private String endDate;

	public String getGoodsAttribute() {
		return goodsAttribute;
	}

	public void setGoodsAttribute(String goodsAttribute) {
		this.goodsAttribute = goodsAttribute;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getGoodsArea() {
		return goodsArea;
	}

	public void setGoodsArea(String goodsArea) {
		this.goodsArea = goodsArea;
	}
	
	
	

}
