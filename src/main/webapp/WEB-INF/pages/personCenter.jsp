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
 	<title>二手货交易平台</title>
 	<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head> 
   <body >
    <div style="background: #8DEEEE;width: 100%;height:80px;line-height:80px;border-radius: 20px;text-align:center;">
	 	<h1 style="height:80px;line-height:80px;">个人中心</h1>
	 	</div>
   <form:form id="pageForm" action="${ctx}/modifPerson" modelAttribute="userInfoUser" 
                method="post" autocomplete="off">
	 
	 	<ul class="nav nav-tabs" style="width:100%">
			  <li class="active"><a href="#">个人信息</a></li>
			  <li><a href="${ctx}/personPublish">商品浏览记录</a></li>
			  <li><a href="${ctx}/personDeal">发布商品记录</a></li>
		</ul>
		
    <div class="col-lg-12 col-md-12 col-sm-12" style = "width:600px"  >
    
     <div class="panel">
               <div class="panel-body">
               
               <div class="col-xs-10">
                        <div class="form-horizontal" role="form">
                        
                           <div class="form-group">
                             <label for="name" class="col-sm-2 control-label">昵称:</label>
                             <div class="col-sm-10">
                             
                             <form:input cssClass="form-control" path="userName" id="userName"
											maxlength="32"/>
                             </div>
                         </div>
                        
                         <div class="form-group">
                                <label for="name" class="col-sm-2 control-label">姓名:</label>
                                <div class="col-sm-10">
                                 <form:input cssClass="form-control" path="realName" id="realName"
											maxlength="32"/>
                                </div>
                            </div>
                        
                        <div class="form-group">
                                <label for="gender" class="col-sm-2 control-label">姓别:</label>
                                <div class="col-sm-10">
                                 <form:select class="form-control" path="gender" id="gender" maxlength="2">
									<option value="1" label="男"
										<c:if test="${userInfoUser.gender==1}">selected</c:if>>男</option>
									<option value="0" label="女"
										<c:if test="${userInfoUser.gender==0}">selected</c:if>>女</option>
								</form:select>
                                </div>
                            </div>
                        
                        <div class="form-group">
                                <label for="age" class="col-sm-2 control-label">年龄:</label>
                                <div class="col-sm-10">
                                <form:input cssClass="form-control" path="age" id="age"
											maxlength="32"/>
                                </div>
                            </div>
                        
                         <div class="form-group">
                                <label for="email" class="col-sm-2 control-label">邮箱:</label>
                                <div class="col-sm-10">
                                <form:input cssClass="form-control" path="email" id="email"
											maxlength="32"/>
                                </div>
                            </div>
                            
                          <div class="form-group">
                             <label for="phone" class="col-sm-2 control-label">电话:</label>
                             <div class="col-sm-10">
                             <form:input cssClass="form-control" path="phone" id="phone"
											maxlength="32"/>
                             </div>
                         </div>
                        
                        </div>
                        </div>
                  </div>
                  <div class="modal-footer" >
	 			    <button id="save" type="button" class="btn btn-default">保存</button>
	 			    <input type="button" class="btn btn-default" onclick="location.href='${ctx}/returnFirst'" value="返回首页" />
 			      </div>
              </div>
               
       </div>
   </form:form>
   </body>
   
</html>