package com.gs.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gs.bean.ContacterBean;
import com.gs.bean.NoticeBean;
import com.gs.bean.UserBean;
import com.gs.dao.NoticeDao;
import com.gs.page.PageSQL;
import com.gs.page.PageUtil;

public class MeetingNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
          NoticeDao dao = new NoticeDao();

		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		  String param=request.getParameter("param");
		   if(param==null) param="";
	   		  else if(param.equals("add")) {
	   			  add(request,response);
	   		  }else if(param.equals("update")) {
	   			 update(request,response);
	   		  }else if(param.equals("pageSelect")) {
	   			 select(request,response);
	   		  }else if(param.equals("AU_2in1")) {
	   			AU_2in1(request,response);
	   		  }else if(param.equals("delete")) {
	   			delete(request,response);
	   		  }else if(param.equals("selectBy")) {
	   			  select(request,response);
	   		  }else if(param.equals("update")) {
	   			  update(request,response);
	   		  }
	}
	private void AU_2in1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		if(id!=null) {
		 NoticeBean notice=dao.selectById(id);
		 request.setAttribute("notice", notice);
		 request.setAttribute("p", "update");
		}
		else {
		request.setAttribute("p", "add");
		}
		request.getRequestDispatcher("meeting/AU_2in1.jsp").forward(request, response);
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id");
		String title =request.getParameter("title");
		String content =request.getParameter("content");
		String sendtime =request.getParameter("sendtime");
		NoticeBean notice=new NoticeBean();
		notice.setId(Integer.parseInt(id));
		notice.setTitle(title);
		notice.setContent(content);
		notice.setSendtime(sendtime);
		dao.update(notice);
		this.select(request,response);
	}
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeBean notice=new NoticeBean();
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String sendtime=request.getParameter("sendtime");
		HttpSession session=request.getSession();
		UserBean user=(UserBean)session.getAttribute("usercode");
		String usercode;
		if(user==null)
			usercode="guest";
		else
			usercode=user.getUsercode();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setSendtime(sendtime);
		notice.setAuthor(usercode);
		notice.setType("2");
		dao.add(notice);
		this.select(request,response);
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id");
		dao.delete(id);
		this.select(request,response);
	}
	private void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title1");
		String type = request.getParameter("type");
		String curPageStr = request.getParameter("curPage");
		int curPage;
		if(curPageStr==null||curPageStr.equals(""))
			curPage = 1;
		else
		  curPage = Integer.parseInt(curPageStr);
		
		PageUtil util = new PageUtil();
		util.setCurPage(curPage);
		String wheresql="";
		if(type!=null&&!type.equals(""))
			wheresql = " where type='"+type+"' ";
		if(title!=null&&!title.equals(""))
			wheresql = " where title='"+title+"' ";
		util.setItemCount(PageSQL.getCount("t_notice",wheresql));
		util.setUrl("/MeetingNoticeServlet?param=pageSelect&type=2");
		NoticeDao dao  = new NoticeDao();
		List list = dao.pageSelect(title,type, util.getBeg(), util.getPageSize());
		request.setAttribute("datalist", list);
		request.setAttribute("util", util);
		request.getRequestDispatcher("meeting/select.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
