<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
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
    <form name="f1" id="f1" action="<%=path %>/login.do" method="post">
      <table border="0">
        <tr>
          <td>Username:</td>
          <td><input type="text" name="username" ></td>
        </tr>
        <tr>
          <td>Password:</td>
          <td><input type="password" name="password" ></td>
        </tr> 
        <tr>
          <td colspan="2" align="center"><input type="submit" value="Submit"></td>
        </tr>
      </table>
    </form>
  </body>
</html>
