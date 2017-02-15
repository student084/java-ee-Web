package com.amaker.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.amaker.struts.form.LoginForm;

public class LoginAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
		
		LoginForm loginForm = (LoginForm)form;
		
		String username = loginForm.getUsername();
		
		System.out.println(username);
		if(username.equals("amaker")){
			
			return mapping.findForward("success");
		}else{
			request.setAttribute("error", "username should be amaker");
			//request.setAttribute("username", username);
			return mapping.findForward("login");
		}
	}

	
}
