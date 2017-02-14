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

public class CheckUser implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse rep,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse)rep;
		HttpSession session =  request.getSession();
		if(session.getAttribute("login").toString().length() > 0){
			//legal request
			chain.doFilter(req, rep);
			
		}else{
			//illegal request turn ro login
			String msg = "ÄúÎ´µÇÂ½£¬ÇëµÇÂ½ºó·ÃÎÊ";
			request.setAttribute("error", msg);
			
			request.getRequestDispatcher("/Pages/Login.jsp").forward(request, response);
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
