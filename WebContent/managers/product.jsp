<%@page contentType="text/html;charset=gbk"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<style type="text/css">
		<!--
		body {
			background-image: url(../images/mainbg.jpg);
		}
		-->
	</style>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<title>������Ϣ</title>
	<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css"/>
	<style type="text/css">
<!--
</style>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> ��ҳ <span class="c-gray en">&gt;</span> ��Ѷ���� <span class="c-gray en">&gt;</span> ��Ѷ�б� <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="ˢ��" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
</body>
</html>
<%	
	out.print("<table border>");
	out.print("<tr>");
	out.print("<th width=76>��Ʒ���</td>");
	out.print("<th width=76>��Ʒ����</td>");
    out.print("<th width=76>��Ʒ���</td>");
    out.print("<th width=74>��Ӧ��</td>");
    out.print("<th width=76>���۸�</td>");
    out.print("<th width=76>����۸�</td>");
    out.print("<th width=74>�����</td>");
    out.print("<th width=74>������</td>");
    out.print("<th width=72>����</td>");
	out.print("<tr>");
	
	Class.forName("com.mysql.jdbc.Driver");
	
	String dburl="jdbc:mysql://localhost/supermarket";
	String dbuser="root";
	String dbpass="123456";
	Connection con = java.sql.DriverManager.getConnection(dburl,dbuser,dbpass);
	Statement stmt = con.createStatement();
	
	ResultSet rs=stmt.executeQuery("select * from product");
	
	while(rs.next())
	 {	
	String a,b,c,d,e,f,g,h,i,j;	
	a=rs.getString(1);
	out.print("<td>"+a+"</td>");
	b=rs.getString(2);
	out.print("<td>"+b+"</td>");
	c=rs.getString(3);
	out.print("<td>"+c+"</td>");
	d=rs.getString(4);
	out.print("<td>"+d+"</td>");
	e=rs.getString(5);
	out.print("<td>"+e+"</td>");
	f=rs.getString(6);
	out.print("<td>"+f+"</td>");
	g=rs.getString(7);
	out.print("<td>"+g+"</td>");
	h=rs.getString(8);
	out.print("<td>"+h+"</td>");
	i=rs.getString(9);
	out.print("<td>"+i+"</td>");
	out.print("<tr>");

	 }
	
	
	rs.close();
	stmt.close();	
		
	con.close();
%>
