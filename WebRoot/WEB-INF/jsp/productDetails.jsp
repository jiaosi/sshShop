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
    
    <title>商品详情</title>
    
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
    <h1>商品详情</h1>
    <table>
    	<tr>
    		<td>名称：</td><td><s:property value="model.pname" /></td>
    	</tr>
    	<tr>
    		<td>商场价：</td><td><s:property value="model.market_price" /></td>
    	</tr>
    	<tr>
    		<td>商城价：</td><td><s:property value="model.shop_price" /></td>
    	</tr>
    	<tr>
    		<td>图片：</td><td><img src="${pageContext.request.contextPath }/<s:property value="model.image" />" /></td>
    	</tr>
    	<tr>
    		<td>存货数量：</td><td><s:property value="model.num" /></td>
    	</tr>
    	<tr>
    		<td>描述：</td><td><s:property value="model.pdesc" /></td>
    	</tr>
    	<tr>
    		<td>上品时间：</td><td><s:property value="model.pdate" /></td>
    	</tr>
    	<tr>
    		<td><a href="${pageContext.request.contextPath }/product_toCart.action?pid=<s:property value="model.pid"/> ">购买</a></td>
    	</tr>
    </table>
  </body>
</html>
