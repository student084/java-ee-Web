package com.amaker.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

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
