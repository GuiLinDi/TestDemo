<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <% String path=request.getContextPath();  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<style>
	body     {font-size:2pt;
	
          }
	</style>
	<script type="text/javascript">
	function doSubmit(param){
  				document.forms[0].action=param;
	  			document.forms[0].submit();
		}
	</script>

</head>
<body>
<form method="post">
<table width="968" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="968"><img src="images/index_r1_c1.jpg" width="968" height="81" border="0" /></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
<table width="968" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="689" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td colspan="2"><a href="<%=path %>/SecondaryMenuServlet?param=more&type=1"><img src="images/index_r4_c1.jpg" width="689" height="49" border="0" usemap="#Map4" /></td>
      </tr>
      <tr>
        <td height="190" colspan="2" valign="top" background="images/index_r6_c1.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="222"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><img src="images/index_r7_c1_r1_c1.jpg" width="222" height="8" /></td>
              </tr>
              <tr>
                <td background="images/index_r7_c1_r3_c1.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="5%">&nbsp;</td>
                    <td width="91%"><img src="images/index_r7_c1_r2_c2.jpg" width="210" height="147" /></td>
                    <td width="4%">&nbsp;</td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td><img src="images/index_r7_c1_r5_c1.jpg" width="222" height="8" /></td>
              </tr>
            </table></td>
            <td width="467" valign="top"><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
            <!-- 日程安排 -->
            <c:forEach items="${schedulelist }" var="schedule">
              <tr >
                <td width="6%" class="line"><div align="center"><img src="images/dian.jpg" width="3" height="3" /></div></td>
                <td width="75%" class="line">
                 <a style="cursor:hand" href="<%=path %>/SecondaryMenuServlet?param=one&id=${schedule.id}">
                ${schedule.title }</a>
                </td>
                <td width="19%" class="line"></td>
              </tr>
              </c:forEach>
            </table></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td width="222" valign="top"  background="images/index_r13_c2.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="images/index_r10_c1.jpg" width="222" height="33" /></td>
          </tr>
          <tr>
            <td height="124" background="images/index_r12_c1.jpg"><table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0"  background="images/index_r13_c2.jpg">
              <tr>
                <td width="4%">&nbsp;</td>
                <td width="91%" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                <!-- 消息 -->
                  <c:forEach items="${messagelist }" var="message">
                      <tr valign="top" >
                        <td width="20%" class="line"><div align="center"><img src="images/dian.jpg" width="3" height="3" /></div></td>
                        <td width="80%" class="line">${message.content }</td>
                      </tr>
				  </c:forEach>
                </table></td>
                <td width="5%">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td><img src="images/index_r15_c1.jpg" width="222" height="31" /></td>
          </tr>
          <tr>
            <td><table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0"  background="images/index_r13_c2.jpg">
              <tr>
                <td width="4%">&nbsp;</td>
                <td width="91%"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                <!-- 文件 -->
                
                    <tr >
                      <td width="10%" class="line"><div align="center"><img src="images/dian.jpg" width="3" height="3" /></div></td>
                      <td width="90%" class="line">
                     <div onClick="doSubmit('download.action?id=402880e43826be63013826c0fa0c0002')"> aa.doc</div>
                      </td>
                      </tr>
                 
                    <tr >
                      <td width="10%" class="line"><div align="center"><img src="images/dian.jpg" width="3" height="3" /></div></td>
                      <td width="90%" class="line">
                     <div onClick="doSubmit('download.action?id=402880e43826d7ed013826d831340001')"> 需求设计文档.doc</div>
                      </td>
                      </tr>
                 
                    <tr >
                      <td width="10%" class="line"><div align="center"><img src="images/dian.jpg" width="3" height="3" /></div></td>
                      <td width="90%" class="line">
                     <div onClick="doSubmit('download.action?id=402880e438269bc50138269c58890001')"> aa.doc</div>
                      </td>
                      </tr>
                 
                    <tr >
                      <td width="10%" class="line"><div align="center"><img src="images/dian.jpg" width="3" height="3" /></div></td>
                      <td width="90%" class="line">
                     <div onClick="doSubmit('download.action?id=402880e43826924101382693014a0001')"> aa.doc</div>
                      </td>
                      </tr>
                 
                    <tr >
                      <td width="10%" class="line"><div align="center"><img src="images/dian.jpg" width="3" height="3" /></div></td>
                      <td width="90%" class="line">
                     <div onClick="doSubmit('download.action?id=402880e43826e0e0013826e119850001')"> 需求设计文档.doc</div>
                      </td>
                      </tr>
                 


                </table></td>
                <td width="5%">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="467" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><a href="<%=path %>/SecondaryMenuServlet?param=more&type=2"><img src="images/index_r10_c2.jpg" width="467" height="48" border="0" usemap="#Map3"/></a></td>
          </tr>
          <tr>
            <td height="345" valign="top" background="images/index_r13_c2.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="4%">&nbsp;</td>
                <td width="91%"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                <!-- 工作日志 -->
               		<c:forEach items="${loglist }" var="log">
						 <tr >
							<td width="6%" class="line"><div align="center"><img src="images/dian.jpg" width="3" height="3" /></div></td>
							<td width="75%" class="line">
						   
							 <a style="cursor:hand" href="<%=path %>/SecondaryMenuServlet?param=one&id=${log.id}">
								${log.title }</a>
							</td>
							<td width="19%" class="line"></td>
						  </tr>
					</c:forEach>	  
                </table></td>
                <td width="5%">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
      
    </table></td>
    <td width="279" valign="top">
	
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><img src="images/index_r4_c3.jpg" width="279" /></td>
      </tr>
      <tr>
        <td height="206" valign="top" background="images/index_r5_c3.jpg">
		<MARQUEE id=this onmouseover=this.stop() 
                        onmouseout=this.start() scrollAmount=3 scrollDelay=120 
                        direction=up width=270 height=155>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="13%">&nbsp;</td>
            <td width="83%"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr >
                  <td width="10%" class="line">&nbsp;</td>
                  <td width="90%" class="line"></td>
                </tr>
              <!-- 最新公告 -->
               <tr >
                  <td width="10%" class="line"><div align="center"><img src="images/dian.jpg" width="3" height="3" /></div></td>
                  <td width="90%" class="line">下午三点下班</td>
                </tr>
            </table></td>
            <td width="4%">&nbsp;</td>
          </tr>
        </table></MARQUEE></td>
      </tr>
      <tr>
        <td><img src="images/index_r9_c3.jpg" width="279" height="31" /></td>
      </tr>
      <tr>
        <td height="80" background="images/index_r11_c3.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="11%" rowspan="2">&nbsp;</td>
            <td width="65%"><input type="radio" name="radiobutton" value="radiobutton" />
              日程安排 
                <input type="radio" name="radiobutton" value="radiobutton" />
                工作日志</td>
            <td width="24%" rowspan="2"><img src="images/index_r14_c6.jpg" width="49" height="49" /></td>
          </tr>
          <tr>
            <td>              <input name="textfield" type="text" size="25" />            </td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td><img src="images/index_r15_c3.jpg" width="279" height="112" border="0" usemap="#Map" /></td>
      </tr>
      <tr>
        <td><img src="images/index_r18_c3.jpg" width="279" height="26" /></td>
      </tr>
      <tr>
        <td height="150" valign="top" background="images/index_r19_c3.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="10%">&nbsp;</td>
            <td width="86%" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
              <!-- 会议公告 -->
              <c:forEach items="${noticelist }" var="notice">
                <tr >
                  <td width="10%" class="line"><div align="center"><img src="images/dian.jpg" width="3" height="3" /></div></td>
                  <td width="90%" class="line">${notice.content }</td>
                </tr>
			  </c:forEach>
            </table></td>
            <td width="4%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>


<map name="Map"><area shape="rect" coords="115,50,244,90" href="<%=path %>/HelloServlet"></map>
</form>
</body>

</html>