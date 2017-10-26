<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" isErrorPage="true" pageEncoding="UTF-8"contentType="text/html;charset=utf-8"%>
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
    <form:form id="pageForm" action="${ctx}/personDeal" modelAttribute="personSearcher" method="post" autocomplete="off">
	 	<ul class="nav nav-tabs" style="width:100%">
			  <li ><a href="${ctx}/personCenter">个人信息</a></li>
			  <li ><a href="${ctx}/personPublish">商品浏览记录</a></li>
			  <li class="active"><a href="#">发布商品记录</a></li>
		</ul> 
		<section class="wrapper">
			<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			   <section class="panel">
				   <div class="panel-body" id="condition">
				   <div class="row">
                        <div class="form-horizontal">
                        
                         <div class="col-lg-6 col-md-6 col-sm-6">
                           		<div class="form-group">
                            		<label class="col-lg-4 col-sm-4 control-label">发布开始日期</label>
                            		<div class="col-lg-8 col-sm-8">
                            			<form:input path="startDate" cssClass="form-control" placeholder="${startDate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"></form:input>
                            		</div>
                           		</div>
                       		</div>
                       		
                       		 <div class="col-lg-6 col-md-6 col-sm-6">
                            	<div class="form-group">
                            		<label class="col-lg-4 col-sm-4 control-label">发布结束日期</label>
                            		<div class="col-lg-8 col-sm-8">
                            			<form:input path="endDate" cssClass="form-control" placeholder="${endDate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"></form:input>
                            		</div>
                            	</div>
                            </div>
                        
                         <div class="col-md-12 col-sm-12 text-center">
                                <button type="button" class="btn btn-primary btn-lg" id="query">查询</button>
                                <button type="button" class="btn btn-default btn-lg" id="reset"  onclick="clearValue();">重置</button>
                            </div>
                        
                        </div>
                   </div>
				   </div>
			   </section>
			</div>
	        </div>
	   <div class="row">
        <div class="col-lg-12">
            <section class="panel">
                <div class="panel-body">
                	<div class="adv-table" style="overflow: scroll">
	                	<table class="table table-bordered table-striped" id="tb">
	                	  <thead>
	                	   <tr>
	                	   <th>商品名称</th>
	                	   <th>商品分类</th>
	                	   <th>商品价格</th>
	                	   <th>商品发布日期</th>
	                	   <th>操作</th>
	                	   </tr>
	                	  </thead>
	                	   <tbody>
		                	   <c:forEach items="${pageObj.result}" var="personalGoodsInfo">
		                	   <tr>
			                	   <td>${personalGoodsInfo.goodsName}</td>
			                	   <td>${personalGoodsInfo.goodsAttribute}</td>
			                	   <td>${personalGoodsInfo.goodsPrice}</td>
			                	   <td>${personalGoodsInfo.goodsAddDate}</td>
			                	   <td><a href="${ctx}/deletePersonalGoods?id=${personalGoodsInfo.id}">删除</a></td>
		                	   </tr>
		                	   </c:forEach>
	                	   </tbody>
	                	</table>
                	</div>
                </div>
            </section>
       </div>
      </div>
	    </section>
           <div class="modal-footer" >
	    <input type="button" class="btn btn-default" onclick="location.href='${ctx}/returnFirst'" value="返回首页" />
      </div>
		      
      </form:form>          
   
   
   
   
   </body>
   <script type="text/javascript" src="${ctx}/resources/js/My97DatePicker/WdatePicker.js?v=${nowDate}"></script>
 </html>