<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="<%=path %>/css/blue/styles.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/js/form.js">
    function check(){
    	
    }
</script>
</head>
<body class="RightFrame" >
<form  action="<%=path %>/DeptServlet?param=update" method="post" >
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

    <div id="editview" style="width:550px; height:700px; position:absolute; left: 172px; top: 150px; overflow: hidden; background-color:white;">
   	  <table width="100%" align="center" cellpadding="0" cellspacing="1" class="listTable1" border="0">
  <tr  >
    <td colspan="2" class="listTableHead" align="center">编辑部门信息 </td>
    </tr>
 
 <tr align="left">
    <td class="listTableLine2" >&nbsp;部门编号</td>
    <td class="listTableLine2" width="80%">
  		<input type="text"name="deptid" value="${dept.deptid }">
    </td>
  </tr>
  <tr align="left">
    <td class="listTableLine2" >&nbsp;部门名称</td>
    <td class="listTableLine2" width="80%">
  		<input type="text" name="deptname" value="${dept.deptname }">
    </td>
  </tr>
  <tr align="left">
    <td class="listTableLine2" >&nbsp;备注</td>
    <td class="listTableLine2" width="80%">
 	<input type="text" name="remark" value="${dept.remark}" >
 		
    </td>
  </tr>
  <tr>
    <td colspan="2" class="listTableLine2" align="center">
    <input type="button" name="save" value="保存"  class="bn2" onClick="doSubmit('DeptServlet?param=update')">
    <input name="" type="button" value="取消" class="bn2"  onClick="doSubmit('/DeptServlet?param=select')">
    </td>
  </tr>
</table>
</div>

</form>
</body>
</html>