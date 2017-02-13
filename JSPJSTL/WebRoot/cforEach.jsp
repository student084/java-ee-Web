<%@ page language="java" import="java.util.*,com.amaker.bean.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cforEach.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
  	List list = new ArrayList();
  	list.add("A1");
  	list.add("A2");
  	list.add("A3");
  	list.add("A4");
  	list.add("A5");
  	list.add("A6");
  	list.add("A7");
  	list.add("A8");
  	
  	List perList = new ArrayList();
  	Person per1 = new Person(12, "name1");
  	Person per2 = new Person(13, "name2");
  	Person per3 = new Person(14, "name3");
  	Person per4 = new Person(15, "name4");
  	
  	perList.add(per1);
  	perList.add(per2);
  	perList.add(per3);
  	perList.add(per4);
  	
  	request.setAttribute("List", list);
  	request.setAttribute("PerList", perList);
   %>
  <body>
    <c:forEach var="l" items="${List }">
    	<c:out value="${l }"></c:out>
    </c:forEach><br>
    
    <c:forEach var="p" items="${PerList }">
    	<c:out value="${p.name }"></c:out>
    	<c:out value="${p.age }"></c:out>
    </c:forEach>
  </body>
</html>
