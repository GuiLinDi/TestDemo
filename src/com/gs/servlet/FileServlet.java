package com.gs.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.gs.bean.UserBean;
import com.gs.bean.upFile;
import com.gs.dao.FileDao;


public class FileServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("param");
		if(param==null) param="";
		if(param.equals("add")){
			add(request, response);
		}else if(param.equals("download")){
			this.download(request, response);
		}else if(param.equals("select")){
			this.doselect(request, response);
		}else if("delete".equals(param)){
			dodelete(request, response);
		}
	}
	private void doselect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		FileDao fd = new FileDao();
		List datalist = fd.select();
		request.setAttribute("datalist",datalist);
        request.getRequestDispatcher("file/file.jsp").forward(request, response);
	}
	//上传文件
	private String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String savePath = this.getServletContext().getRealPath("/upload");
		System.out.println("savePath-------"+savePath);
		File saveFile = new File(savePath);
		//开始上传文件
		//FileItem对象工厂,可以设置存放临时文件目录
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//上传文件解析器.将数据封装到FileItem.
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");
		String filename="";//文件名
		String fileinfo = "";//用于重命名
		String fn = "";
		InputStream in = null;//输入流
		OutputStream out = null;//输出流
		int len=0;//从原文件中读取的个数
		try {
			//用来封装表单提交的文件数据
			FileItem fi = upload.parseRequest(request).get(0);
			filename = fi.getName();
			System.out.println("filename====="+filename);
			
			fn = filename.substring(filename.lastIndexOf("\\")+1);//获取上传的文件名
			System.out.println(fn);
			
			//String saveFilename = savePath+filename.substring(filename.lastIndexOf("\\"));//保存文件的完整路径加文件名
			fileinfo = getfileinfo();//获取info信息
			String saveFilename = savePath +"\\" + fileinfo +filename.substring(filename.lastIndexOf("."));//加入info信息，重新命名文件
			System.out.println(saveFilename);			
			in = fi.getInputStream();
			out = new FileOutputStream(saveFilename);
			byte data[] = new byte[1024];
			while((len=in.read(data))>0){
				out.write(data);
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}finally{
			if(in!=null) in.close();
			if(out!=null) out.close();
		}
		doadd(request, response, fn,fileinfo);
		this.doselect(request, response);
		return savePath;
	}
	//写入数据库
	private void doadd(HttpServletRequest request, HttpServletResponse response,String fn,String fileinfo){
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		String filename = fn;
		String fileuper = user.getUsercode();
		String filetime = this.getdate();
		upFile uf = new upFile(fn,fileuper,filetime,fileinfo);
		FileDao fd = new FileDao();
		fd.add(uf);
	}
	private String getdate(){
		Calendar cl =  Calendar.getInstance();
		Date date = cl.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	private String getfileinfo(){
		String fileinfo = null;
		Calendar cl =  Calendar.getInstance();
		Date date = cl.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		int rd = (int) (Math.random()*1000000);
		String subrd = String.valueOf(rd);
		fileinfo = sdf.format(date)+""+subrd;
		return fileinfo;
	}

   public void download(HttpServletRequest request, HttpServletResponse response) throws IOException{
	   //得到要下载的文件名
	   String fileinfo = request.getParameter("fileinfo");
       String fileName = getformat(fileinfo);
       fileName = new String(fileName.getBytes("iso8859-1"),"UTF-8");
       fileName = fileinfo+fileName;
       System.out.println(fileName);
      
       //上传的文件都是保存在/upload目录下的子目录当中
       //通过文件名找出文件的所在目录
       String path = this.getServletContext().getRealPath("/upload");
       System.out.println("文件所在位置(path):"+path);
       //得到要下载的文件
       File file = new File(path + "\\" + fileName);
       //处理文件名
       String realname = fileName;
       System.out.println("真正的文件名："+realname);
       //设置响应头，控制浏览器下载该文件
       response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
       //读取要下载的文件，保存到文件输入流
       FileInputStream in = new FileInputStream(path + "\\" + fileName);
       //创建输出流
       OutputStream out = response.getOutputStream();
       //创建缓冲区
       byte buffer[] = new byte[1024];
      int len = 0;
      //循环将输入流中的内容读取到缓冲区当中
       while((len=in.read(buffer))>0){
      //输出缓冲区的内容到浏览器，实现文件下载
           out.write(buffer, 0, len);
       }
       //关闭文件输入流
       in.close();
       //关闭输出流
       out.close();
   }
   //文件删除
   public void dodelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	   String path = this.getServletContext().getRealPath("upload");
	   String fileinfo = request.getParameter("fileinfo");
	   String filename = getformat(fileinfo);
	   System.out.println("数据库查询到的文件格式："+filename);
	   filename = new String(filename.getBytes("iso8859-1"),"UTF-8");
       filename = fileinfo+filename;
	   FileDao fd = new FileDao();
	   fd.delete(fileinfo);
	   String pf = path + "\\" +filename;
	   File file = new File(pf);
	   System.out.println(pf);
	   file.delete();
	   this.doselect(request, response);
   }
   //获取文件格式
   private String getformat(String fileinfo){
	   FileDao fd = new FileDao();
	   String filename = fd.selectformat(fileinfo);
	   String fileformat = filename.substring(filename.lastIndexOf("."));
	   return fileformat;
   }
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
