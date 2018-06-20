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
    
    <title>My JSP 'productList.jsp' starting page</title>
    
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
  <div style="{float:left}">
  <h2>由一级分类得到的二级分类</h2>
  <s:iterator var="c" value="#session.categoryList">
  	<h3><s:property value="#c.cname"/></h3>
  	<s:iterator var="cs" value="#c.categorySeconds">
  		<h5><a href="${pageContext.request.contextPath }/product_findByPageCsid.action?page=1&csid=<s:property value="#cs.csid"/> "><s:property value="#cs.csname"/></a></h5>
  	</s:iterator>
  </s:iterator>
  </div>
  <div style="{float:left}">
  <hr/>
  <h2>由分类加载出来的商品</h2>
  	<s:iterator var="pb" value="pageBean.list">
  		商品名：<a href="${pageContext.request.contextPath }/product_showProductDetails.action?pid=<s:property value="#pb.pid"/> "><s:property value="#pb.pname"/></a><br/>
  		
  	</s:iterator>
  </div>
  <div>
  	<h2>总记录:<s:property value="pageBean.totalCount"/></h2>
  	<h2>总页数:<s:property value="pageBean.totalPage"/></h2>
  </div>
  
  </body>
</html>
