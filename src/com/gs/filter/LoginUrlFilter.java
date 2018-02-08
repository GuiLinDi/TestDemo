package com.gs.filter;

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

import com.gs.bean.UserBean;

public class LoginUrlFilter implements Filter {


	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
//		System.out.println("----¹ýÂËÆ÷----");
		String servletPath = req.getServletPath();
//		StringBuffer url = req.getRequestURL();
//		String uri = req.getRequestURI();
//		System.out.println(servletPath+"----"+url+"----"+uri);
		HttpSession session = req.getSession();
		UserBean user = (UserBean)session.getAttribute("user");
		if(servletPath.equals("/LoginServlet")){
			chain.doFilter(request, response);
			return;
		}
		if(user==null){
			//Ã»ÓÐµÇÂ½
			req.getRequestDispatcher("Login.jsp").forward(req, res);
		}else{
		
			chain.doFilter(request, response);
		}
		
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}