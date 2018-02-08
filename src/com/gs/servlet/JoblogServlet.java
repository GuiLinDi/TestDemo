package com.gs.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gs.bean.Joblog;
import com.gs.bean.PageBean;
import com.gs.bean.UserBean;
import com.gs.dao.Logdao;
import com.gs.page.PageSQL;



public class JoblogServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String param = request.getParameter("param");
		System.out.println(param);
		if(param.equals("")){
			param = null;
		}
		if("select".equals(param)){
			dopageSelect(request, response);
		}else if("delete".equals(param)){
			dodelete(request, response);
		}else if("add".equals(param)){
			doadd(request, response);
		}else if("selectbyid".equals(param)){
			doselectbyid(request, response);
		}else if("update".equals(param)){
			doupdate(request, response);
		}else if("au".equals(param)){
			doau(request, response);
		}
	}
	private void doadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Joblog jl = new Joblog();
		Logdao ld = new Logdao();
		HttpSession session = request.getSession();	
		UserBean user= (UserBean) session.getAttribute("user");
		//String usercode = request.getParameter("usercode");
		String usercode = user.getUsercode();
		String times = request.getParameter("times");
		String title = request.getParameter("title");
		String contend = request.getParameter("contend");
		String rectime = request.getParameter("rectime");
		String type = request.getParameter("type");
		jl.setUsercode(usercode);
		jl.setTimes(times);
		jl.setTitle(title);
		jl.setContend(contend);
		jl.setRectime(rectime);
		jl.setType("2");
		ld.add(jl);
		this.dopageSelect(request, response);
	}
	private void dodelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String Joblog_id = request.getParameter("Joblog_id");
		Logdao ld = new Logdao();
		ld.delete(Integer.parseInt(Joblog_id));
		this.dopageSelect(request, response);
	}
	private void doselectbyid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String Joblog_id = request.getParameter("Joblog_id");
		Logdao ld = new Logdao();
		Joblog jl = ld.selectbyid(Joblog_id);
		request.setAttribute("jl", jl);
	}
	private void doupdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Joblog jl = new Joblog();
		Logdao ld = new Logdao();
		int Joblog_id = Integer.parseInt(request.getParameter("Joblog_id"));
		HttpSession session = request.getSession();	
		UserBean user= (UserBean) session.getAttribute("user");
		//String usercode = request.getParameter("usercode");
		String usercode = user.getUsercode();
		String times = request.getParameter("times");
		String title = request.getParameter("title");
		String contend = request.getParameter("contend");
		String rectime = request.getParameter("rectime");
		String type = request.getParameter("type");
		jl.setId(Joblog_id);
		jl.setUsercode(usercode);
		jl.setTimes(times);
		jl.setTitle(title);
		jl.setContend(contend);
		jl.setRectime(rectime);
		jl.setType(type);
		ld.update(jl);
		dopageSelect(request, response);
	}
	private void doau(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String usercode = request.getParameter("usercode");
		String Joblog_id = request.getParameter("Joblog_id");
		if(!Joblog_id.equals("")){
			request.setAttribute("p", "update");
			request.setAttribute("Joblog_id", Joblog_id);
			doselectbyid(request, response);
		}else{
			request.setAttribute("p", "add");
		}
		request.getRequestDispatcher("/joblog/add_joblog.jsp").forward(request, response);
	}
	private void dopageSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		UserBean user= (UserBean) session.getAttribute("user");
		//String usercode = request.getParameter("usercode");
		String usercode = user.getUsercode();
		System.out.println("当前用户工号(usercode)："+usercode);
		String curPageStr = request.getParameter("curPage");
		int curPage;
		int ty = 2;//设置查询的类型
		if(curPageStr==null||curPageStr.equals(""))
			curPage = 1;
		else
			curPage = Integer.parseInt(curPageStr);
		PageBean util = new PageBean();
		util.setCurPage(curPage);
		String wheresql=null;
		if(usercode!=null&&!usercode.equals("")){
			wheresql = " where type=2 and usercode='"+usercode+"'";
		}else{
			wheresql = " where type="+ty;
		}
		util.setItemCount(PageSQL.getCount("t_joblog", wheresql));
		util.setUrl("JoblogServlet?param=select");
		Logdao dao  = new Logdao();
		List datalist = dao.pageSelect(usercode, util.getBeg(), util.getPageSize(),ty);
		request.setAttribute("datalist", datalist);
		request.setAttribute("util", util);
		request.setAttribute("usercode", usercode);
		request.getRequestDispatcher("joblog/joblog.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
