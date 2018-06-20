package com.secondLifeMarket.general.admin.webapp.controller.login;

import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.secondLifeMarket.general.admin.manage.LoginManager;
import com.secondLifeMarket.general.admin.webapp.controller.login.searcher.LoginSearcher;


@Controller
public class LoginController{
	
	private static final Logger logger = LogManager.getLogger(LoginController.class.getName());
	
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
		logger.info("用户登陆参数{}", JSON.toJSONString(loginSearcher));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("modelAndView");
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginSearcher.getUserName(),loginSearcher.getPassword());
		try{
			subject.login(usernamePasswordToken);
		}catch (AuthenticationException e){
			modelAndView.setViewName("loginPage");
			modelAndView.addObject("message","用户名或密码错误请重新输入！");
		}
		return modelAndView;
	}
}
