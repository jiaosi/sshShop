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
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
<script type="text/javascript">
	function _hyz(){
		var vcode = document.getElementById("vcode");
		vcode.src = "${pageContext.request.contextPath}/checkImgAction?time="+new Date().getTime();
	}
</script>
  
  <body>
    <h2>登录页面</h2>
    <form action="${pageContext.request.contextPath }/user_login.action" method="post">
    <!-- 显示显错误信息 -->
    <span><s:actionerror/></span>
    <br/>
    	用户名：<input type="text" name="username" />
    	<br/>
    	密码：<input type="password" name="password" />
    	<br/>
    	验证码：<input type="text" name="vCode" />
    	<img id="vcode" src="${pageContext.request.contextPath }/checkImgAction.action" title="点击更换验证码" onclick="_hyz()"/>
    	<br/>
    	<input type="submit" value="登录" />
    </form>
  </body>
</html>
