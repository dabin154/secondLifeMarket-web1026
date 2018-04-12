<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" isErrorPage="true" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%>

 <c:set var="ctx" value="${pageContext.request.contextPath}"/>
 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>二手货交易平台</title>
<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<style type="text/css">
.background {
	padding: 0px;
	margin: 0px;
	width: 100%;
	height: 100%;
};
.btn btn-default {
	width: 80px;
	height: 15px;
	background: #00EE00;
	border-radius: 10px;
};
.btn btn-default:hover {
	background: #FF0000;
};
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body style="background-image:url(<%=basePath%>resources/images/timg.png);">

	<div class="background"  >
	
		<div style="background-color: #8DEEEE; width: 450px; height: 550px; margin: 50px 10px 10px 400px; border-radius: 20px;">
		
			<form:form id = "pageForm" role="form" cssStyle="padding-top:100px;padding-left:20px;padding-right:20px;" modelAttribute="loginSearcher">
			 	<div class="alert alert-error" style="display: none">
                    <span class="iconsm iconsm-warning"></span><span id="errorMsg" style="color: red"></span>
                </div>
				<div class="form-group">
					<label for="exampleInputEmail1">用户名:</label>
					<form:input path="userName" type="text" cssClass="form-control"  placeholder="请输入您的用户名"/>
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">密码:</label>
					<form:input path="password" type="password" cssClass="form-control"  placeholder="请输入您的密码"/>
				</div>
				
				<div class="checkbox">
					<label> <input type="checkbox"> 记住密码</label>
					<a style="margin-left:200px" href="<%=basePath%>registerPage">新用户注册</a>
				</div>
				
				<div class="col-md-12 col-sm-12 text-center">
					<button type="button" class="btn btn-primary btn-lg" id="query">登录</button>
					<button type="button" class="btn btn-default btn-lg" id="reset"onclick="clearValue();">重置</button>
				</div>
				
				<input type="hidden"  id="message" value="${message}">
				
			</form:form>
		</div>
	</div>
	<script src="http://libs.baidu.com/jquery/1.9.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
<script type="text/javascript">

$(document).ready(function(){ 
	if($("#message").val()!=""){
		alert($("#message").val());
		$("#userName").val('');
		$("#password").val('');
	}
});

$(function() {
    $("#query").click(function() {
        $('form[id=pageForm]').attr("action","${ctx}/checklogin");
        $("#pageForm").submit();
    });
    
    $("#reset").click(function() {
        $("input").val('');
        $("select").val("-1");
    });
});

</script>
</html>


