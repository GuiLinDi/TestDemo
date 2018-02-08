<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="<%=path %>/css/blue/styles.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/form.js"></script>
</head>
 <body class="RightFrame" >
<form action="<%=path %>/MessageServlet?param=pageselect" method="post">
<input type="hidden" name="pageDirection" value="" id="pageDirection"/>
<table height="30" cellspacing="0" cellpadding="0" width="98%" 
            align="center" background="/images/bg07.jpg" border="0" class="weizhi">
      <tbody>
       
         <tr>
    <td class="wz_left">&nbsp;</td>
    <td nowrap="nowrap" class="wz_middle" >短消息管理</td>
    <td class="wz_right">&nbsp;</td>
  </tr>
      </tbody>
    </table>
 
<div id="main">
  <div id="top">
    <table  width="98%" border="0" align="center" cellpadding="4" cellspacing="1" class="datatable" >
      <tr>
        <td width="12%">接收者:</td>
        <td width="17%">
       <input type="text" name="receive" value="" id="receive"/>
        </td>
		<td width="12%"></td>
        <td width="17%">
        </td>
       
        </tr>
        <tr>
          <td  colspan="6"> 
        <input type="submit" value="查询"  class="bt"/>
        <input type="button"  value="新建"  class="bt" onClick="doSubmit('MessageServlet?param=AU')"/>
      </td>
      </tr>
    </table>
  </div>
<div id="center">
 
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" class="datatable1" >
          <tr>
          
            <th width="8%" class="listTableHead">接收者</th>
           <th width="8%" class="listTableHead">内容</th>
            <th width="8%" class="listTableHead">接收时间</th> 
            <th width="8%" class="listTableHead">操作</th> 
          </tr>
         
		<c:forEach items="${dataList }" var="message">
		<tr>
           
            <td class="listTableLine1" >${message.receiver }</td>
            <td class="listTableLine1" >${message.content }</td>
            <td class="listTableLine1" >${message.sendtime }</td>
			 <td class="listTableLine1" >
			 <a  style="cursor:pointer;" href="<%=path %>/MessageServlet?param=delete&id=${message.id}"><u>删除</u></a>
			 <a  style="cursor:pointer;" href="<%=path %>/MessageServlet?param=AU&sender=${message.id}"><u>修改</u></a>
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