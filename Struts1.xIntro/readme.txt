structs 工程创建的步骤
1、建立web工程
2、添加jar文件
	antlr-2.7.2.jar
	commons-beanutils-1.7.0.jar
	commons-chain-1.1.jar
	commons-digester-1.8.jar
	commons-logging-1.0.4.jar
	commons-validator-1.3.1.jar
	oro-2.0.8.jar
	struts-core-1.3.8.jar
	struts-taglib-1.3.8.jar
	struts-tiles-1.3.8.jar
3、web.xml配置入口文件:ActionServlet,拷贝struts-config.xml
	<servlet>
		<servlet-name>action</servlet-name>
		<servlet-class>org.apache.struts.action.ActionServlet</servlet-class>
		
		<init-param>
	      <param-name>config</param-name>	//此时的param-name只能为config，加在配置文件struts-config.xml
	      <param-value>/WEB-INF/struts-config.xml</param-value>
	    </init-param>
	</servlet>
	<servlet-mapping>
		<servlet-name>action</servlet-name>
		<url-pattern>*.do</url-pattern>
	</servlet-mapping>
4、创建com.amaker.action，创建LoginAction类，继承Action,@Overload execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	-----------------------方法一----------------------------------------
	public class LoginAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		System.out.println("LoginAction excute ......");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("amaker")){
			
			request.getRequestDispatcher("Success.jsp").forward(request, response);
		}else{
			
			request.getRequestDispatcher("Failure.jsp").forward(request, response);
		}
		return null;
	}
	
	}
	
	----------------------------------方法二------------------------------
	
	配置struct-config.xml，创建一个forward
	
	<struts-config>
	<action-mappings>
		<action path="/login" type="com.amaker.action.LoginAction">
			
			<forward name="success" path="/Success.jsp"></forward>
			<forward name="failure" path="/Failure.jsp"></forward>
		</action>
	</action-mappings>
	</struts-config>
	
	LoginAction的代码改为：
	*********
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		System.out.println("LoginAction excute ......");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("amaker")){
			
			//request.getRequestDispatcher("Success.jsp").forward(request, response);
			//findForward by name in struts-config.xml
			return mapping.findForward("success");
			
		}else{
			
			//request.getRequestDispatcher("Failure.jsp").forward(request, response);
			return mapping.findForward("failue");
		}
		//return null;
	}
	********
	此时若想改变成功或失败的页面，直接改配置文件的path属性即可，不改源文件
	--------------------------------------------------------------------
	
5、在struts-config.xml配置xxxAction
	//path:表示调用时用的名，调用时使用"login.do"调用,eg: <form name="f1" id="f1" action="<%=path %>/login.do" >
	//type: 相当于uri，即加载来源地
	----------------------------------------------------------------
	<struts-config>
	<action-mappings>
		<action path="/login" type="com.amaker.action.LoginAction"></action>
	</action-mappings>
	</struts-config>
	----------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------
	**************ActionForm的建立********************
	
	1、创建com.amaker.form/LoginForm.java
	------------------------------------------------------------------------
	package com.amaker.form;

	import org.apache.struts.action.ActionForm;

	public class LoginForm extends ActionForm{
	
	private String username;
	
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	}
	--------------------------------------------------------------------
	2、配置struts-config.xml,注册LofinForm并将其与action绑定
		绑定的方法：action 中与form-bean的"name"值一致，所以表单在请求时会封装进loginForm中成为一个bean
	<?xml version="1.0" encoding="ISO-8859-1" ?>


	<!DOCTYPE struts-config PUBLIC
	          "-//Apache Software Foundation//DTD Struts Configuration 1.3//EN"
	          "http://struts.apache.org/dtds/struts-config_1_3.dtd">
	
	<struts-config>
	
		<form-beans>
			<form-bean name="loginForm" type="com.amaker.form.LoginForm"></form-bean>
		</form-beans>
		
		<action-mappings>
			<action path="/login" type="com.amaker.action.LoginAction" name="loginForm">
				
				<forward name="success" path="/Success.jsp"></forward>
				<forward name="failure" path="/Failure.jsp"></forward>
			</action>
		</action-mappings>
		
	</struts-config>

	3、Form对象的强制转换及form中的值的获取；
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		System.out.println("LoginAction excute ......");
		
		
		LoginForm loginForm = (LoginForm)form;
		
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		
		if(username.equals("amaker")){
			
			return mapping.findForward("success");
			
		}else{
			
			return mapping.findForward("failue");
		}
	}