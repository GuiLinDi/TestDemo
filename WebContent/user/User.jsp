<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>职工管理</title>
<link href="<%=path %>/css/blue/styles.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/form.js"></script>
</head>
<body class="RightFrame" >
<form action="<%=path %>/UserServlet?param=pageselect" method="post">
<input type="hidden" name="pageDirection" value="" id="pageDirection"/>
<table height="30" cellspacing="0" cellpadding="0" width="98%" 
            align="center" background="/images/bg07.jpg" border="0" class="weizhi">
      <tbody>
       
         <tr>
    <td class="wz_left">&nbsp;</td>
    <td nowrap="nowrap" class="wz_middle" >职工管理</td>
    <td class="wz_right">&nbsp;</td>
  </tr>
      </tbody>
    </table>
 
<div id="main">
  <div id="top">
    <table  width="98%" border="0" align="center" cellpadding="4" cellspacing="1" class="datatable" >
      <tr>
        <td width="12%">职工账号:</td>
        <td width="17%">
       <input type="text" name="ucode" value="" id="usercode"/>
        </td>
		<td width="12%">职工姓名:</td>
        <td width="17%">
        <input type="text" name="uname" value="" id="username"/>
        </td>
       
        </tr>
        <tr>
          <td  colspan="6"> 
        <input type="submit" value="查询"  class="bt" />
        <input type="button"  value="增加"  class="bt" onClick="doSubmit('UserServlet?param=AU')"/>
      </td>
      </tr>
    </table>
  </div>
<div id="center">
 
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" class="datatable1" >
          <tr>
          
            <th width="8%" class="listTableHead">职工账号</th>
            <th width="8%" class="listTableHead">部门</th>
            <th width="8%" class="listTableHead">职工名称</th>
            <th width="8%" class="listTableHead">密码</th>
            <th width="8%" class="listTableHead">邮箱</th> 
			<th width="8%" class="listTableHead">电话</th>
            <th width="8%" class="listTableHead">职位</th> 
            <th width="8%" class="listTableHead">性别</th> 
            <th width="8%" class="listTableHead">上司</th> 
            <th width="8%" class="listTableHead">操作</th> 
          </tr>
       
       <c:forEach items="${dataList }" var="user">
		<tr>
           
            <td class="listTableLine1" >${user.usercode }</td>
            <td class="listTableLine1" >${user.deptid }</td>
            <td class="listTableLine1" >${user.username }</td>
            <td class="listTableLine1" >${user.password }</td>
            <td class="listTableLine1" >${user.email }</td>
            <td class="listTableLine1" >${user.telephone }</td>
            <td class="listTableLine1" >${user.job }</td>
            <td class="listTableLine1" >${user.sex }</td>
            <td class="listTableLine1" >${user.boss }</td>
			 <td class="listTableLine1" >
			 <a  style="cursor:pointer;" href="<%=path %>/UserServlet?param=delete&ucodee=${user.usercode}"><u>删除</u></a>
			 <a  style="cursor:pointer;" href="<%=path %>/UserServlet?param=AU&ucode=${user.usercode}"><u>修改</u></a>
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