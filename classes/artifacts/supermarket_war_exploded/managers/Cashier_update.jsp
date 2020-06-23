<%@ page import="java.sql.*" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Cashier_update.jsp' starting page</title>
    
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
    <form action="/uUpdateServlet" method="post">
<%
String Cid=request.getParameter("Cid");
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/supermarket?useUnicode=true&characterEncoding=utf-8";
con=DriverManager.getConnection(url,"root","123456");
stmt=con.createStatement();
String sql="select * from cashier where  Cid='"+Cid+"'";
rs=stmt.executeQuery(sql);
while(rs.next()){
%>
    		<table align="center"  class="bordered">
				<thead>
    			<tr>
    				<th colspan="2">修改前员工信息</th>
    			</tr>
				</thead>
				<tbody><tr>
					<td>编号：</td>
					<td><%=rs.getString("Cid") %></td>
				</tr>
    			<tr>
   					<td>姓名：</td>
   					<td><%=rs.getString("Cname") %></td>
   				</tr>
   				<tr>
   					<td>性别：</td>
   					<td><%= rs.getString("Csex") %></td>
   				</tr>
   				<tr>
   					<td>年龄：</td>
   					<td><%=rs.getInt("Cage") %></td>
   				</tr>
   				<tr>
   					<td>工资：</td>
   					<td><%= rs.getString("Cmoney") %></td>
    			</tr></tbody>
    		</table>
    		<table align="center" width="300" class="bordered">
				<thead>
    			<tr>
    				<th colspan="2">修改员工信息</th>
    			</tr>
				</thead>
				<tbody>
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
   					<td><select name="Csex" >
   						<option value="男">男</option>
   						<option value="女">女</option>
   					</select></td>
   				</tr>
   				<tr>
   					<td>年龄：</td>
   					<td><input name="Cage" type="text" ></td>
   				</tr>
   				<tr>
   					<td>工资：</td>
   					<td><input name="Cmoney" type="text" class="opt_input"></td>
    			</tr></tbody>
    			<tr align="center"> 
    				<td colspan="2">
    				<input  type="submit" name="sure"  value="确认">
    				<input  type="reset"  name="clear" value="取消">
    				</td>
    			</tr>
    		</table>
    			<%
}
rs.close();
stmt.close();
con.close();
%>
    	</form>
  </body>
</html>
