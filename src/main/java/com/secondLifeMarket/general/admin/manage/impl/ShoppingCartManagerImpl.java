package com.secondLifeMarket.general.admin.manage.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secondLifeMarket.general.admin.dao.ShoppingCartDao;
import com.secondLifeMarket.general.admin.manage.ShoppingCartManager;
import com.secondLifeMarket.general.admin.model.ShoppingCart;
import com.secondLifeMarket.general.admin.util.framework.Page;
import com.secondLifeMarket.general.admin.webapp.controller.shoppingcart.searcher.ShoppingCartSearcher;
@Service("ShoppingCartManager")
public class ShoppingCartManagerImpl implements ShoppingCartManager{

	@Autowired
	private ShoppingCartDao shoppingCartDao;
	
	@Override
	public int addShoppingCart(ShoppingCart shoppingCart) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		shoppingCart.setAddShoppingCartDate(df.format(new Date()));
		return shoppingCartDao.addShoppingCart(shoppingCart);
	}

	@Override
	public  Page<ShoppingCart> findShoppingCart(ShoppingCartSearcher shoppingCartSearcher) {
		List<ShoppingCart> list = shoppingCartDao.searchShopingCart(shoppingCartSearcher);
		shoppingCartSearcher.setResult(list);
		return shoppingCartSearcher;
	}

	@Override
	public int deleteShopping(String id) {
		return shoppingCartDao.deleteShoppingCart(id);
	}

}
