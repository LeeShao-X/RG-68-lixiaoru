<%@ page import="java.sql.*" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <style type="text/css">
        <!--
        body {
            background-image: url(../images/mainbg.jpg);
        }
        -->
    </style>
    <base href="<%=basePath%>">

    <title>管理员信息</title>

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

<body>
<form action="" method="post">
    <%
        String mid=(String)session.getAttribute("inputuid");
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/supermarket?useUnicode=true&characterEncoding=utf-8";
        con=DriverManager.getConnection(url,"root","123456");
        stmt=con.createStatement();
        String sql="select * from manager where id='"+mid+"'";
        rs=stmt.executeQuery(sql);
        while(rs.next()){
    %>
    <table align="center"  class="bordered">
        <thead>
        <tr>
            <th colspan="2">管理员信息</th>
        </tr>
        </thead>
        <tbody><tr>
            <td>编号：</td>
            <td><%=rs.getString("id") %></td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><%=rs.getString("name") %></td>
        </tr>
        <tr>
            <td>职务：</td>
            <td><%=rs.getString("position") %></td>
        </tr>
        <tr>
            <td>工作：</td>
            <td><%= rs.getString("job") %></td>
        </tr></tbody>
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
