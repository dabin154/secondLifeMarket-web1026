package com.secondLifeMarket.general.admin.dao;

import java.util.List;

import com.secondLifeMarket.general.admin.model.ShoppingCart;
import com.secondLifeMarket.general.admin.webapp.controller.shoppingcart.searcher.ShoppingCartSearcher;

public interface ShoppingCartDao {

	public int addShoppingCart(ShoppingCart shoppingCart);
	
	public List<ShoppingCart> searchShopingCart(ShoppingCartSearcher shoppingCartSearcher);
	
	public int deleteShoppingCart(String id);
}
