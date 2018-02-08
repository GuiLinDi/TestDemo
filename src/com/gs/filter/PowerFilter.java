package com.gs.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.gs.bean.UserBean;

public class PowerFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String path = req.getServletPath();
		HttpSession session = req.getSession();
		UserBean user = (UserBean)session.getAttribute("user");
		if(path.equals("/UserServlet")||path.equals("/DeptServlet")
				||path.equals("/SalaryServlet")){
			if(user.getDeptid()==1){
				chain.doFilter(request, response);
			}else{
				req.getRequestDispatcher("noPower.jsp").forward(req, response);
			}
		}
		if(path.equals("/NoticeServlet")||path.equals("/MeetingNoticeServlet")){
			if(user.getDeptid()==2){
				chain.doFilter(request, response);
			}else{
				req.getRequestDispatcher("noPower.jsp").forward(req, response);
			}
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
