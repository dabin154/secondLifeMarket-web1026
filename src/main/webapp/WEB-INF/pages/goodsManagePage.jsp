<content tag="heading"><!--
     *  File Name             : result_manage.jsp
     *  Author                :
     *  Create Date           :
     *  Description           :
     *  Reviewed By           :
     *  Reviewed Date         :
     *  Version History       : 1.0
     *  Modified By           :
     *  Modified Date         :
     *  Comments              :
     *  CopyRight             : COPYRIGHT(c)   All Rights Reserved
--></content>
<%@ page language="java" pageEncoding="UTF-8"contentType="text/html;charset=utf-8"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%>
 <c:set var="ctx" value="${pageContext.request.contextPath}"/>

 <html>
	 <head>
	 	<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
	 	<link rel="stylesheet" href="resources/css/jquery.fileupload.css">  
		<link rel="stylesheet" href="resources/css/jquery.fileupload-ui.css"> 
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
	 </head>
<body style="background-image:url(${ctx}/resources/images/goodsbackground.jpg);">
     <div style="background: #8DEEEE;width: 100%;height:80px;line-height:80px;border-radius: 20px;text-align:center;">
	 	<h1 style="height:80px;line-height:80px;">发布二手货</h1>
	 	</div>
	 <div style="width: 650px; height: 850px; margin: 10px 10px 10px 40px; border-radius: 20px;">
	 <div style="padding:10px;">
	 <form:form id="pageForm" action="${ctx}/goodsAdd" role="form" modelAttribute="goodsInfo" autocomplete="off">
	  
		 			 <div class="form-group">
		 			   <label >商品名称：</label>
					   <form:input cssClass="form-control" placeholder="请输入商品名称" path="goodsName"/>
		 			</div>
		 			<div class="form-group">
			 			<label >商品品类：</label>
						<form:select path="goodsAttribute" cssClass="form-control" >
                                            	<form:option value="">-- 请选择 --</form:option>
                                            	<form:options items="${goodsAttrList}" itemLabel="code" itemValue="code"/>
                                            </form:select> 
		 			</div>
		 			
		 			<div class="form-group">
			 			<label >区域：</label>
						 <form:select path="goodsArea" cssClass="form-control" >
                                            	<form:option value="">-- 请选择 --</form:option>
                                            	<form:options items="${areaList}" itemLabel="code" itemValue="code"/>
                                            </form:select> 
		 			</div>
		 			
		 			<div class="form-group">
		 				<label >价格：</label>
						<form:input  class="form-control" placeholder="请输入商品价格" path="goodsPrice"/>
		 			</div>
		 			<div class="form-group">
                   		<label>发布开始日期</label>
                   		<form:input class="form-control" placeholder="请输入日期" path="goodsAddDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"></form:input>
                   	</div>
		 			<div class="form-group">
		 				<label >联系人：</label>
						<form:input  class="form-control" placeholder="请输入姓名" path="goodsOwner"/>
		 			</div>
		 			<div class="form-group">
		 				<label >联系方式：</label>
						<form:input class="form-control" placeholder="请输入联系方式" path="goodsOwnerConnectWay"/>
		 			</div>
		 			
		 			 <div class="form-group">
			 			    <label>物品照片：</label>	 
							<div id="image" style="width:400px;height:250px;border:3px solid #EEDC82;text-align:center;" >
								<input class="form-control" id="inputImgUpload" type="file" name="img"/>
							</div>
						</div>
						
					<form:input id="imgName" type="hidden" path="goodsImageName"/>
			
		
 			<div class="modal-footer" >
	 			<button id="save" type="button" class="btn btn-default">保存</button>
	 			<input type="button" class="btn btn-default"
											onclick="location.href='${ctx}/goodsList'"
											value="返回列表" />
 			</div>
	 				
</form:form>
</div>
</div>
	<script src="http://libs.baidu.com/jquery/1.9.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="resources/js/ajaxfileupload.js"></script>
	<script type="text/javascript" src="${ctx}/resources/js/My97DatePicker/WdatePicker.js?v=${nowDate}"></script>
	<script type="text/javascript">
	$(function() {
		
		 $("#save").click(function() {
		        $("#pageForm").submit();
		    });
	});
	
	    (function(){
	    	$('#inputImgUpload').change(function(){
	    		$.ajaxFileUpload({
	    			 url: 'uploadImage',              //用于文件上传的服务器端请求地址
	                 fileElementId: 'inputImgUpload', //文件上传空间的id属性  <input type="file" id="file" name="file" />
	                 dataType: 'JSON',                //返回值类型 一般设置为json{attribute:value, attribute:value ...}
	                 success: function (data, status){//服务器成功响应处理函数
	                	 $("#image").append($('<img >').attr({"src":"downImages?id="+data.data,"width":"180px","height":"240px","padding-right":"5px"}));
	                 	 $("#inputImgUpload").attr("type","hidden");
	                 	 $("#imgName").val(data.imageName);
	                 },
	                 error: function (data, status, e){//服务器响应失败处理函数
	                     console.error(data);
	                     console.error(status);
	                     console.error(e);
	                 }
	    		});
	    	});
	    })();
	</script>
	
	</body>
</html>
 