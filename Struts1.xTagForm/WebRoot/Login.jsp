<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
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
  ${error }  
    <html:form action="/Login">
    	<table border="0">
        <tr>
          <td>Username:</td>
          <td><html:text property="username"></</html:text></td>
        </tr>
        <tr>
          <td>Password:</td>
          <td><html:password property="password"></</html:password></td>
        </tr> 
        <tr>
          <td colspan="2" align="center"><input type="submit" value="Submit"></td>
        </tr>
      </table>
    </html:form>
  </body>
</html>
