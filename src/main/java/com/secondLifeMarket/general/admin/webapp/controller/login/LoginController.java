package com.secondLifeMarket.general.admin.webapp.controller.login;

import com.alibaba.fastjson.JSON;
import com.secondLifeMarket.general.admin.contents.UserAuthoritySubject;
import com.secondLifeMarket.general.admin.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
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
		modelAndView.setViewName("mainhandle");

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginSearcher.getUserName(),loginSearcher.getPassword());
		try{
			User user = new User();
			user.setUserName(loginSearcher.getUserName());
            Md5Hash md5Hash = new Md5Hash(loginSearcher.getPassword(),loginSearcher.getUserName());
			user.setPassWd(md5Hash.toString());
			UserAuthoritySubject.setAccountSubject(user);
			subject.login(usernamePasswordToken);
		}catch (AuthenticationException e){
			modelAndView.setViewName("loginPage");
			modelAndView.addObject("message","用户名或密码错误请重新输入！");
		}
		return modelAndView;
	}
}
