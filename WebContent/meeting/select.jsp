<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <% String path=request.getContextPath();  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="<%=path %>/css/blue/styles.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/form.js"></script>
</head>
<body class="RightFrame" >
<form method="post">
<input type="hidden" name="pageDirection" value="" id="pageDirection"/>

<table height="30" cellspacing="0" cellpadding="0" width="98%" 
            align="center" background="/images/bg07.jpg" border="0" class="weizhi">
      <tbody>
       
         <tr>
    <td class="wz_left">&nbsp;</td>
    <td nowrap="nowrap" class="wz_middle" >会议公告管理</td>
    <td class="wz_right">&nbsp;</td>
  </tr>
      </tbody>
    </table>
 
<div id="main">
  <div id="top">
    <table  width="98%" border="0" align="center" cellpadding="4" cellspacing="1" class="datatable" >
      <tr>
        <td width="12%">公告标题:</td>
        <td width="17%">
       <input type="text" name="title1">
        </td>
		<td width="12%"></td>
        <td width="17%">
        </td>
       
        </tr>
        <tr>
          <td  colspan="6"> 
            <input type="button" value="查询"  class="bt" onClick="doSubmit('MeetingNoticeServlet?param=selectBy')"/>
            <input type="button"  value="增加"  class="bt" onClick="doSubmit('MeetingNoticeServlet?param=AU_2in1&type=2')"/>
          </td>
      </tr>
    </table>
  </div>
<div id="center">
 
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" class="datatable1" >
          <tr>
          
           <th width="8%" class="listTableHead">标题</th>
            <th width="8%" class="listTableHead">内容</th>
           <th width="8%" class="listTableHead">发布时间</th>
            <th width="8%" class="listTableHead">操作</th> 
          </tr>
       <c:forEach items="${datalist }" var="notice">
         <tr>
            <td class="listTableLine1" >${notice.title }</td>
            <td class="listTableLine1" >${notice.content}</td>
            <td class="listTableLine1" >${notice.sendtime }</td>
			 <td class="listTableLine1" >
			 <a  style="cursor:pointer;" href="<%=path %>/MeetingNoticeServlet?param=delete&id=${notice.id}&type=2 "><u>删除</u></a>
			 <a  style="cursor:pointer;" href="<%=path %>/MeetingNoticeServlet?param=AU_2in1&id=${notice.id }&type=2"><u>修改</u></a>
			 </td>
          </tr>
               
      </c:forEach> 
  
 
</table>
 
<%@include file="../page/page.jsp"  %>
  </div>
</div> 
 
</form>
</body>

</html>