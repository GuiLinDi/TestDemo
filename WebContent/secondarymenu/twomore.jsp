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
<body>
 <table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" class="datatable1" >
          <tr>
          
           <th width="8%" class="listTableHead">标题</th>
            <th width="8%" class="listTableHead">内容</th>
           <th width="8%" class="listTableHead">记录时间</th>
          </tr>
       <c:forEach items="${datalist }" var="jb">
         <tr>
            <td class="listTableLine1" >${jb.title}</td>
            <td class="listTableLine1" >${jb.contend}</td>
            <td class="listTableLine1" >${jb.rectime}</td>
        </tr>
               
      </c:forEach> 
  
 
</table>
</body>
</html>