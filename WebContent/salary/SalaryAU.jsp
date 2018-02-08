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
</head>
<body class="RightFrame" >
<form action="<%=path %>/SalaryServlet" method="post">
<input type="hidden" name="param" value="${p }">
<input type="hidden" name="id" value="${salary.id }">
<table height="30" cellspacing="0" cellpadding="0" width="98%" 
            align="center" background="/images/bg07.jpg" border="0" class="weizhi">
      <tbody>
       
         <tr>
    <td class="wz_left">&nbsp;</td>
    <td nowrap="nowrap" class="wz_middle" >薪资管理</td>
    <td class="wz_right">&nbsp;</td>
  </tr>
      </tbody>
    </table>

    <div id="editview" style="width:550px; height:700px; position:absolute; left: 172px; top: 150px; overflow: hidden; background-color:white;">
   	  <table width="100%" align="center" cellpadding="0" cellspacing="1" class="listTable1" border="0">
  <tr  >
    <td colspan="2" class="listTableHead" align="center">编辑薪资</td>
    </tr>
 
 
  <tr align="left">
    <td class="listTableLine2" >&nbsp;职工编号</td>
    <td class="listTableLine2" width="80%">
        <select name="usercod">
  		<c:forEach items="${userList }" var="user">
                 <option value="${user.usercode }" 
                 <c:if test="${user.usercode==salary.usercode }">selected</c:if>
                 >${user.username }</option>
        </c:forEach>
      </select>
    </td>
  </tr>
  <tr align="left">
    <td class="listTableLine2" >&nbsp;基本工资</td>
    <td class="listTableLine2" width="80%">
 		<input type="text" name="base" value="${salary.base }">
    </td>
  </tr>
  <tr align="left">
    <td class="listTableLine2" >&nbsp;奖金</td>
    <td class="listTableLine2" width="80%">
 		<input type="text" name="bonus" value="${salary.bonus }">
    </td>
    <tr align="left">
    <td class="listTableLine2" >&nbsp;扣除</td>
    <td class="listTableLine2" width="80%">
 		<input type="text" name="takeoff" value="${salary.takeoff }">
    </td>
    <tr align="left">
    <td class="listTableLine2" >&nbsp;社保金额</td>
    <td class="listTableLine2" width="80%">
 		<input type="text" name="safe" value="${salary.safe }">
    </td>
    <tr align="left">
    <td class="listTableLine2" >&nbsp;其他</td>
    <td class="listTableLine2" width="80%">
 		<input type="text" name="other" value="${salary.other }">
    </td>

   <tr>
    <td colspan="2" class="listTableLine2" align="center">
    <input type="submit" name="save" value="保存"  class="bn2">
    </td>
  </tr>
</table>
</div>

</form>
</body>
</html>