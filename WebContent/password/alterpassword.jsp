<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改密码</title>
</head>
<body>
<form action="<%=path %>/AlertPasswordServlet" method="post">
	<table>
		<tr>
			<td>原密码:</td>
			<td><input type="text" name="oldpassword"></td>
			<td><font color=red><div>${msg1 }</div></font></td>
		</tr>
		<tr>
			<td>新密码:</td>
			<td><input type="text" name="newpassword1"></td>
			<td><font color=red><div>${msg2 }</div></font></td>
		</tr>
		<tr>
			<td>确认密码:</td>
			<td><input type="text" name="newpassword2"></td>
			<td><font color=red><div>${msg3 }</div></font></td>
		</tr>
		<tr>
			<td><input type="submit" value="修改"></td>
			<td></td>
		</tr>
	</table>
</form>
</body>
</html>