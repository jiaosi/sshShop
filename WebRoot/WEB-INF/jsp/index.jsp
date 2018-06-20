<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <s:if test="#session.existUser == null">
    <a href="${pageContext.request.contextPath }/user_registerPage.action">注册</a>
    <br/>
    <a href="${pageContext.request.contextPath }/user_loginPage.action">登录</a>
    <br/>
  </s:if>
  <s:else>
  	<h3><s:property value="#session.existUser.name" /></h3>
  	<a href="#">我的订单</a>
  	<br/>
  	<a href="${pageContext.request.contextPath }/user_quit.action">退出</a>
  </s:else>
  
  <h1>一级分类目录</h1>
  <s:iterator var="c" value="#session.categoryList">
  	<h3><a href="${pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="#c.cid"/>&page=1 "><s:property value="#c.cname"/></a></h3>
  </s:iterator>
  
  <h1>显示热门商品</h1>
  <s:iterator var="p" value="hotProductList">
  	<a href="${pageContext.request.contextPath }/product_showProductDetails.action?pid=<s:property value="#p.pid"/> "><img src="${pageContext.request.contextPath }/<s:property value="#p.image"/>" /></a>
  </s:iterator>
  
  <h1>显示最新商品</h1>
  <s:iterator var="p" value="newProductList">
  	<a href="${pageContext.request.contextPath }/product_showProductDetails.action?pid=<s:property value="#p.pid"/> "><img src="${pageContext.request.contextPath }/<s:property value="#p.image"/>" /></a>
  </s:iterator>
  </body>
</html>
