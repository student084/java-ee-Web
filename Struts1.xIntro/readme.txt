structs ���̴����Ĳ���
1������web����
2�����jar�ļ�
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
3��web.xml��������ļ�:ActionServlet,����struts-config.xml
	<servlet>
		<servlet-name>action</servlet-name>
		<servlet-class>org.apache.struts.action.ActionServlet</servlet-class>
		
		<init-param>
	      <param-name>config</param-name>	//��ʱ��param-nameֻ��Ϊconfig�����������ļ�struts-config.xml
	      <param-value>/WEB-INF/struts-config.xml</param-value>
	    </init-param>
	</servlet>
	<servlet-mapping>
		<servlet-name>action</servlet-name>
		<url-pattern>*.do</url-pattern>
	</servlet-mapping>
4������com.amaker.action������LoginAction�࣬�̳�Action,@Overload execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	-----------------------����һ----------------------------------------
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
	
	----------------------------------������------------------------------
	
	����struct-config.xml������һ��forward
	
	<struts-config>
	<action-mappings>
		<action path="/login" type="com.amaker.action.LoginAction">
			
			<forward name="success" path="/Success.jsp"></forward>
			<forward name="failure" path="/Failure.jsp"></forward>
		</action>
	</action-mappings>
	</struts-config>
	
	LoginAction�Ĵ����Ϊ��
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
	��ʱ����ı�ɹ���ʧ�ܵ�ҳ�棬ֱ�Ӹ������ļ���path���Լ��ɣ�����Դ�ļ�
	--------------------------------------------------------------------
	
5����struts-config.xml����xxxAction
	//path:��ʾ����ʱ�õ���������ʱʹ��"login.do"����,eg: <form name="f1" id="f1" action="<%=path %>/login.do" >
	//type: �൱��uri����������Դ��
	----------------------------------------------------------------
	<struts-config>
	<action-mappings>
		<action path="/login" type="com.amaker.action.LoginAction"></action>
	</action-mappings>
	</struts-config>
	----------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------
	**************ActionForm�Ľ���********************
	
	1������com.amaker.form/LoginForm.java
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
	2������struts-config.xml,ע��LofinForm��������action��
		�󶨵ķ�����action ����form-bean��"name"ֵһ�£����Ա�������ʱ���װ��loginForm�г�Ϊһ��bean
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

	3��Form�����ǿ��ת����form�е�ֵ�Ļ�ȡ��
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