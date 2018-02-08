package com.gs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gs.bean.UserBean;
import com.gs.dao.IndexDao;


public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   IndexDao dao=new IndexDao();
	   HttpSession session=request.getSession();
	   UserBean user=(UserBean)session.getAttribute("user");
	   String usercode;
	   if(user==null)
		   usercode="guest";
	   else
		   usercode=user.getUsercode();
	   List messagelist=dao.selectMessage(usercode);
	   List schedulelist=dao.selectSchedule(usercode);
	   List loglist=dao.selectLog(usercode);
	   List noticelist=dao.selectMeeting();
	   request.setAttribute("messagelist", messagelist);
	   request.setAttribute("schedulelist",schedulelist);
	   request.setAttribute("loglist", loglist);
	   request.setAttribute("noticelist", noticelist);
	   request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
