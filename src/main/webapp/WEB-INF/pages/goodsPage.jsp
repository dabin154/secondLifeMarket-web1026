<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" isErrorPage="true" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 <c:set var="ctx" value="${pageContext.request.contextPath}"/>
 <html>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
 <head>
 	<title>二手货交易平台</title>
 	<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style type="text/css">
	.deployArea:hover{
		background-color:#FFFACD;
	}
	</style>
</head>
<body >
<form:form id="pageForm" action="${ctx}/goodsList" role="form" modelAttribute="goodsSearcher">
	<section class="wrapper">
			<div class="row">
			<%-- <input type="hidden" id="page_no" value="${pageObj.pageNo}"> --%>
			 <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			   <section class="panel">
				 <a href="javascript:;" class="title-click it-down">
                    <header class="panel-heading">
                        <span class="tools pull-right">
                          <c:choose>
                              <c:when test="${ pageObj.totalCount  < 20}">
                                  <span class="btnOver fa fa-owner-down"></span>
                                  <script type="text/javascript">
                                      $(function() {
                                          /* $("#condition").css("display","none"); */
                                          if($(".title-click").hasClass("it-down")) {
                                              $(".title-click").removeClass("it-down").addClass("it-up");
                                          }
                                      })
                                  </script>
                              </c:when>
                              <c:otherwise>
                                  <span class="btnOver fa fa-owner-down"></span>
                              </c:otherwise>
                          </c:choose>
                        </span>
                    </header>
                </a>
				 <div class="panel-body" id="condition">
                	<div class="row">
                        <div class="form-horizontal">
							
                        	 <div class="col-lg-6 col-md-6 col-sm-6">
                           		<div class="form-group">
                            		<label class="col-lg-4 col-sm-4 control-label">商品属性</label>
                            		<div class="col-lg-8 col-sm-8">
                            			<form:select path="goodsAttribute" cssClass="form-control" >
                                            	<form:option value="">-- 请选择 --</form:option>
                                            	<form:options items="${goodsAttrList}" itemLabel="code" itemValue="code"/>
                                            </form:select> 
                            		</div>
                           		</div>
                       		</div>
                       		
                       		<div class="col-lg-6 col-md-6 col-sm-6">
                           		<div class="form-group">
                            		<label class="col-lg-4 col-sm-4 control-label">区域</label>
                            		<div class="col-lg-8 col-sm-8">
										  <form:select path="goodsArea" cssClass="form-control" >
                                            	<form:option value="">-- 请选择 --</form:option>
                                            	<form:options items="${areaList}" itemLabel="code" itemValue="code"/>
                                            </form:select> 
                            		</div>
                           		</div>
                       		</div>
                       		
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
                  
                  <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
                  <input type="button" class="btn btn-default"
											onclick="location.href='${ctx}/returnFirst'"
											value="返回首页" />
                 	 <button id="add_goods" type="button" class="btn btn-primary">发布二手货</button>
                  </div>
                  
     <div class="row">
        <div class="col-lg-12">
            <section class="panel">
                <div class="panel-body">
                    <div class="adv-table" style="overflow: scroll">
                        <ul class="nav nav-tabs nav-justified" style="margin-left:190px; text-align:center;">
                        	 <c:forEach items="${pageObj.result}" var="goodsInfo"><br>
                        	<li class="deployArea"  style="border:3px solid #CDC5BF;width:900px;">
                        	
                        	    <input class="goods_id" type="hidden" value="${goodsInfo.id}">
                        	    
                        	    <div style="float:left;width:200px;height:160px;">
                        	    	<img alt="image" src="downImages?id=${goodsInfo.goodsImageName}" style="width:240px;height:160px;">
                        	    </div>
                        	    
	                        	<div style="float:left;width:500px;height:160px;padding-left:60px;">
	                        	<ul class="nav nav-pills nav-stacked" style="">
                      	    			<li style="padding:4px;color:#87CEFF;">
                      	    				<h2 >${goodsInfo.goodsName}</h2>
                      	    			</li>
                        	    		<li style="padding:4px;">发布人：${goodsInfo.goodsOwner}</li>
                        	    		<li style="padding:4px;">发布日期：${goodsInfo.goodsAddDate}</li>
                        	    	</ul>
	                        	</div>
	                        	<div style="float:left;width:180px;height:160px;">
	                        		<ul class="nav nav-pills nav-stacked">
	                        			<li style="color:#F00;margin-top:40px;margin-left:50px;"><h2>${goodsInfo.goodsPrice}元</h2></li>
	                        			<li style="margin-top:30px;margin-left:100px;">${goodsInfo.goodsArea}</li>
	                        		</ul>
	                        	</div>
                        	</li><br>
                        	</c:forEach>
                        </ul>
                        
                    </div>
                    <!--分页 begin-->
                   <%--  <div class="row">
                        <div class="col-lg-6">
                            <%@ include file="general/page_bar.jsp" %>
                        </div>
                    </div> --%>
                    <!--分页 end-->
                </div>
            </section>
        </div>
    </div>
    </section>
</form:form>
		</body>
		<script type="text/javascript" src="${ctx}/resources/js/My97DatePicker/WdatePicker.js?v=${nowDate}"></script>
		<script type="text/javascript">
		
		$(function() {
			
			 $("#query").click(function () {
		            $("#pageForm").submit();
		        });
			 
			 $("#reset").click(function() {
		            $("input").val('');
		            $("select").val("-1");
		        });
			 
			$("#add_goods").click(function(){
				window.location.href="${ctx}/manage";
			});
			
			$(".deployArea").click(function(){
				var goodsId=$(this).find('input.goods_id').val();
				window.location.href="${ctx}/goodsDetail?id="+goodsId;
				
			});
		});
		</script>
</html>
 