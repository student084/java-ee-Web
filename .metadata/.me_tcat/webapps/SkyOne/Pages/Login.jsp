<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
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
  ${error}
  ${msg }
   <form name="f1" id="f1" action="${basePath}servlet/Login" method="post">
      <table border="0">
        <tr>
          <td>Login:</td>
          <td><input type="text" name="login" id="login"></td>
        </tr>
        <tr>
          <td>Password:</td>
          <td><input type="password" name="password" id="password"></td>
        </tr> 
        <tr>
          <td colspan="2" align="center"><input type="submit" value="submit"></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><a href="${basePath}Pages/Register.jsp">Register</a></a></td>
        </tr>
      </table>
    </form>
  </body>
</html>
