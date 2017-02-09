package com.amaker.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet extends HttpServlet {
	
	public BasicServlet(){
		System.out.println("BasicServlet");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init");
		
		String userName = this.getInitParameter("username");
		System.out.println(userName);
		
		String url = this.getServletContext().getInitParameter("url");
		System.out.println(url);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doGet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doPost");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("service");
		PrintWriter out = resp.getWriter();
		out.println("hello servlet !");
		out.flush();
		out.close();
	}
	
	@Override
	public void destroy() {
		System.out.println("destory");
	}

}
