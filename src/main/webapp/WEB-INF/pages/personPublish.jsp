<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" isErrorPage="true" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
   <head>
   <div style="background: #8DEEEE;width: 100%;height:80px;line-height:80px;border-radius: 20px;text-align:center;">
	 	<h1 style="height:80px;line-height:80px;">个人中心</h1>
	 	</div>
 	<title>二手货交易平台</title>
 	<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head> 
   <body >
    <form:form id="pageForm" action="${ctx}/modifPerson" modelAttribute="userInfoUser" 
                method="post" autocomplete="off">
	 	<ul class="nav nav-tabs" style="width:100%">
			  <li ><a href="${ctx}/personCenter">个人信息维护</a></li>
			  <li class="active"><a href="#">商品浏览记录</a></li>
			  <li><a href="${ctx}/personDeal">发布商品记录</a></li> 
		</ul>   
		
    <div class="col-lg-12 col-md-12 col-sm-12" style = "width:600px"  >
     <div class="panel">
               <div class="panel-body">
               
               
               </div>
               <div class="modal-footer" >
	 			    <input type="button" class="btn btn-default" onclick="location.href='${ctx}/returnFirst'" value="返回首页" />
 			      </div>
    	   </div>
 		</div>
		    
   </form:form>          
   
   
   
   
   </body>
 </html>