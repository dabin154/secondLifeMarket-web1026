package com.secondLifeMarket.general.admin.manage;

import com.secondLifeMarket.general.admin.model.ShoppingCart;
import com.secondLifeMarket.general.admin.util.framework.Page;
import com.secondLifeMarket.general.admin.webapp.controller.shoppingcart.searcher.ShoppingCartSearcher;

public interface ShoppingCartManager {
	
	public int addShoppingCart(ShoppingCart shoppingCart);
	
	public int deleteShopping(String id);
	
	public  Page<ShoppingCart> findShoppingCart(ShoppingCartSearcher shoppingCartSearcher);

}
