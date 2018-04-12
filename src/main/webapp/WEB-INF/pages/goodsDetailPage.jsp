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
	 
 	<body>
 	 <form:form  id="pageForm" autocomplete="off" >
 	 <div style="background: #8DEEEE;width: 85%;height:80px;line-height:80px;border-radius: 20px;text-align:center;">
	 	<h1 style="height:80px;line-height:80px;">商品详情</h1>
	</div>
	
	 <div class="panel-body">
                    <div class="col-xs-10">
                       <div class="form-horizontal" role="form">
                         <input id="idValue" type="hidden" value="${info.id}"/>
					 	 <div class="form-group">
							  <label class="col-sm-2 control-label">商品名称：</label>
							  <div class="col-sm-10">${info.goodsName}</div>			   
						</div>	 	
						
					 	 <div class="form-group">
							  <label class="col-sm-2 control-label">商品类别：</label>
							  <div class="col-sm-10">${info.goodsAttribute}</div>			   
						</div>	 	
						
					 	 <div class="form-group">
							  <label class="col-sm-2 control-label">商品价格：</label>
							  <div class="col-sm-10">${info.goodsPrice}</div>			   
						</div>	 	
					 	 <div class="form-group">
							  <label class="col-sm-2 control-label">商品发布者：</label>
							  <div class="col-sm-10">${info.goodsOwner}</div>			   
						</div>	 	
					 	 <div class="form-group">
							  <label class="col-sm-2 control-label">联系方式：</label>
							  <div class="col-sm-10">${info.goodsOwnerConnectWay}</div>			   
						</div>	 	
					 	 <div class="form-group">
							  <label class="col-sm-2 control-label">地址：</label>
							  <div class="col-sm-10">${info.goodsArea}</div>			   
						</div>	 	
					 	 <div class="form-group">
							  <label class="col-sm-2 control-label">发布日期：</label>
							  <div class="col-sm-10">${info.goodsAddDate}</div>			   
						</div>	 
						
						 <div style="width:200px;height:160px;">
                        	<img alt="image" src="downImages?id=${info.goodsImageName}" style="width:240px;height:160px;">
                         </div>
						
						<div class="modal-footer" >
	 			              <button id="addShoppingCart" type="button" class="btn btn-default">加入购物车</button>
	 			                <input type="button" class="btn btn-default"
											onclick="location.href='${ctx}/goodsList'"
											value="返回列表" />
 			           </div>
						
				</div>
			</div>	
       </div>	
     </form:form>  	  
 	</body>
 	
 	<script type="text/javascript">
 	
 	   $("#addShoppingCart").click(function(){
 		   
 		  var  idValue=$("#idValue").val();
 		  window.location.href="${ctx}/addShoppingCart?id="+idValue;
 	   });
 	   
 	</script>
 	
 </html>