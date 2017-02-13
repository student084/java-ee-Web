<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Calcutor.jsp' starting page</title>
    
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
  <jsp:useBean id="c" class="com.amaker.bean.Calcutor"></jsp:useBean>
  <jsp:setProperty name="c" property="*"/>
  
  RETURN:
 ${c.result}
 <!-- Calcutor.jsp call it's ownself ,then the c Object'param will get values from form by name-->
    <form name="f1" id="f1" action="Calcutor.jsp" method="post">
      <table border="0">
        <tr>
          <td>firstNumber:</td>
          <td><input type="text" name="firstNumber"></td>
        </tr>
        <tr>
          <td>operate:</td>
          <td>
          	<select name="operate">
          		<option value="/">/</option>
          		<option value="*">*</option>
          		<option value="-">-</option>
          		<option value="+">+</option>
          	</select>
          </td>
        </tr> 
        <tr>
          <td>secondNumber:</td>
          <td><input type="text" name="secondNumber"></td>
        </tr> 
        <tr>
          <td colspan="2" align="center"><input type="submit"></td>
        </tr>
        <tr>
          <td colspan="2" align="center"></td>
        </tr>
      </table>
    </form>
  </body>
</html>
