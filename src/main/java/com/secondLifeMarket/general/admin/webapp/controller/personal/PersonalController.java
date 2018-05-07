package com.secondLifeMarket.general.admin.webapp.controller.personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.secondLifeMarket.general.admin.contents.UserAuthoritySubject;
import com.secondLifeMarket.general.admin.manage.GoodsManager;
import com.secondLifeMarket.general.admin.manage.LoginManager;
import com.secondLifeMarket.general.admin.manage.PersonManager;
import com.secondLifeMarket.general.admin.manage.UersBrowseRecordManager;
import com.secondLifeMarket.general.admin.model.GoodsInfo;
import com.secondLifeMarket.general.admin.model.User;
import com.secondLifeMarket.general.admin.util.framework.Page;
import com.secondLifeMarket.general.admin.webapp.controller.personal.searcher.PersonSearcher;
import com.secondLifeMarket.general.admin.webapp.controller.personal.searcher.UserBrowseRecordSearcher;
@Controller
public class PersonalController {
	
	@Autowired
	private LoginManager loginManager;
	@Autowired
	private PersonManager personManager;
	@Autowired
	private GoodsManager goodsManager;
	@Autowired
	private UersBrowseRecordManager uersBrowseRecordManager;
	
	//个人信息中心
	@RequestMapping(value="/personCenter",method={RequestMethod.POST,RequestMethod.GET})
	public Object personPage(){
		ModelAndView modelAndView  = new ModelAndView();
		User user=UserAuthoritySubject.getAccountSubject();//取Session中的User
		User userInfoUser = loginManager.findUser(user.getUserName(),user.getPassWd());
		modelAndView.addObject("userInfoUser",userInfoUser);
		modelAndView.setViewName("personCenter");
		return modelAndView;
	}
	//浏览记录
	@RequestMapping(value="/personPublish",method={RequestMethod.POST,RequestMethod.GET})
	public Object personPublish(@ModelAttribute("userBrowseRecordSearcher")UserBrowseRecordSearcher userBrowseRecordSearcher){
		ModelAndView modelAndView  = new ModelAndView();
		User user=UserAuthoritySubject.getAccountSubject();//取Session中的User
		
		
		modelAndView.setViewName("personPublish");
		return modelAndView;
	}
	//发布记录
	@RequestMapping(value="/personDeal",method={RequestMethod.POST,RequestMethod.GET})
	public Object personDeal(@ModelAttribute("personSearcher")PersonSearcher personSearcher){
		ModelAndView modelAndView  = new ModelAndView();
		User user=UserAuthoritySubject.getAccountSubject();//取Session中的User
		personSearcher.setUserName(user.getUserName());
		Page<GoodsInfo> pageObj =  personManager.seacherGoodsList(personSearcher);
		modelAndView.setViewName("personDeal");
		return modelAndView.addObject("pageObj",pageObj);
	}
	
	@RequestMapping(value="/modifPerson",method={RequestMethod.POST,RequestMethod.GET})
	public Object modifPersonInfo(@ModelAttribute("userInfoUser")User userInfoUser){
		int flag = loginManager.updateUser(userInfoUser);
		return "redirect:/personCenter";
	}
	@RequestMapping("/deletePersonalGoods")
	public Object deletePersonalGoods(String id){
		goodsManager.deleteGoods(id);
		return "redirect:/personDeal";
	}

}
