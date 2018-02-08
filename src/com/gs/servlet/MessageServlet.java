package com.gs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gs.bean.MessageBean;
import com.gs.bean.UserBean;
import com.gs.dao.MessageDao;
import com.gs.dao.UserDao;
import com.gs.page.PageSQL;
import com.gs.page.PageUtil;


public class MessageServlet extends HttpServlet {
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
		UserBean user=(UserBean) session.getAttribute("user");
		String usercode;
		if(user==null)
			usercode="guest";
		else
			usercode=user.getUsercode();
		String receiver = request.getParameter("receiver");
		String content = request.getParameter("content");
		String sendtime = request.getParameter("sendtime");
		MessageBean message = new MessageBean();
		message.setSender(usercode);
		message.setReceiver(receiver);
		message.setContent(content);
		message.setSendtime(sendtime);
		MessageDao dao = new MessageDao();
		dao.add(message);
		this.pageselect(request,response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		MessageDao dao = new MessageDao();
		dao.delete(Integer.parseInt(id));
		this.pageselect(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String receiver = request.getParameter("receiver");
		String content = request.getParameter("content");
		String sendtime = request.getParameter("sendtime");
		String id = request.getParameter("id");
		MessageBean message = new MessageBean();
		message.setReceiver(receiver);
		message.setContent(content);
		message.setSendtime(sendtime);
		message.setId(Integer.parseInt(id));
		MessageDao dao = new MessageDao();
		dao.update(message);
		this.pageselect(request, response);
	}


	private void pageselect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String receiver = request.getParameter("receive");
		String curPageStr = request.getParameter("curPage");
		int curPage;
		if(curPageStr==null||curPageStr.equals(""))
			curPage = 1;
		else
		  curPage = Integer.parseInt(curPageStr);
		PageUtil util = new PageUtil();
		util.setCurPage(curPage);
		String wheresql="";
		if(receiver!=null&&!receiver.equals(""))
			wheresql = " where receiver='"+receiver+"'";
		util.setItemCount(PageSQL.getCount("t_message", wheresql));
		util.setUrl("/MessageServlet?param=pageselect");
		MessageDao dao  = new MessageDao();
		List dataList = dao.pageSelect(receiver, util.getBeg(), util.getPageSize());
		request.setAttribute("dataList", dataList);
		request.setAttribute("util", util);
		request.getRequestDispatcher("message/Message.jsp").forward(request, response);
		
	}

	private void AU(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("sender");
		if(id!=null&&!id.equals("")){
			MessageDao dao = new MessageDao();
			UserDao dao1 = new UserDao();
			List userList = dao1.select(null, null);
			MessageBean message = dao.selectById(Integer.parseInt(id));
			request.setAttribute("message", message);
			request.setAttribute("userList", userList);
			request.setAttribute("p", "update");
		}else {
			UserDao dao1 = new UserDao();
			List userList = dao1.select(null, null);
			request.setAttribute("userList", userList);
			request.setAttribute("p", "add");
		}
		request.getRequestDispatcher("message/MessageAU.jsp").forward(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
