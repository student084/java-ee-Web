<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cset.jsp' starting page</title>
    
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
  <% 
  	//request.setAttribute("name", "amaker");
  %>
  <c:set value="amaker2" var="name" scope="request"></c:set>
  ${name }
  
  <c:set var="age">30</c:set>
  <c:out value="${age }"></c:out>
  
  <jsp:useBean id="per" class="com.amaker.bean.Person"></jsp:useBean>
  <c:set target="${per }" property="age" value="50"></c:set>
  <c:set target="${per }" property="name">jack</c:set>
  
  ${per.age }
  ${per.name }
  </body>
</html>
