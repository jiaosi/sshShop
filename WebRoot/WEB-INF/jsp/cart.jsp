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
    
    <title>My JSP 'cart.jsp' starting page</title>
    
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
  <s:if test="#session.cart.cartItems.size() != 0">
  <s:iterator var="c" value="#session.cart.cartItems">
    <table>
    	<tr>
    		<td>名称：</td><td><s:property value="#c.product.pname" /></td>
    	</tr>
    	<tr>
    		<td>商城价：</td><td><s:property value="#c.product.shop_price" /></td>
    	</tr>
    	<tr>
    		<td>图片：</td><td><img src="${pageContext.request.contextPath }/<s:property value="#c.product.image" />" /></td>
    	</tr>
    	<tr>
    		<td>购买数量：</td><td><s:property value="#c.count" /></td>
    	</tr>
    	<tr>
    		<td>小计：</td><td><s:property value="#c.subtotal" /></td>
    	</tr>
    	<tr>
    		<td><a href="${pageContext.request.contextPath }/cartAction_removeCart.action?pid=<s:property value="#c.product.pid"/> ">删除</a></td>
    	</tr>
    	<span>=================================================</span>
    </table>
    </s:iterator>
    </s:if>
    <s:else>
    	<h4>未进行购物，购物车为空</h4>
    </s:else>
    <hr/>
    <h3>总计<s:property value="#session.cart.total"/></h3>
    <h4><a href="${pageContext.request.contextPath }/cartAction_clearCart.action">清空购物车</a></h4>
  </body>
</html>
