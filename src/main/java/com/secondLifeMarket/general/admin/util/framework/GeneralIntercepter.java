package com.secondLifeMarket.general.admin.util.framework;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.secondLifeMarket.general.admin.contents.UserAuthoritySubject;
import com.secondLifeMarket.general.admin.dao.GeneralDao;
import com.secondLifeMarket.general.admin.model.User;

public class GeneralIntercepter implements HandlerInterceptor {
	private final static Logger LOGGER=LoggerFactory.getLogger(GeneralIntercepter.class);
	public static final String REQUEST_URI_REQUEST_KEY=GeneralIntercepter.class.getName()+".requestURI";
	public static final String REQUEST_URI_BEFORE_LOGIN_THREAD_KEY=GeneralIntercepter.class.getName()+".REQUESTURI_BEFOTRLOGIN";
	@Autowired
	GeneralDao dao;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String requestURI=request.getServletPath();
		if (requestURI.startsWith("/resources/")) return true;//针对静态资源请求 CSS、JS、IMG
		boolean flag=false;
		if (!checkUser()&& !requestURI.contains("login")&&!requestURI.contains("register")
				&&!requestURI.contains("goodsList")&&!requestURI.contains("checkcode")){                //放未登录可以进入页面。首页登录页。。。
			 if(request.getHeader("accept").matches(".*html.*")){
				String urlToSave=requestURI;
				if (request.getQueryString()!=null) 
					urlToSave+="?"+request.getQueryString();
				LOGGER.info("hahahaha");
				request.getSession().setAttribute(REQUEST_URI_BEFORE_LOGIN_THREAD_KEY, urlToSave);
				response.sendRedirect(request.getContextPath()+"/login");
			}
		}else{
			flag=true;
			if (request.getHeader("accept").matches(".*html.*")&&request.getAttribute(REQUEST_URI_REQUEST_KEY)==null) {
				request.setAttribute(REQUEST_URI_REQUEST_KEY,requestURI);
				LOGGER.info("Intercepter-> set requestURI : "+requestURI+" in session");
			}
		}
		return flag;
	}
	
	private boolean checkUser(){//判断用户有没有登录
		User user=UserAuthoritySubject.getAccountSubject();//取Session中的User
		if (user==null) {
			return false;
			}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (modelAndView!=null) {
			if (request.getSession().getAttribute("success")!=null){
				modelAndView.addObject("success", request.getSession().getAttribute("success"));
				request.getSession().removeAttribute("success");
			}
			if (request.getSession().getAttribute("error")!=null){
				modelAndView.addObject("error", request.getSession().getAttribute("error"));
				request.getSession().removeAttribute("error");
			}
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)
			throws Exception {
		if (e!=null){
			LOGGER.error("拦截器捕获到异常。",e);
//			request.getSession().removeAttribute(REQUEST_URI_SESSION_KEY);
//			if (HttpContextUtil.isAjaxRequest()) {
//				AjaxResult res = new AjaxResult();
//				res.setCode("-1");
//				String rootMessage=null;
//				Throwable root=e;
//				while (root!=null){
//					rootMessage=root.getMessage();
//					root=root.getCause();
//				}
//				res.setMessage(rootMessage);
//				res.setData(e);
//				response.setCharacterEncoding("UTF-8");
//				response.setStatus(500);
//				response.setHeader("AJAX_ERROR","1");
//				response.setHeader("Content-Type","application/json;charset=UTF-8");
//				response.getWriter().print(res);
//				response.getWriter().flush();
//				response.getWriter().close();
//			}else{
//				throw e;
//			}
		}

	}

}
