<%@page contentType="text/html;charset=gbk" %>
<%@page import="java.sql.*" %>
<%@page language="java" import="java.util.*" %>
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
	<p><font color="red"><strong>售出成功!</strong></font></p>

<%
	String pidproduct=request.getParameter("idproduct");
	String idproduct=new String(pidproduct.getBytes("iso-8859-1"));

	String pproductname=request.getParameter("productname");
	String productname=new String(pproductname.getBytes("iso-8859-1"));


	String pamount=request.getParameter("add_amount");
	String amount=new String(pamount.getBytes("iso-8859-1"));

	
	Class.forName("com.mysql.jdbc.Driver");
  
	String dburl="jdbc:mysql://localhost:3306/supermarket?useUnicode=true&serverTimezone=GMT";
	String dbuser="root";
	String dbpass="123456";
	Connection con = java.sql.DriverManager.getConnection(dburl,dbuser,dbpass);
	Statement stmt = con.createStatement();
	ResultSet rs=stmt.executeQuery("select * from product where id='"+idproduct+"'");
	int in=0,ou=0,mi=0,o=0;
	if(rs.next()){
	    in=rs.getInt(5);
	    ou=rs.getInt(6);
	int i=rs.getInt(7);
	int a= Integer.parseInt(amount);
	int k=i-a;
	stmt.executeUpdate("update  product set num='"+k+"' where id='"+idproduct+"'");
	}
	ResultSet rs2=stmt.executeQuery("select * from sall_product where id='"+idproduct+"'");
	if(rs2.next()){
	    mi=ou-in;
	    int j=rs2.getInt(5);
	    int z=rs2.getInt(6);
		int a= Integer.parseInt(amount);
		int l=j+a;
		o=mi*a;z=o+z;
		stmt.executeUpdate("update  sall_product set num='"+l+"',profit='"+z+"' where id='"+idproduct+"'");
	}
 	rs=stmt.executeQuery("select * from product where id='"+idproduct+"'");
	int zong=Integer.parseInt(amount)*ou;
	out.print("消费总金额为："+zong+"元");
	out.print("<br/>");
	out.print("以下是您购买的此商品的信息！");
	out.print("<table border=3 bordercolor=white cellpadding=10>");
	out.print("<tr align=center>");
	out.print("<th width=72>物品编号</td>");
    out.print("<th width=72>物品名称</td>");
	out.print("<th width=72>物品类别</td>");
	out.print("<th width=50>供应商</td>");   

    out.print("<th width=72>价格</td>");
    out.print("<th width=50>数量</td>");

	out.print("<th width=50>描述</td>");

	out.print("</tr>");
	
	while(rs.next())
	{

	String a,b,c,d,e,f,g,h,i;
	out.print("<tr align=center>");	
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
	out.print("<td>"+amount+"</td>");
	i=rs.getString(8);
	out.print("<td>"+i+"</td>");

	out.print("</tr>");
	}
	rs.close();
	rs2.close();
	stmt.close();
	con.close();
%>
<p><font color="red">注：收银端看不到产品的入库价格和销售量</font></p>
	<p><font color="red"><a href="u_sall.jsp" >继续添加</a></font></p>
</center>
