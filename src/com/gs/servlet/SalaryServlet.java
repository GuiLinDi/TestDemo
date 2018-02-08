package com.gs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gs.bean.MessageBean;
import com.gs.bean.SalaryBean;
import com.gs.bean.UserBean;
import com.gs.dao.MessageDao;
import com.gs.dao.SalaryDao;
import com.gs.dao.UserDao;
import com.gs.page.PageSQL;
import com.gs.page.PageUtil;


public class SalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String param = request.getParameter("param");
		if(param==null)
			param="";
		else if(param.equals("add")) {
			add(request,response);
		}else if(param.equals("delete")) {
			delete(request,response);
		}else if(param.equals("update")){
			update(request,response);
		}else if(param.equals("AU")) {
			AU(request,response);
		}else if(param.equals("pageselect")) {
			pageselect(request,response);
		}
	}


	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		SalaryBean user=(SalaryBean) session.getAttribute("user");
		String usercode;
		if(user==null)
			usercode="guest";
		else
			usercode=user.getUsercode();
		String usercod = request.getParameter("usercod");
		String base = request.getParameter("base");
		String bonus = request.getParameter("bonus");
		String takeoff = request.getParameter("takeoff");
		String safe = request.getParameter("safe");
		String other = request.getParameter("other");
		SalaryBean salary = new SalaryBean();
		salary.setUsercode(usercod);
		salary.setBase(Float.parseFloat(base));
		salary.setBonus(Float.parseFloat(bonus));
		salary.setTakeoff(Float.parseFloat(takeoff));
		salary.setSafe(Float.parseFloat(safe));
		salary.setOther(Float.parseFloat(other));
		SalaryDao dao = new SalaryDao();
		dao.add(salary);
		this.pageselect(request,response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		SalaryDao dao = new SalaryDao();
		dao.delete(Integer.parseInt(id));
		this.pageselect(request, response);
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usercod = request.getParameter("usercod");
		String base = request.getParameter("base");
		String bonus = request.getParameter("bonus");
		String takeoff = request.getParameter("takeoff");
		String safe = request.getParameter("safe");
		String other = request.getParameter("other");
		String id = request.getParameter("id");
		SalaryBean salary = new SalaryBean();
		salary.setUsercode(usercod);
		salary.setBase(Float.parseFloat(base));
		salary.setBonus(Float.parseFloat(bonus));
		salary.setTakeoff(Float.parseFloat(takeoff));
		salary.setSafe(Float.parseFloat(safe));
		salary.setOther(Float.parseFloat(other));
		salary.setId(Integer.parseInt(id));
		SalaryDao dao = new SalaryDao();
		dao.update(salary);
		this.pageselect(request, response);
	}
	
	private void pageselect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ucode = request.getParameter("ucode");
		String curPageStr = request.getParameter("curPage");
		int curPage;
		if(curPageStr==null||curPageStr.equals(""))
			curPage = 1;
		else
		  curPage = Integer.parseInt(curPageStr);
		PageUtil util = new PageUtil();
		util.setCurPage(curPage);
		String wheresql="";
		if(ucode!=null&&!ucode.equals(""))
			wheresql = " where usercode='"+ucode+"'";
		util.setItemCount(PageSQL.getCount("t_salary", wheresql));
		util.setUrl("/MessageServlet?param=pageselect");
		SalaryDao dao  = new SalaryDao();
		List dataList = dao.pageSelect(ucode, util.getBeg(), util.getPageSize());
		request.setAttribute("dataList", dataList);
		request.setAttribute("util", util);
		request.getRequestDispatcher("salary/salary.jsp").forward(request, response);
	}

	private void AU(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("sid");
		if(id!=null&&!id.equals("")){
			SalaryDao dao = new SalaryDao();
			UserDao dao1 = new UserDao();
			List userList = dao1.select(null, null);
			SalaryBean salary = dao.selectById(Integer.parseInt(id));
			request.setAttribute("salary", salary);
			request.setAttribute("userList", userList);
			request.setAttribute("p", "update");
		}else {
			UserDao dao = new UserDao();
			List userList = dao.select(null, null);
			request.setAttribute("userList", userList);
			request.setAttribute("p", "add");
		}
		request.getRequestDispatcher("salary/SalaryAU.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
