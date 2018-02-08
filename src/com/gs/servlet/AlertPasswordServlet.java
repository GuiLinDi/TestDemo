package com.gs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gs.bean.UserBean;
import com.gs.dao.AlertPasswordDao;

public class AlertPasswordServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		String usercode = user.getUsercode();
		String password = user.getPassword();
		String old = req.getParameter("oldpassword");
		String new1 = req.getParameter("newpassword1");
		String new2 = req.getParameter("newpassword2");
		if(!password.equals(old)){
			System.out.println(password);
			System.out.println(old);
			req.setAttribute("msg1", "原密码错误");
			req.getRequestDispatcher("/password/alterpassword.jsp").forward(req, resp);
			return;
		}else if(!new1.equals(new2)){
			req.setAttribute("msg3", "两次密码不正确");
			req.getRequestDispatcher("/password/alterpassword.jsp").forward(req, resp);
			return;
		}else if(password.equals(old)&&new1.equals(new2)){
			AlertPasswordDao apd = new AlertPasswordDao();
			apd.updatepassword(usercode, new1);
			req.setAttribute("msg3", "修改成功");
			req.getRequestDispatcher("/password/alterpassword.jsp").forward(req, resp);
			return;
			
		}else{
			System.out.println("修改失败");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
