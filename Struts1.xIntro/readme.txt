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
	----------------------------------------------------------------
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
	
	----------------------------------------------------------------
	
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
			
	