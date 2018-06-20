package com.secondLifeMarket.general.admin.webapp.controller.shoppingcart;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.secondLifeMarket.general.admin.contents.UserAuthoritySubject;
import com.secondLifeMarket.general.admin.manage.GoodsManager;
import com.secondLifeMarket.general.admin.manage.ShoppingCartManager;
import com.secondLifeMarket.general.admin.model.GoodsInfo;
import com.secondLifeMarket.general.admin.model.ShoppingCart;
import com.secondLifeMarket.general.admin.model.User;
import com.secondLifeMarket.general.admin.util.framework.Page;
import com.secondLifeMarket.general.admin.webapp.controller.shoppingcart.searcher.ShoppingCartSearcher;

@Controller
public class ShoppingCartController {
	
	@Autowired
	private GoodsManager goodsManager;
	@Autowired
	private ShoppingCartManager ShoppingCartManager;

	@RequiresRoles("buyer")
	@RequestMapping(value="/shoppingCartList",method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView ShoppingCartList(@ModelAttribute("shoppingCartSearcher")ShoppingCartSearcher shoppingCartSearcher){
		ModelAndView modelAndView = new ModelAndView();
		User user=UserAuthoritySubject.getAccountSubject();//取Session中的User
		shoppingCartSearcher.setUserName(user.getUserName());
		shoppingCartSearcher.setPassWd(user.getPassWd());
		Page<ShoppingCart> pageObj = ShoppingCartManager.findShoppingCart(shoppingCartSearcher);
		modelAndView.setViewName("shoppingCartList");
		return modelAndView.addObject("pageObj",pageObj);
	}

	@RequiresRoles("buyer")
	@RequestMapping("/addShoppingCart")
	public Object addShoppingCart(String id){
		GoodsInfo info=goodsManager.getGoodsDetailById(id);
		User user=UserAuthoritySubject.getAccountSubject();//取Session中的User
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setUserName(user.getUserName());
		shoppingCart.setPassWd(user.getPassWd());
		shoppingCart.setGoodsName(info.getGoodsName());
		shoppingCart.setGoodsAttribute(info.getGoodsAttribute());
		shoppingCart.setGoodsOwner(info.getGoodsOwner());
		shoppingCart.setGoodsImageName(info.getGoodsImageName());
		shoppingCart.setGoodsOwnerConnectWay(info.getGoodsOwnerConnectWay());
		shoppingCart.setGoodsArea(info.getGoodsArea());
		shoppingCart.setGoodsAddDate(info.getGoodsAddDate());
		shoppingCart.setGoodsDic(info.getGoodsDic());
		ShoppingCartManager.addShoppingCart(shoppingCart);
		return "redirect:/goodsList";
	}

	@RequiresRoles("buyer")
	@RequestMapping("/delete")
	public Object deleteShoppingCart(String id){
		
		ShoppingCartManager.deleteShopping(id);
		
		return "redirect:/shoppingCartList";
	}
	

}
