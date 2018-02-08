package com.gs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.bean.UserBean;
import com.gs.dao.DeptDao;
import com.gs.dao.MessageDao;
import com.gs.dao.UserDao;
import com.gs.page.PageSQL;
import com.gs.page.PageUtil;



public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String param = request.getParameter("param");
		if(param==null)
			param="";
		else if(param.equals("add")) {
			add(request,response);
		}else if(param.equals("delete")){
			delete(request,response);
		}else if(param.equals("update")) {
			update(request,response);
		}else if(param.equals("pageselect")){
			pageselect(request,response);
		}else if(param.equals("AU")) {
			AU(request,response);
		}
	}
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usercode = request.getParameter("usercode");
		String deptid = request.getParameter("deptid");
		System.out.println(deptid);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String job = request.getParameter("job");
		String sex = request.getParameter("sex");
		String boss = request.getParameter("boss");
		int deptid1 = Integer.parseInt(deptid);
		System.out.println(deptid1);
		UserBean user = new UserBean(usercode,deptid1,username,password,email,telephone,job,sex,boss);
		UserDao dao = new UserDao();
		
		dao.add(user);
		this.pageselect(request,response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("ucodee");
		UserDao dao = new UserDao();
		dao.delete(id);
		this.pageselect(request,response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usercode = request.getParameter("usercode");
		String deptid = request.getParameter("deptid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String job = request.getParameter("job");
		String sex = request.getParameter("sex");
		String boss = request.getParameter("boss");
		UserBean user = new UserBean();
		user.setUsercode(usercode);
		user.setDeptid(Integer.parseInt(deptid));
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setTelephone(telephone);
		user.setJob(job);
		user.setSex(sex);
		user.setBoss(boss);
		UserDao dao = new UserDao();
		dao.update(user);
		this.pageselect(request,response);
	}

	private void pageselect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ucode = request.getParameter("ucode");
		String uname = request.getParameter("uname");
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
		if(uname!=null&&!uname.equals(""))
			wheresql = " where username='"+uname+"'";
		util.setItemCount(PageSQL.getCount("t_users", wheresql));
		util.setUrl("/UserServlet?param=pageselect");
		UserDao dao  = new UserDao();
		List datalist = dao.pageSelect(ucode,uname,util.getBeg(), util.getPageSize());
		request.setAttribute("dataList", datalist);
		request.setAttribute("util", util);
		request.getRequestDispatcher("user/User.jsp").forward(request, response);
		
	}

	private void AU(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String id = request.getParameter("ucode");
		if(id!=null&&!id.equals("")) {
			UserDao dao = new UserDao();
			List userList = dao.select(null, null);
			DeptDao dao1 = new DeptDao();
			List deptList = dao1.select(null,null);
			UserBean user = dao.selectById(id);
			request.setAttribute("user", user);
			request.setAttribute("userList", userList);
			request.setAttribute("deptList", deptList);
			request.setAttribute("p", "update");
			request.getRequestDispatcher("user/UserAU.jsp").forward(request, response);
		}else {
			UserDao dao = new UserDao();
			List userList = dao.select(null, null);
			DeptDao dao1 = new DeptDao();
			List deptList = dao1.select(null,null);
			request.setAttribute("userList", userList);
			request.setAttribute("deptList", deptList);
			request.setAttribute("p", "add");
			request.getRequestDispatcher("user/addUser.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
