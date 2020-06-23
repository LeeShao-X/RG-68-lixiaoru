<%@page contentType="text/html;charset=gbk" %>
<%@page import="java.sql.*" %>
<style type="text/css">
<!--
body {
	background-image:url(../images/mainbg.jpg);
		background-size:100% 100%;
    background-repeat:no-repeat;
}
-->
</style>
<br><br><br><br><br>
<center>
<table border="2"bordercolor="black"cellpadding="5">
<tr >
<th width=76>物品编号</th>
<th width=76>物品名称</th>
<th width=76>物品类别</th>
<th width=74>供应商</th>
<th width=76>出库价格</th>
<th width=74>库存量</th>
<th width=72>描述</th>
</tr>
<%	
	Class.forName("com.mysql.jdbc.Driver");
	
	String dburl="jdbc:mysql://localhost:3306/supermarket?useUnicode=true&serverTimezone=GMT";
	String dbuser="root";
	String dbpass="123456";
	Connection con = java.sql.DriverManager.getConnection(dburl,dbuser,dbpass);
	Statement stmt = con.createStatement();
	ResultSet rs=stmt.executeQuery("select * from product");
	while(rs.next())
	 {	
	String a,b,c,d,e,f,g,h,i,j;	
	out.print("<tr align=center>");
	a=rs.getString(1);
	out.print("<td>"+a+"</td>");
	b=rs.getString(2);
	out.print("<td>"+b+"</td>");
	c=rs.getString(3);
	out.print("<td>"+c+"</td>");
	d=rs.getString(4);
	out.print("<td>"+d+"</td>");
	g=rs.getString(6);
	out.print("<td>"+g+"</td>");
	i=rs.getString(7);
	out.print("<td>"+i+"</td>");
	j=rs.getString(8);
	out.print("<td>"+j+"</td>");
	out.print("<tr>");
	 }

	rs.close();
	stmt.close();	
	con.close();
%>
</table>
</center>
