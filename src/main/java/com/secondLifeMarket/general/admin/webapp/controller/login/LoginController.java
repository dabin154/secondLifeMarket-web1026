package com.secondLifeMarket.general.admin.webapp.controller.login;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.secondLifeMarket.general.admin.manage.LoginManager;
import com.secondLifeMarket.general.admin.model.User;
import com.secondLifeMarket.general.admin.util.framework.EncriptUtil;
import com.secondLifeMarket.general.admin.webapp.controller.login.searcher.LoginSearcher;

@Controller
public class LoginController{
	
	private static final Log logger = LogFactory.getLog(LoginController.class); 
	
	@Autowired
	private LoginManager loginManager;
	
	@RequestMapping("/login")
	public ModelAndView handleRequest(@ModelAttribute("loginSearcher")LoginSearcher loginSearcher){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loginPage");
		return modelAndView;
	}
	
	@RequestMapping(value="/checklogin",method={RequestMethod.GET,RequestMethod.POST})
	public Object checkLogin(@ModelAttribute("loginSearcher")LoginSearcher loginSearcher){
		logger.info(loginSearcher.getUserName());
		int flag = loginManager.findUserByUserNameAndPass(loginSearcher.getUserName(), EncriptUtil.encriptSHA1(loginSearcher.getPassword()));
		ModelAndView modelAndView = new ModelAndView();
		if(flag == 1){
			return "redirect:/returnFirst";
		}else{
			modelAndView.setViewName("loginPage");
			modelAndView.addObject("message","用户名或密码错误请重新输入！");
		}
		return modelAndView;
	}
}
