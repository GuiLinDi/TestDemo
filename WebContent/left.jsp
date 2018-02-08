<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <% String path=request.getContextPath();  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="css/blue/styles.css" rel="stylesheet" type="text/css" />

</head>
<body  >
<table width="173" height="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
     
    </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        
							
<link href="css/xtree.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/xtree.js"></script>
<script type="text/javascript">
				var menu0= new WebFXTree('在线办公系统','');
				var menu1=new WebFXTreeItem('联系人管理','<%=path %>/ContacterServlet?param=select');
					menu1.target='mainFrame';
				    menu0.add(menu1);
				var menu2=new WebFXTreeItem('公告管理','<%=path %>/NoticeServlet?param=pageSelect&type=1');
					menu2.target='mainFrame';
				    menu0.add(menu2);
			    var menu3=new WebFXTreeItem('会议公告管理','<%=path %>/MeetingNoticeServlet?param=pageSelect&type=2');
					menu3.target='mainFrame';
				    menu0.add(menu3);
				var menu4=new WebFXTreeItem('职员管理','<%=path %>/UserServlet?param=pageselect');
					menu4.target='mainFrame';
				    menu0.add(menu4);
				var menu5=new WebFXTreeItem('短消息管理','<%=path %>/MessageServlet?param=pageselect');
					menu5.target='mainFrame';
				    menu0.add(menu5);
				var menu6=new WebFXTreeItem('日程管理','<%=path %>/ScheduleServlet?param=select');
					menu6.target='mainFrame';
				    menu0.add(menu6);
				var menu7=new WebFXTreeItem('日志管理','<%=path %>/JoblogServlet?param=select');
					menu7.target='mainFrame';
				    menu0.add(menu7);
				var menu8=new WebFXTreeItem('部门管理','<%=path %>/DeptServlet?param=select');
					menu8.target='mainFrame';
				    menu0.add(menu8);
				var menu9=new WebFXTreeItem('文件管理','<%=path %>/FileServlet?param=select');
					menu9.target='mainFrame';
				    menu0.add(menu9);
				var menu10=new WebFXTreeItem('薪资管理','<%=path %>/SalaryServlet?param=pageselect');
					menu10.target='mainFrame';
				    menu0.add(menu10);
			    var menu11=new WebFXTreeItem('查看个人信息','<%=path %>/CheckServlet?param=checkuser');
					menu11.target='mainFrame';
				    menu0.add(menu11);
			    var menu12=new WebFXTreeItem('修改密码','<%=path %>/password/alterpassword.jsp');
					menu12.target='mainFrame';
				    menu0.add(menu12);
								
					document.write(menu0);

	</script>
		
      </table></td>
  </tr>
</table>
</body>

</html>