package com.amaker.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amaker.util.DBUtil;

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
*	Check the user is legal or not
*	Check params for 'post'
*	If the user is legal ,then set a session ("login" => User.login) else
*	forword to Login.jsp
******************************************************************************
*/

public class Login extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Login() {
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
		System.out.println("doPost");
		if(login != null && password != null){
			
			DBUtil util = new DBUtil();
			Connection conn = util.openConnection();
			
			String sql = "select * from usertable where login = ? and password = ?";
			
			try {
				PreparedStatement pst = conn.prepareStatement(sql);	
				
				pst.setString(1, login);
				pst.setString(2, password);
				
				ResultSet rs = pst.executeQuery();
				System.out.println(login);
				if(!rs.next()){
					
					//An illegal login post
					String msg = "’À∫≈ªÚ√‹¬Î¥ÌŒÛ£¨«Î÷ÿ–¬µ«¬Ω";
					request.setAttribute("error", msg);
					
					//return to Login.jsp
					request.getRequestDispatcher("/Pages/Login.jsp").forward(request, response);
					
				}else{
					
					//An legal login post
					//Set session
					HttpSession session = request.getSession();
					
					session.setAttribute("username", login);
					//forward to the success page
					request.getRequestDispatcher("/Pages/Application/Home/ImgView.jsp").forward(request, response);
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				
				//close the connection
				util.closeConnection(conn);
			}
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
