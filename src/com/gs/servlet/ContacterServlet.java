package com.gs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gs.bean.ContacterBean;
import com.gs.bean.UserBean;
import com.gs.dao.ContacterDao;


public class ContacterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
				ContacterDao dao=new ContacterDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		       request.setCharacterEncoding("utf-8");
		       response.setContentType("text/html;charset=utf-8");
		     String param=request.getParameter("param");
	           if(param==null) param="";
	   		  else if(param.equals("add")) {
	   			  add(request,response);
	   		  }else if(param.equals("update")) {
	   			  update(request,response);
	   		  }else if(param.equals("select")) {
	   			 select(request,response);
	   		  }else if(param.equals("AU_2in1")) {
	   			AU_2in1(request,response);
	   		  }else if(param.equals("delete")) {
	   			  delete(request,response);
	   		  }else if(param.equals("selectById")) {
	   			  selectById2(request,response);
	   		  }else if(param.equals("check")){
	  			check(request, response);
	  		}
	}
	private void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String namees = new String(request.getParameter("namees").getBytes("ISO-8859-1"),("UTF-8"));
		ContacterDao dao = new ContacterDao();
		List list=dao.select(null, namees);
		PrintWriter out = response.getWriter();
		if(list==null||list.size()==0){
			out.print("yes");
		}else
			out.print("no");
	}

	private void AU_2in1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		if(id!=null) {
		ContacterBean contacter=dao.selectById(id);
		request.setAttribute("contacter", contacter);
		request.setAttribute("p", "update");
		}
		else {
		request.setAttribute("p", "add");
		}
		request.getRequestDispatcher("contacter/AU_2in1.jsp").forward(request, response);
	}
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String namees =request.getParameter("namees");
		String sex =request.getParameter("sex");
		String telephone=request.getParameter("telephone");
		String qq =request.getParameter("qq");
		String company =request.getParameter("company");
		String address =request.getParameter("address");
		String post =request.getParameter("post");
		HttpSession session=request.getSession();
		UserBean user=(UserBean)session.getAttribute("user");
		String usercode;
		if(user==null)
			usercode="guest";
		else
			usercode=user.getUsercode();
		ContacterBean contacter=new ContacterBean();
		contacter.setUsercode(usercode);
		contacter.setNamees(namees);
		contacter.setSex(sex);
		contacter.setTelephone(telephone);
		contacter.setQq(qq);
		contacter.setCompany(company);
		contacter.setAddress(address);
		contacter.setPost(post);
		dao.add(contacter);
		this.select(request,response);
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id");
		dao.delete(id);
		this.select(request,response);
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id");
		String namees =request.getParameter("namees");
		String sex =request.getParameter("sex");
		String telephone=request.getParameter("telephone");
		String qq =request.getParameter("qq");
		String company =request.getParameter("company");
		String address =request.getParameter("address");
		String post =request.getParameter("post");
		ContacterBean contacter=new ContacterBean();
		contacter.setId(Integer.parseInt(id));
		contacter.setNamees(namees);
		contacter.setSex(sex);
		contacter.setTelephone(telephone);
		contacter.setQq(qq);
		contacter.setCompany(company);
		contacter.setAddress(address);
		contacter.setPost(post);
		dao.update(contacter);
		this.select(request,response);
	}
	private void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List datalist=new ArrayList();
		HttpSession session=request.getSession();
		UserBean user=(UserBean)session.getAttribute("user");
		String usercode;
		if(user==null)
			usercode="guest";
		else
			usercode=user.getUsercode();
		datalist=dao.select(usercode,null);
		request.setAttribute("datalist", datalist);
		request.getRequestDispatcher("contacter/select.jsp").forward(request,response);
	}
	private void selectById2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List datalist=new ArrayList();
		String id=request.getParameter("namees");
		datalist=dao.select(null,id);
		request.setAttribute("datalist", datalist);
		request.getRequestDispatcher("contacter/select.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          this.doGet(request, response);
	}

}
