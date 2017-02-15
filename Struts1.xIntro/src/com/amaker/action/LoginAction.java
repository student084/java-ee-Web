package com.amaker.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.amaker.form.LoginForm;

public class LoginAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		System.out.println("LoginAction excute ......");
		
		//String username = request.getParameter("username");
		//String password = request.getParameter("password");
		
		LoginForm loginForm = (LoginForm)form;
		
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		
		if(username.equals("amaker")){
			
			//request.getRequestDispatcher("Success.jsp").forward(request, response);
			return mapping.findForward("success");
			
		}else{
			
			//request.getRequestDispatcher("Failure.jsp").forward(request, response);
			return mapping.findForward("failue");
		}
		//return null;
	}
	
}
