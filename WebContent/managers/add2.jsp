<%@page contentType="text/html;charset=gbk" %>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<style type="text/css">
<!--
body {
	background-image: url(../images/mainbg.jpg);
}
-->
.login-button {
	width: 90px;
	height: 25px;
	border-width: 0px;
	border-radius: 3px;
	background: #1E90FF;
	cursor: pointer;
	outline: none;
	font-family: Microsoft YaHei;
	color: white;
	font-size: 15px;
}
.login-button:hover {
	background: #5599FF;
}

</style>
<body>
<form action="/kucunServlet" method="post">
	<input type="submit" value="return" class="login-button"/>
</form>
</body>
<%	
	
  String pidproduct=request.getParameter("idproduct");
	String idproduct=new String(pidproduct.getBytes("iso-8859-1"));

	String pproductname=request.getParameter("productname");
	String productname=new String(pproductname.getBytes("iso-8859-1"));

	String pclassify=request.getParameter("classify");
	String classify=new String(pclassify.getBytes("iso-8859-1"));

	String psupplier=request.getParameter("supplier");
	String supplier=new String(psupplier.getBytes("iso-8859-1"));

	String pin_price=request.getParameter("in_price");
	String in_price=new String(pin_price.getBytes("iso-8859-1"));
	
	String pout_price=request.getParameter("out_price");
	String out_price=new String(pout_price.getBytes("iso-8859-1"));

	String pamount=request.getParameter("amount");
	String amount=new String(pamount.getBytes("iso-8859-1"));

	
	String pdescribe=request.getParameter("describe");
	String describe=new String(pdescribe.getBytes("iso-8859-1"));


	
	Class.forName("com.mysql.jdbc.Driver");
  
	String dburl="jdbc:mysql://localhost:3306/supermarket?useUnicode=true&characterEncoding=utf-8";
	String dbuser="root";
	String dbpass="123456";
	Connection con = java.sql.DriverManager.getConnection(dburl,dbuser,dbpass);
	Statement stmt = con.createStatement();
	/*ResultSet rs=stmt.executeQuery("select * from product where id='"+idproduct+"'");

	if(rs.next())
	{
	*/
	stmt.executeUpdate("insert into product (id,uname,class,provider,inprice,outprice,num,exp) values('"+idproduct+"','"+productname+"','"+classify+"','"+supplier+"','"+in_price+"','"+out_price+"','"+amount+"','"+describe+"')");
	
	/*}*/
	
 	ResultSet rs=stmt.executeQuery("select * from product where id='"+idproduct+"'");
	out.print("新增的物品如下: ");
	out.print("<table border>");
	out.print("<tr>");
	out.print("<th width=72>物品编号</td>");
    out.print("<th width=72>物品名称</td>");
	out.print("<th width=50>物品类别</td>");
	out.print("<th width=50>供应商</td>");   
    out.print("<th width=62>入库价格</td>");
    out.print("<th width=50>出库价格</td>");   
    out.print("<th width=50>库存量</td>");
	out.print("<th width=50>描述</td>");

	out.print("</tr>");
	
	while(rs.next())
	{
	
	
	String a,b,c,d,e,f,g,h;
	out.print("<tr>");	
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

	out.print("</tr>");
	}
	rs.close();
	stmt.close();	
	con.close();
%>


