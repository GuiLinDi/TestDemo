<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% String path=request.getContextPath();  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="<%=path %>/css/blue/styles.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function check(){
		var XHR=null;  
		if (window.XMLHttpRequest) {  
		    // 非IE内核  
		    XHR = new XMLHttpRequest();  
		} else if (window.ActiveXObject) {  
		    // IE内核,这里早期IE的版本写法不同,具体可以查询下  
		    XHR = new ActiveXObject("Microsoft.XMLHTTP");  
		} else {  
		    XHR = null;  
		} 
		
		var namees = document.forms[0].namees.value;
		
		XHR.open("post","http://localhost:8080/OAProject/ContacterServlet?param=check&namees="+namees,true);
		
		XHR.send(); 
		
		 XHR.onreadystatechange = function () { 
			 
		        if (XHR.readyState == 4 && XHR.status == 200) { 
		        	
		           var text= XHR.responseText;  
		           if(text=="yes"){
		        	   document.getElementById("msg").innerHTML="";
		           }else{
		        	   document.getElementById("msg").innerHTML="<font color=red>此联系人已存在</font>";
		           		document.forms[0].namees.value="";
		           }
		            XHR = null;  
		        }  
		    };  
	}
</script>
</head>
<body class="RightFrame" >
<form action="<%=path %>/ContacterServlet" method="post">
  <input type="hidden" name="param" value="${p }">
   <input type="hidden" name="id" value="${contacter.id }">
<table height="30" cellspacing="0" cellpadding="0" width="98%" 
            align="center" background="/images/bg07.jpg" border="0" class="weizhi">
      <tbody>
       
    <tr>
      <td class="wz_left">&nbsp;</td>
      <td nowrap="nowrap" class="wz_middle" >个人通讯录管理</td>
      <td class="wz_right">&nbsp;</td>
   </tr>
      </tbody>
    </table>

    <div id="editview" style="width:550px; height:700px; position:absolute; left: 172px; top: 150px; overflow: hidden; background-color:white;">
   	  <table width="100%" align="center" cellpadding="0" cellspacing="1" class="listTable1" border="0">
  <tr  >
    <td colspan="2" class="listTableHead" align="center">编辑联系人信息 </td>
    </tr>
 
 <tr align="left">
    <td class="listTableLine2" >&nbsp;联系人姓名</td>
    <td class="listTableLine2" width="80%">
  		<input type="text" name="namees" value="${contacter.namees}" onblur="check()">
  		<div id="msg"></div>
    </td>
    
  </tr>
  <tr align="left">
    <td class="listTableLine2" >&nbsp;性别</td>
    <td class="listTableLine2" width="80%">
  		<input type="text" name="sex" value="${contacter.sex}">
    </td>
  </tr>
  <tr align="left">
    <td class="listTableLine2" >&nbsp;联系电话</td>
    <td class="listTableLine2" width="80%">
 		<input type="text" name="telephone" value="${contacter.telephone}">
    </td>
  </tr>
  <tr align="left">
    <td class="listTableLine2" >&nbsp;QQ</td>
    <td class="listTableLine2" width="80%">
 		<input type="text" name="qq" value="${contacter.qq}">
    </td>
  </tr>
   <tr align="left">
    <td class="listTableLine2" >&nbsp;公司</td>
    <td class="listTableLine2" width="80%">
  		 <input type="text"name="company" value="${contacter.company}">
    </td>
  </tr>
   <tr align="left">
    <td class="listTableLine2" >&nbsp;家庭住址</td>
    <td class="listTableLine2" width="80%">
   		 <input type="text" name="address" value="${contacter.address}">
    </td>
  </tr>
  <tr align="left">
    <td class="listTableLine2" >&nbsp;邮编</td>
    <td class="listTableLine2" width="80%">
  		 <input type="text" name="post" value="${contacter.post}">
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