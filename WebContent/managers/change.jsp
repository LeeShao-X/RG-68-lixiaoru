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
<form action="/kucunUpdateServlet" method="post">
  <%
    String id=request.getParameter("id");
    Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;
    Class.forName("com.mysql.jdbc.Driver");
    String url="jdbc:mysql://localhost:3306/supermarket?useUnicode=true&characterEncoding=utf-8";
    con=DriverManager.getConnection(url,"root","123456");
    stmt=con.createStatement();
    String sql="select * from product where  id='"+id+"'";
    rs=stmt.executeQuery(sql);
    while(rs.next()){
  %>
  <table align="center"  class="bordered">
    <thead>
    <tr>
      <th colspan="2">修改前商品信息</th>
    </tr>
    </thead>
    <tbody><tr>
      <td>商品编号：</td>
      <td><%=rs.getString("id") %></td>
    </tr>
    <tr>
      <td>商品名称：</td>
      <td><%=rs.getString("uname") %></td>
    </tr>
    <tr>
      <td>商品类别：</td>
      <td><%= rs.getString("class") %></td>
    </tr>
    <tr>
      <td>制造厂商：</td>
      <td><%=rs.getString("provider") %></td>
    </tr>
    <tr>
      <td>进货价：</td>
      <td><%= rs.getString("inprice") %></td>
    </tr>
    <tr>
      <td>出货价：</td>
      <td><%= rs.getString("outprice") %></td>
    </tr>
    <tr>
      <td>存货量：</td>
      <td><%= rs.getString("num") %></td>
    </tr>
    <tr>
      <td>商品全名：</td>
      <td><%= rs.getString("exp") %></td>
    </tr></tbody>
  </table>
  <table align="center" width="300" class="bordered">
    <thead>
    <tr>
      <th colspan="2">修改商品信息</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td>商品编号：</td>
      <td><input name="id" type="text" ></td>
    </tr>
    <tr>
      <td>商品名称：</td>
      <td><input name="uname" type="text" ></td>
    </tr>
    <tr>
      <td>商品类别：</td>
      <td><input name="class" type="text" ></td>
    </tr>
    <tr>
      <td>制造厂商：</td>
      <td><input name="provider" type="text" ></td>
    </tr>
    <tr>
      <td>进货价：</td>
      <td><input name="inprice" type="text" ></td>
    </tr>
    <tr>
      <td>出货价：</td>
      <td><input name="outprice" type="text" ></td>
    </tr>
    <tr>
      <td>存货量：</td>
      <td><input name="num" type="text" ></td>
    </tr>
    <tr>
      <td>商品全名：</td>
      <td><input name="exp" type="text" ></td>
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
