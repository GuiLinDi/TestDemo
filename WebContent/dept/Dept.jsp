<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <% String path=request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path %>/css/blue/styles.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"  src="${pageContext.request.contextPath }/js/form.js"></script>
<title>Insert title here</title>
</head>
 <body class="RightFrame" >
<form action="<%=path %>/DeptServlet?param=check" method="post">
<input type="hidden" name="pageDirection" value="" id="pageDirection"/>
<table height="30" cellspacing="0" cellpadding="0" width="98%" 
            align="center" background="/images/bg07.jpg" border="0" class="weizhi">
      <tbody>
       
         <tr>
    <td class="wz_left">&nbsp;</td>
    <td nowrap="nowrap" class="wz_middle" >部门管理</td>
    <td class="wz_right">&nbsp;</td>
  </tr>
      </tbody>
    </table>
 
<div id="main">
  <div id="top">
    <table  width="98%" border="0" align="center" cellpadding="4" cellspacing="1" class="datatable" >
      <tr>
        <td width="12%">部门编号:</td>
        <td width="17%">
       <input type="text" name="deptid2" value="" id="manName"/>
        </td>
		<td width="12%">部门名称:</td>
        <td width="17%">
        <input type="text" name="deptname2" value="" id="manName"/>
 </td>
       
        </tr>
        <tr>
          <td  colspan="6"> 
        <input type="submit" value="查询"  class="bt" />
        <input type="button"  value="增加"  class="bt" onClick="doSubmit('dept/AddDept.jsp')"/>
      </td>
      </tr>
    </table>
  </div>
<div id="center">
 
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" class="datatable1" >
          <tr>
          
           <th width="8%" class="listTableHead">部门编号</th>
            <th width="8%" class="listTableHead">部门名称</th>
           <th width="8%" class="listTableHead">备注</th>
           <th width="8%" class="listTableHead">操作</th>
            
          </tr>
  <c:forEach items="${dateList}" var="dept">
		<tr>
           
            <td class="listTableLine1" >${dept.deptid }</td>
            <td class="listTableLine1" >${dept.deptname }</td>
            <td class="listTableLine1" >${dept.remark }</td>
          
			 <td class="listTableLine1" >
			 <a  href="<%=path %>/DeptServlet?param=delete&deptid=${dept.deptid}"><u>删除</u></a>
			 <a href ="<%=path %>/DeptServlet?param=edit&deptid=${dept.deptid}">修改</a>
			 </td>
          </tr>
 </c:forEach>
</table>
 
 
  </div>
</div> 
 
</form>
</body>
</html>
