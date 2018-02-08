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
	//�ϴ��ļ�
	private String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String savePath = this.getServletContext().getRealPath("/upload");
		System.out.println("savePath-------"+savePath);
		File saveFile = new File(savePath);
		//��ʼ�ϴ��ļ�
		//FileItem���󹤳�,�������ô����ʱ�ļ�Ŀ¼
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//�ϴ��ļ�������.�����ݷ�װ��FileItem.
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");
		String filename="";//�ļ���
		String fileinfo = "";//����������
		String fn = "";
		InputStream in = null;//������
		OutputStream out = null;//�����
		int len=0;//��ԭ�ļ��ж�ȡ�ĸ���
		try {
			//������װ���ύ���ļ�����
			FileItem fi = upload.parseRequest(request).get(0);
			filename = fi.getName();
			System.out.println("filename====="+filename);
			
			fn = filename.substring(filename.lastIndexOf("\\")+1);//��ȡ�ϴ����ļ���
			System.out.println(fn);
			
			//String saveFilename = savePath+filename.substring(filename.lastIndexOf("\\"));//�����ļ�������·�����ļ���
			fileinfo = getfileinfo();//��ȡinfo��Ϣ
			String saveFilename = savePath +"\\" + fileinfo +filename.substring(filename.lastIndexOf("."));//����info��Ϣ�����������ļ�
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
	//д�����ݿ�
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
	   //�õ�Ҫ���ص��ļ���
	   String fileinfo = request.getParameter("fileinfo");
       String fileName = getformat(fileinfo);
       fileName = new String(fileName.getBytes("iso8859-1"),"UTF-8");
       fileName = fileinfo+fileName;
       System.out.println(fileName);
      
       //�ϴ����ļ����Ǳ�����/uploadĿ¼�µ���Ŀ¼����
       //ͨ���ļ����ҳ��ļ�������Ŀ¼
       String path = this.getServletContext().getRealPath("/upload");
       System.out.println("�ļ�����λ��(path):"+path);
       //�õ�Ҫ���ص��ļ�
       File file = new File(path + "\\" + fileName);
       //�����ļ���
       String realname = fileName;
       System.out.println("�������ļ�����"+realname);
       //������Ӧͷ��������������ظ��ļ�
       response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
       //��ȡҪ���ص��ļ������浽�ļ�������
       FileInputStream in = new FileInputStream(path + "\\" + fileName);
       //���������
       OutputStream out = response.getOutputStream();
       //����������
       byte buffer[] = new byte[1024];
      int len = 0;
      //ѭ�����������е����ݶ�ȡ������������
       while((len=in.read(buffer))>0){
      //��������������ݵ��������ʵ���ļ�����
           out.write(buffer, 0, len);
       }
       //�ر��ļ�������
       in.close();
       //�ر������
       out.close();
   }
   //�ļ�ɾ��
   public void dodelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	   String path = this.getServletContext().getRealPath("upload");
	   String fileinfo = request.getParameter("fileinfo");
	   String filename = getformat(fileinfo);
	   System.out.println("���ݿ��ѯ�����ļ���ʽ��"+filename);
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
   //��ȡ�ļ���ʽ
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
