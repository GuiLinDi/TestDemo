<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
 <link href="css/blue/styles.css" rel="stylesheet" type="text/css" />
</head>
<body >
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="88" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td class="top_logodi"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td  class="top_logo">&nbsp;</td>
            <td><table width="310" border="0" align="right" cellpadding="0" cellspacing="0">
              <tr>
                <td width="7%"></td>
                <td width="83%" style="color:#000000; padding-top:4px;">&nbsp;${user.username }
                你好! </td>
                <td width="10%" style="color:#000000; padding-top:4px;">
                
                </td>
                </tr>
            </table></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td height="31" class="top_menudi"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="30">&nbsp;</td>
            
                <td ><table width="360" border="0" cellspacing="0" cellpadding="0">
                    <TR id=topMenuRow>
                      <TD id=menuitem0 class=TopFrameMenu1Td width=82><A 
                        class=dhlink onclick="activeMenu('0')" 
                        href="" 
                        target=leftMenu>职员管理</A> </TD>
                      <TD id=menuitem1 class=TopFrameMenu1Td width=82><A 
                        class=dhlink  
                        href="" 
                        target=leftMenu>日志管理</A> </TD>
                      <TD id=menuitem2 class=TopFrameMenu1Td width=82><A 
                        class=dhlink 
                        href="" 
                        target=leftMenu>消息信息</A> </TD>
                      <TD id=menuitem3 class=TopFrameMenu1Td width=82><A 
                        class=dhlink  
                        href="" 
                        target=leftMenu>通知管理</A> </TD>
                      <TD id=menuitem2 class=TopFrameMenu1Td width=82><a 
                        class=dhlink  
                        href="<%=path %>/ExitServlet"                         
                        target=_parent>退出系统</a> </TD></TR></TBODY></TABLE></TD>
                <TD id=menuitem2 class=TopFrameMenu1Td width=82><a 
                        class=dhlink  
                        href="<%=path %>/ReturnServlet"                         
                        target=_parent>返回首页</a></TD></TR>
                </table></td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
     
  <tr>
    <td class="top_menudi1"></td>
  </tr>
</table>
</body>

</html>