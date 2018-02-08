<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>职工增改</title>
<link href="<%=path %>/css/blue/styles.css" rel="stylesheet" type="text/css" />
</head>
<body class="RightFrame" >
<form  action="<%=path %>/UserServlet" method="post">
<input type="hidden" name="param" value="${p }">
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

    <div id="editview" style="width:550px; height:700px; position:absolute; left: 172px; top: 150px; overflow: hidden; background-color:white;">
   	  <table width="100%" align="center" cellpadding="0" cellspacing="1" class="listTable1" border="0">
  <tr  >
    <td colspan="2" class="listTableHead" align="center">编辑职工信息 </td>
    </tr>
 
 <tr align="left">
    <td class="listTableLine2" >&nbsp;职工账号</td>
    <td class="listTableLine2" width="80%">
  		<input type="text" name="usercode" onblur="check()" value="${user.usercode }">
    </td>
  </tr>
  <tr align="left">
    <td class="listTableLine2" >&nbsp;部门</td>
    <td class="listTableLine2" width="80%">
         <select name="deptid">
            <c:forEach items="${deptList }" var="data">
                <option value="${data.deptid }"   <c:if test="${user.deptid==data.deptid}" >selected</c:if>   >
                 ${data.deptname }</option>
            </c:forEach>
         </select>
    </td>
  </tr>
  <tr align="left">
    <td class="listTableLine2" >&nbsp;职工名称</td>
    <td class="listTableLine2" width="80%">
 		<input type="text" name="username" value="${user.username }">
    </td>
  </tr>
  <tr align="left">
    <td class="listTableLine2" >&nbsp;密码</td>
    <td class="listTableLine2" width="80%">
 		<input type="password" name="password" value="${user.password }">
    </td>
  </tr>
   <tr align="left">
    <td class="listTableLine2" >&nbsp;邮箱</td>
    <td class="listTableLine2" width="80%" >
  		 <input type="text" name="email" value="${user.email }">
    </td>
  </tr>
   <tr align="left">
    <td class="listTableLine2" >&nbsp;电话</td>
    <td class="listTableLine2" width="80%" >
   		 <input type="text" name="telephone" value="${user.telephone }">
    </td>
  </tr>
  <tr align="left">
    <td class="listTableLine2" >&nbsp;职务</td>
    <td class="listTableLine2" width="80%" >
  		 <input type="text" name="job" value="${user.job }">
    </td>
  </tr>
  <tr align="left">
    <td class="listTableLine2" >&nbsp;性别</td>
    <td class="listTableLine2" width="80%">
  		<input type="radio" name="sex" value="1" <c:if test="${user.sex==1 }">checked</c:if>
  		>男
       <input type="radio" name="sex" value="0" <c:if test="${user.sex==0 }">checked</c:if>>女
    </td>
  </tr>
  <tr align="left">
    <td class="listTableLine2" >&nbsp;上司</td>
    <td class="listTableLine2" width="80%">
  		<select name="boss">
            <c:forEach items="${userList }" var="users">
               <option value="${users.usercode }"
                  <c:if test="${user.boss==users.usercode}">selected</c:if>
               >${users.username }</option>
            </c:forEach>
         </select>
    </td>
  </tr>
  
  
   <tr>
    <td colspan="2" class="listTableLine2" align="center">
    <input type="submit" name="save" value="保存"  class="bn2" >
 
    </td>
  </tr>
</table>
</div>

</form>
</body>
</html>