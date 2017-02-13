package com.amaker.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest r, ServletResponse res,
			FilterChain c) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)r;
		HttpServletResponse response = (HttpServletResponse)res;
		HttpSession session = request.getSession();
		String User = (String) session.getAttribute("User");
		if(User != null && User.length() > 0){
			System.out.print(User.length());
			c.doFilter(r, res);
		}else{
			String msg = "你还没有登陆，请登陆后访问";
			request.setAttribute("error", msg);
			
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
