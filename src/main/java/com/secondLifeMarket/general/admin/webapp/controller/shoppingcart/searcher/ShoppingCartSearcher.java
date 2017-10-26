package com.secondLifeMarket.general.admin.webapp.controller.shoppingcart.searcher;

import java.io.Serializable;

import com.secondLifeMarket.general.admin.model.ShoppingCart;
import com.secondLifeMarket.general.admin.util.framework.Page;

public class ShoppingCartSearcher extends Page<ShoppingCart> implements Serializable{

	private static final long serialVersionUID = 2990374116431972602L;
	
	private String userName;
	private String passWd;
	private String startDate;
	private String endDate;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWd() {
		return passWd;
	}
	public void setPassWd(String passWd) {
		this.passWd = passWd;
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
	
}
