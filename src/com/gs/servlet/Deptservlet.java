
package com.gs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.bean.DeptBean;
import com.gs.dao.DeptDao;

public class Deptservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String param = request.getParameter("param");
		if(param==null) param="";
		if(param.equals("add")){
			add(request,response);
		}else if(param.equals("update")){
			update(request,response);
		}else if(param.equals("delete")){
			delete(request,response);
		}else if(param.equals("select")){
			select(request,response);
		}else if(param.equals("edit")){
			edit(request,response);
		}else if(param.equals("check")) {
			select(request,response);
			}
		
	}
	
//	private void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		String deptname=request.getParameter("deptname");
//		DeptDao dao=new DeptDao();
//		boolean f=dao.check(deptname);
//		PrintWriter out=response.getWriter();
//		if(f) {
//			out.println("yes");
//		}else {
//			out.println("no");
//		}
//	}
	private void edit(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException{
		String deptid=request.getParameter("deptid");
		DeptDao dao = new DeptDao();
		DeptBean dept = dao.selectById(Integer.parseInt(deptid));
		request.setAttribute("dept", dept);
		request.getRequestDispatcher("dept/DeptEdit.jsp").forward(request, response);
		this.select(request, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException{
		
		String deptname = request.getParameter("deptname");
		String remark = request.getParameter("remark");
		DeptBean dept = new DeptBean();
		dept.setDeptname(deptname);
		dept.setRemark(remark);
		DeptDao dao = new DeptDao();
		dao.add(dept);
		this.select(request, response);
	}
	

	
	private void update(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException{
		int deptid = Integer.parseInt(request.getParameter("deptid"));
		String deptname = request.getParameter("deptname");
		String remark = request.getParameter("remark");
		DeptBean dept = new DeptBean(deptid,deptname,remark);
		DeptDao dao = new DeptDao();
		dao.update(dept);
		this.select(request, response);
	}
	private void delete(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException{
		String deptid = request.getParameter("deptid");
		DeptDao dao = new DeptDao();
		dao.delete(Integer.parseInt(deptid));
		this.select(request, response);
	}
	
	private void select(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException{
		String deptname=request.getParameter("deptname2");
		String deptid=request.getParameter("deptid2");
		DeptDao dao = new DeptDao();
		List dateList =  dao.select(deptname,deptid);
		request.setAttribute("dateList", dateList);
		request.getRequestDispatcher("dept/Dept.jsp").forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	this.doGet(request, response);
	}

}