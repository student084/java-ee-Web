package com.amaker.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amaker.bean.User;
import com.amaker.daoImp.UserDaoImp;


/*
******************************************************************************
*Copyright(c).
*Allrightsreserved.
*
*File 		$ProjectName: SkyOne$
*Author		$Author:jian Wang$
*Version	$Revision:0.0.1$
*Date$Date:	2016/2/14 18:33$
*Description
*	Create a DBUtil-Object, use openConnection and you will get a connection
*	to MYSQL 
******************************************************************************
*/

public class Register extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Register() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("repassword");
		
		if(password.equals(rePassword) && !password.equals(" ") && login != null && password != null && !login.equals(" ")){
			
			//insert the user's information
			User user = new User();
			user.setLogin(login);
			user.setPassWord(password);
			
			UserDaoImp u = new UserDaoImp();
			u.register(user);
			
			request.setAttribute("msg", "register successed");
			request.getRequestDispatcher("/Pages/Login.jsp").forward(request, response);
			
		}else{
			
			// there are some illegal input when register
			request.setAttribute("error", "there are some illegal input when register");
			request.getRequestDispatcher("/Pages/Register.jsp").forward(request, response);
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
