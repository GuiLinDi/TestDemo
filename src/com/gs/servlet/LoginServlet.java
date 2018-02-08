package com.gs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gs.bean.UserBean;
import com.gs.dao.UserDao;


public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usercode = request.getParameter("usercode");
		String password = request.getParameter("password");
		UserDao dao = new UserDao();
		UserBean user = dao.login(usercode,password);
		if(user!=null&&user.getUsercode()!=null){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.getRequestDispatcher("IndexServlet").forward(request, response);
		}else{
			request.setAttribute("msg", "µÇÂ¼Ê§°Ü£¬ÇëÖØÐÂµÇÂ¼");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
