<%@page contentType="text/html;charset=gbk" %>
<%@page import="java.sql.*" %>

<style type="text/css">
<!--
body {
	background-image: url(../images/mainbg.jpg);
		background-size:100% 100%;
    background-repeat:no-repeat;
}
-->
</style>
<br><br><br><br><br>

<center>
<table border="3"bordercolor="white"cellpadding="10"> 
<%
	out.print("<tr align=center>");
	out.print("<th width=72>物品</td>");
	out.print("<th width=72>物品名称</td>");
    out.print("<th width=72>物品类别</td>");
    out.print("<th width=50>供应商</td>");
  
    out.print("<th width=72>出库价格</td>");
    out.print("<th width=50>库存量</td>");

    out.print("<th width=50>描述</td>");
  
    
	out.print("<tr align=center>");
	
	String pidproduct=request.getParameter("idproduct");
	String idproduct=new String(pidproduct.getBytes("iso-8859-1"));


	String pproductname=request.getParameter("productname");
	String productname=new String(pproductname.getBytes("iso-8859-1"));

	String psupplier=request.getParameter("supplier");
	String supplier=new String(psupplier.getBytes("iso-8859-1"));

	Class.forName("com.mysql.jdbc.Driver");
	String dburl="jdbc:mysql://localhost:3306/supermarket?useUnicode=true&serverTimezone=GMT";
	String dbuser="root";
	String dbpass="123456";
	Connection con = java.sql.DriverManager.getConnection(dburl,dbuser,dbpass);
	Statement stmt = con.createStatement();

	ResultSet rs=stmt.executeQuery("select * from product where id='"+idproduct+"'");
	
	
	if(rs.next())
		{
			
		String a,b,c,d,e,f,g,h,i;	
	a=rs.getString(1);
	out.print("<td>"+a+"</td>");
	b=rs.getString(2);
	out.print("<td>"+b+"</td>");
	c=rs.getString(3);
	out.print("<td>"+c+"</td>");
	d=rs.getString(4);
	out.print("<td>"+d+"</td>");
	f=rs.getString(6);
	out.print("<td>"+f+"</td>");
	g=rs.getString(7);
	out.print("<td>"+g+"</td>");
	i=rs.getString(8);
	out.print("<td>"+i+"</td>");
	
	out.print("<tr>");
	
		}
	
	rs.close();
	stmt.close();	
	con.close();
%>
</table>
<p><font color="red">注：收银端看不到产品的入库价格和销售量</font></p>
</center>