<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" isErrorPage="true" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%>
 <c:set var="ctx" value="${pageContext.request.contextPath}"/>
 <html>
<head>
<title>二手货交易平台</title>
<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body style="background:#FFEC8B" >
	<h2>注册</h2>
	<div style = "margin-left:60px;margin-top:30px; width:600px;">
	
	<form:form id ="pageForm" action = "${ctx}/registerUser" role="form" modelAttribute="user">
	
		<div class="form-group">
			<label for="userName">昵称:</label>
			<form:input path="userName" cssClass="form-control"  placeholder="请输入您真实姓名" />
		</div>
		
		<div class="form-group">
			<label for="email">邮件地址:</label>
			<form:input id = "email" path="email" cssClass="form-control"  placeholder="请输入您电子邮箱地址"/>
			<button id="code-btn" type="button" style = "margin-top:10px;" class="btn btn-primary btn-lg">获取验证码</button>
		</div>
		
		<div class="form-group">
			<label for="code">验证码:</label>
			<input type="hidden"  id="code-temp" >
			<form:input id="code" path="code" cssClass="form-control"  placeholder="请输入验证码"/>
		</div>
		
		<div class="form-group">
			<label for="password">密码:</label>
			<form:input path="passWd" type="password"  cssClass="form-control"  placeholder="请输入密码"/>
		</div>
		
		<div class="form-group">
			<label for="secondPass">确认密码:</label>
			<form:input id = "secondPass" path = "" type="password" cssClass="form-control"  placeholder="请确认密码"/>
		</div>
		<div class="form-group">
			<label for="realName">真实姓名:</label>
			<form:input path = "realName"  cssClass="form-control"  placeholder="请输入真实姓名"/>
		</div>
		<div class="form-group">
			<label for="age">年龄:</label>
			<form:input path="age" cssClass="form-control"  placeholder="请输入您年龄"/>
		</div>
		<div class="form-group">
			<label for="gender">性别:</label>
		<form:select path="gender" cssClass="form-control" >
            <form:option value="">-- 请选择 --</form:option>
            <form:options items="${listDic}" itemLabel="code" itemValue="code"/>
        </form:select> 
		</div>
		
		<div class="form-group">
			<label for="phone">电话号码:</label>
			<form:input path="phone" cssClass="form-control"  placeholder="请输入您的电话号码"/>
		</div>
		<div>
			<button type="button" class="btn btn-primary btn-lg" id="register">注册</button>
			<button type="button" class="btn btn-default btn-lg" id="reset"onclick="clearValue();">重置</button>
		</div>
	</form:form>
	</div>
</body>
	<script src="http://libs.baidu.com/jquery/1.9.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
 
/* $("#pageForm").checkForm(); */
 
$(function() {
	
	 $("#register").click(function() {
	        $("#pageForm").submit();
	    });
	    
	    $("#reset").click(function() {
	        $("input").val('');
	        $("select").val("-1");
	    });
	    
	    $("#code-btn").click(function(){
	    	var data ={
	    			email: $("#email").val()
		    	};
	    	 $.ajax({
	    		 url : '${ctx}/ajax/checkcode',
	    		 data : data,
	    	 	 dataType : 'json',
	    	 	 async: false,
	    	 	 success:function(result){
	    	 		if(result.success){
	    	 			$("#code-temp").val(result.data);	
	    	 		}
	    	 	}
	    	 });
	    });
	    $("#code").blur(function(){
	    	if($("#code").val() != $("#code-temp").val()){
	    		alert("验证码错误，请重新输入！");
	    		$("#code").val('');
	    		return false;
	    	}
	    });
});
$('#pageForm').submit(function(){
	console.log("submit")
	var flag=false;
	$(this).find('input[name]:visible').each(function(){
		return flag=check(this);
	});
	return flag;
});
function check(e){
	var checker = $(e); //在这里我认为： name 代表的name 为 txtUser 的文本框
	console.log("check");
	console.log(e);
	if(checker.val() == ''){
		checker.attr("placeholder","不能为空！");
		checker.css("background-color","#FF4500");
		checker.focus();
		return false;
	}else
	{
		checker.css("background-color",'');
		return true;
	}
}

/* $("#userName").blur(function(){
	
}); */

</script>
</html>
