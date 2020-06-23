<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Cashier_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	  <link href="../css/updatecashier.css" rel="stylesheet" type="text/css">
  </head>
  
  <body background="../images/mainbg.jpg">
     <form action="/caddServlet" method="post">
    		<table align="center" width="300">
    			<tr>
    				<th colspan="2">添加员工信息</th>
    			</tr>
				<tr>
					<td>编号：</td>
					<td><input name="Cid" type="text" ></td>
				</tr>
    			<tr>
   					<td>姓名：</td>
   					<td><input name="Cname" type="text" ></td>
   				</tr>
   				<tr>
   					<td>性别：</td>
   					<td><input name="Csex" type="text" ></td>
   				</tr>
   				<tr>
   					<td>年龄：</td>
   					<td><input name="Cage" type="text" ></td>
   				</tr>
   				<tr>
   					<td>工资：</td>
   					<td><input name="Cmoney" type="text" class="opt_input"></td>
    			</tr>
    			<tr align="center"> 
    				<td colspan="2">
    				<input  type="submit" name="sure"  value="确认">
    				<input  type="reset"  name="clear" value="取消">
    				</td>
    			</tr>
    		</table>
    	</form>
  </body>
</html>
