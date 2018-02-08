<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" >
		function doSubmit(param){
  				document.forms[0].action=param;
	  			document.forms[0].submit();
		}
	</script>
<style>
	/*基本标签样式*/
td,div,p,font,span,option,label,a,li{
  font-size:12px;
  line-height:25px;
}
</style>
</head>
 <body>
    <form>
       
       
        
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td bgcolor="#BDD7FC"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="100%" bgcolor="#BDD7FC" align="center">&nbsp;
      <font color=red>${msg } </font>
      
        </td>
      </tr>
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="687" height="458" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="190" colspan="2">&nbsp;</td>
                      </tr>
                      <tr>
                        <td width="52%">&nbsp;</td>
                        <td width="48%"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td colspan="2" style="color:#6a6b6d; font-weight:bold;">请输入用户名：</td>
                            </tr>
                            <tr>
                              <td colspan="2">
                              <input type="text" name="usercode" value="" id="usercode"/>
                              </td>
                            </tr>
                            <tr>
                              <td colspan="2" style="color:#6a6b6d; font-weight:bold;">密 码：</td>
                            </tr>
                            <tr>
                              <td colspan="2">
                              <input type="password" name="password" id="password"/>
                              </td>
                            </tr>
                            <tr>
                              <td colspan="2">&nbsp;</td>
                            </tr>
                            <tr>
                              <td width="35%"><input type="button" value="登录" onclick="doSubmit('LoginServlet')"></td>
                              <td width="65%"><input type="reset" value="重置"></td>
                            </tr>
                        </table></td>
                      </tr>
                  </table></td>
                </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="100%">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
  </form>
 
  </body>
</html>