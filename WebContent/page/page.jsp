<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" class="datatable1">
        <tr>
            <td width="50%" align="left">共有
            ${util.itemCount }
            	条记录，
            <span style="font-family:宋体; font-size:9.0pt; color:black; ">第</span>
            <span style="font-family:Tahoma; font-size:9.0pt; color:black; "> 
            		${util.curPage }/${util.totalPage }
            </span>
            <span style="font-family:宋体; font-size:9.0pt; color:black; ">页</span></td>
            <td width="50%" align="right">
            <a href="${pageContext.request.contextPath }/${util.url }&curPage=1">首页</a> 
            <a href="${pageContext.request.contextPath }/${util.url }&curPage=${util.curPage==1?1:util.curPage-1}">上一页</a> 
            <a href="${pageContext.request.contextPath }/${util.url }&curPage=${util.curPage==util.totalPage?util.totalPage:util.curPage+1}">下一页</a> 
            <a href="${pageContext.request.contextPath }/${util.url }&curPage=${util.totalPage}">末页</a> 	
            </td>
        </tr>
    </table>

</body>

</html>