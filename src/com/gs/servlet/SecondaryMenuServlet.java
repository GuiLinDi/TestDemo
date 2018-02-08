package com.gs.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gs.bean.Joblog;
import com.gs.bean.UserBean;
import com.gs.dao.Logdao;

public class SecondaryMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	        Logdao dao=new Logdao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		  String param=request.getParameter("param");
		 if(param==null)param="";
		 else if(param.equals("more")) {
			 more(request,response);
		 }else if(param.equals("one")) {
			 one(request,response);
		 }

		 
	}

	 private void one(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String id=request.getParameter("id");
		 Joblog jb=dao.selectbyid(id);
		 request.setAttribute("jb", jb);
		 request.getRequestDispatcher("secondarymenu/twoone.jsp").forward(request, response);
		
	}
	
     private void more(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 String type=request.getParameter("type");
		 List datalist =new ArrayList();
		 HttpSession session=request.getSession();
		 UserBean user=(UserBean)session.getAttribute("user");
		 datalist=dao.SecondaryMenuSelect(user.getUsercode(),type );
		 request.setAttribute("datalist", datalist);
		 request.getRequestDispatcher("secondarymenu/twomore.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             this.doGet(request, response);
	}

}
