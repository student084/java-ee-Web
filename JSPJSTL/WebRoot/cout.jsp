<%@ page language="java" import="java.util.*, com.amaker.bean.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cout.jsp' starting page</title>
    
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
    <c:out value="value"/><br>
    <%
    int age = 30;
    request.setAttribute("age", new Integer(age));
     %>
    ${age }
    <br>
    <jsp:useBean id="per" class="com.amaker.bean.Person"/>
    <jsp:setProperty property="age" name="per" value="30"/>
    <jsp:setProperty property="name" name="per" value="amaker"/>
    
    ${per.age }
    ${per.name }
    <p>if ${name } is not exist , \${name } == maker as the default value</p>
    <c:out value="${name}" default="maker"></c:out>
  </body>
</html>
