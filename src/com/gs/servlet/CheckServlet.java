package com.gs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gs.bean.DeptBean;
import com.gs.bean.UserBean;
import com.gs.dao.CheckDao;


public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String param = request.getParameter("param");
		if(param==null)
			param="";
		else if(param.equals("checkuser")) {
			checkuser(request,response);
		}
	}

	private void checkuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sex = "Å®";
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		String ucode = user.getUsercode();
		CheckDao dao = new CheckDao();
		UserBean user1 = dao.userselect(ucode);		
		DeptBean dept = dao.deptselect(user1.getDeptid());
		if(user1.getSex().equals("1")) {
			sex = "ÄÐ";
		}
		String ucode1 = user.getBoss();
		UserBean boss = dao.bossselect(ucode1);
		request.setAttribute("user1", user1);
		request.setAttribute("dept", dept);
		request.setAttribute("sex", sex);
		request.setAttribute("boss", boss);
		request.getRequestDispatcher("CheckUser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
