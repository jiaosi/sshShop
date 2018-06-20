<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
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
  	function checkUsername(){
  		//得到文本框数据
  		var username = document.getElementById("username").value;
  		//1.创建异步对象
  		var xhr = createXmlHttp();
  		//2.设置监听
  		xhr.onreadystatechange = function(){
  			if(xhr.readyState == 4){
  				if(xhr.status == 200){
  					document.getElementById("span_message").innerHTML = xhr.responseText;
  				}
  			}
  		}
  		//3.打开链接
  		//三个参数：请求方式， 请求路径， 是否异步
  		//路径这样写容易引起缓存，加一个时间戳
  		xhr.open("GET", "${pageContext.request.contextPath}/user_findByUsername?time="+new Date().getTime()+"&username="+username, true);
  		//4.发送
  		xhr.send(null);//此时get方法
  	}
  	//创建异步对象
  	function createXmlHttp(){
  		var xmlHttp;
  		try{ //FireFox, Opera 8.0+, safari
  			xmlHttp = new XMLHttpRequest();
  		}catch(e){
  			try{// Internet Explorer
  				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
  			}catch(e){
  				try{
  					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
  				}catch(e){
  				
  				}
  			}
  		}
  		return xmlHttp;
  	}
  	
  	//更换验证码
  	function _hyz(){
  		var vcode = document.getElementById("vcode");
  		vcode.src = "${pageContext.request.contextPath}/checkImgAction.action?time="+new Date().getTime();
  	}
  </script>
  <body>
    <form action="${pageContext.request.contextPath }/user_regist.action" method="post">
    	用户名：<input type="text" name="username" id="username" onblur="checkUsername()" />
    	<span id="span_message"><s:fielderror fieldName="username"></s:fielderror></span>
    	<br/>
    	密码：<input type="password" name="password" />
    	<span><s:fielderror fieldName="password"></s:fielderror></span>
    	<br/>
    	姓名:<input type="text" name="name" />
    	<span><s:fielderror fieldName="name"></s:fielderror></span>
    	<br/>
    	email:<input type="text" name="email" />
    	<span><s:fielderror fieldName="email"></s:fielderror></span>
    	<br/>
    	电话：<input type="text" name="phone" />
    	<span><s:fielderror fieldName="phone"></s:fielderror></span>
    	<br/>
    	地址:<input type="text" name="addr" />
    	<span><s:fielderror fieldName="addr"></s:fielderror></span>
    	<br/>
    	验证码：<input type="text" name="vCode" />
    	<img id="vcode" src="${pageContext.request.contextPath }/checkImgAction.action" title="点击更换验证码" onclick="_hyz()"/>
    	<span><s:actionerror/></span>
    	<br/>
    	
    	<input type="submit" value="提交" /> 
    </form>
  </body>
</html>
