
<%@ page import = "java.util.*" language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <% String path = request.getContextPath(); %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/css/blue/styles.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/form.js"></script>
<title>Insert title here</title>
</head>
<body class="RightFrame">

<input type="hidden" name="pageDirection" value="" id="pageDirection"/>
<table height="30" cellspacing="0" cellpadding="0" width="98%" 
            align="center" background="/images/bg07.jpg" border="0" class="weizhi">
      <tbody>
       
         <tr>
    <td class="wz_left">&nbsp;</td>
    <td nowrap="nowrap" class="wz_middle" >文件管理</td>
    <td class="wz_right">&nbsp;</td>
  	</tr>
    	</tbody>
    </table>
 
<div id="main">
  <div id="top">
    <table  width="98%" border="0" align="center" cellpadding="4" cellspacing="1" class="datatable" >
      <tr>
        <td width="12%">职工编号:</td>
        <td width="17%">
        <input type="text" name="usercode" value="">
        </td>
		<td width="12%"></td>
        <td width="17%"></td>

      </tr>
      <tr>
          <td  colspan="2"> 
        	<input type="button" value="查询"  class="bt" onClick="doSubmit('<%=path %>/FileServlet?param=select')" />
      	  </td>
      	<form action="<%=path %>/FileServlet?param=add" method="post" enctype="multipart/form-data">
		  <td ><input type="file" name="filename"></td>
		  <td width="100px" ><input  class="bt" type="submit" value="上传"></td>
	  	</form>
	 </tr>
		 
    </table>
  </div>
<form  method="post">
<div id="center">
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" class="datatable1" >
          <tr>
          	<th width="8%" class="listTableHead">id</th>
            <th width="8%" class="listTableHead">文件名</th>
            <th width="8%" class="listTableHead">上传者</th>
            <th width="8%" class="listTableHead">上传时间</th>
            <th width="8%" class="listTableHead">文件编号</th>
            <th width="8%" class="listTableHead">操作</th>  
          </tr>
        <c:forEach var="file" items="${datalist}">
		<tr>
            <td class="listTableLine1" >${file.id }</td>
            <td class="listTableLine1" >${file.filename }</td>
            <td class="listTableLine1" >&nbsp;${file.fileuper }</td>
            <td class="listTableLine1" >&nbsp;${file.filetime }</td>
            <td class="listTableLine1" >&nbsp;${file.fileinfo }</td>
			<td class="listTableLine1" >
			<a  style="cursor:pointer;" href="<%=path %>/FileServlet?param=delete&fileinfo=${file.fileinfo}"><u>删除</u></a>
			<a style="cursor:pointer;" href="/OAProject/FileServlet?param=download&fileinfo=${file.fileinfo}">下载</a>
			</td>
          </tr>
          </c:forEach>
</table>
 	
 
  </div>
</div> 
 		
</form>
	
</body>
     
</html>