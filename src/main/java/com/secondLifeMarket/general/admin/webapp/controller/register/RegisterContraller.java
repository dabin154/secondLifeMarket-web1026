package com.secondLifeMarket.general.admin.webapp.controller.register;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.secondLifeMarket.general.admin.manage.DicManager;
import com.secondLifeMarket.general.admin.manage.RegisterManager;
import com.secondLifeMarket.general.admin.model.DicInfo;
import com.secondLifeMarket.general.admin.model.JsonResult;
import com.secondLifeMarket.general.admin.model.User;
import com.secondLifeMarket.general.admin.util.framework.EncriptUtil;
import com.secondLifeMarket.general.admin.util.framework.JavaEmailUtil;
import com.secondLifeMarket.general.admin.webapp.controller.login.LoginController;

@Controller
public class RegisterContraller {
	private static final Log logger = LogFactory.getLog(LoginController.class);
	@Autowired
	private RegisterManager RegisterManager;
	@Autowired
	private DicManager dicManager;
	
	
	@RequestMapping("/registerPage")
	public ModelAndView registerUserPage(@ModelAttribute("user")User user){
		ModelAndView modelAndView = new ModelAndView();
		List<DicInfo> listDic =  dicManager.findDicValueByName("gender");
		modelAndView.setViewName("register");
		return modelAndView.addObject("listDic",listDic);
	}
	
	@RequestMapping("/registerUser")
	public Object registerUser(@ModelAttribute("user")User user){
		user.setPassWd(EncriptUtil.encriptSHA1(user.getPassWd()));
		RegisterManager.addUser(user);
		return "redirect:/login";
	}
	
	@ResponseBody
	@RequestMapping("/ajax/checkcode")
	public JsonResult getCode(String email){
		logger.info(email);
		JsonResult jsonResult = new JsonResult();
		JavaEmailUtil mailUtil = new JavaEmailUtil();
		String content = "请输入验证码：完成注册。<br/>";
		String code = String.valueOf(mailUtil.generateRandomArray(6));
		content = content + code;
		mailUtil.send("smtp.sina.com", email, "secondlifemarket@sina.com", "secondlifemarket@sina.com", "abc412592", "注册验证码", content);
		jsonResult.setSuccess(true);
		jsonResult.setInfo("成功");
		jsonResult.setData(code);
		logger.info(code);
		return jsonResult;
	}
	
	
}
