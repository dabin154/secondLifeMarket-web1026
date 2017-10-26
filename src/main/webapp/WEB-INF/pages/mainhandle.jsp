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

*{margin:0;padding:0;list-style-type:none;}
a,img{border:0;}
body{font:12px/180% Arial, Helvetica, sans-serif, "新宋体";}
/* flexslider */
.flexslider{position:relative;height:400px;overflow:hidden;background:url(${ctx}/resources/images/roll/loading.gif) 50% no-repeat;}
.slides{position:relative;z-index:1;}
.slides li{height:400px;}
.flex-control-nav{position:absolute;bottom:10px;z-index:2;width:100%;text-align:center;}
.flex-control-nav li{display:inline-block;width:14px;height:14px;margin:0 5px;*display:inline;zoom:1;}
.flex-control-nav a{display:inline-block;width:14px;height:14px;line-height:40px;overflow:hidden;background:url(${ctx}/resources/images/roll/dot.png) right 0 no-repeat;cursor:pointer;}
.flex-control-nav .flex-active{background-position:0 0;}

.flex-direction-nav{position:absolute;z-index:3;width:100%;top:45%;}
.flex-direction-nav li a{display:block;width:50px;height:50px;overflow:hidden;cursor:pointer;position:absolute;}
.flex-direction-nav li a.flex-prev{left:40px;background:url(${ctx}/resources/images/roll/prev.png) center center no-repeat;}
.flex-direction-nav li a.flex-next{right:40px;background:url(${ctx}/resources/images/roll/next.png) center center no-repeat;}

.functionpoint {
    margin-top:40px;
	margin-left: 50px;
	width: 85%;
	height:80px;   
    line-height:80px;   
	float: left;
    background: #8DEEEE;
	border-radius: 20px;
}

.functionpoint ul {
	line-height: 80px;
	text-align: center;
}

.nav-tabs li {
	margin-top:20px;
	margin-left: 60px;
	font-weight: bold;
	font-size: 18px;
}

.head {
	margin-left: 60px;
	margin-top:20px;
	color:#CD2626;
}
</style>

</head>

<body style="background-image:url(<%=basePath%>resources/images/mainbackground3.jpg);">
	<div class="headline"></div>
	<div>
		<div class="leftline"></div>
		<div class="functionpoint">
			<ul class="nav nav-tabs">
				<li class="active"><a href="#">首页</a></li>
				<li><a href="<%=basePath%>goodsList">二手货市场</a></li>
				<li><a href="${ctx}/shoppingCartList">我的购物车</a></li>
				<li><a href="${ctx}/personCenter">我</a></li>
				<li><a href="<%=basePath%>login">登录/注册</a></li>
			</ul>
		</div>
		<div style="height:80px;overflow:hidden;"></div>
		<div class="flexslider" style="margin-top:50px;margin-left:20px;margin-right:20px;">
			<ul class="slides">
				<li style="background:url(<%=basePath%>resources/images/roll/ershouhuo.jpg) 50% 0 no-repeat;"></li>
				<li style="background:url(<%=basePath%>resources/images/roll/ershouhuo1.jpg) 50% 0 no-repeat;"></li>
				<li style="background:url(<%=basePath%>resources/images/roll/ershouhuo2.jpg) 50% 0 no-repeat;"></li>
				<li style="background:url(<%=basePath%>resources/images/roll/ershouhuo3.jpg) 50% 0 no-repeat;"></li>
				<li style="background:url(<%=basePath%>resources/images/roll/ershouhuo4.jpg) 50% 0 no-repeat;"></li>
			</ul>
		</div>
	</div>
	
	
	<script src="http://libs.baidu.com/jquery/1.9.0/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/js/jquery.flexslider-min.js"></script>
	<!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$('.flexslider').flexslider({
					directionNav: true,
					pauseOnAction: false
				});
			});
</script>
</body>
</html>
