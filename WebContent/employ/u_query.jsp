<%@page contentType="text/html; charset=gbk"%><style type="text/css">
<!--
body {
	background-image: url(../images/mainbg.jpg);
		background-size:100% 100%;
    background-repeat:no-repeat;
}
.STYLE1 {
	font-size: large;
	font-weight: bold;
}
.STYLE2 {font-size: medium}
-->
</style>
<br><br>
<center>
<p style="font-size:30px"><strong>货物查询</strong></p>
<form id="form1" name="form1" method="post" action="u_query2.jsp">
  <label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
  <table border="3"bordercolor="white"cellpadding="10">
    <tr align="center">
      <td width="80">物品编号：</td>
      <td width="100"><label>
        <input name="idproduct" type="text" id="idproduct" />
      </label></td>
    </tr>
    
    <tr align="center">
      <td>物品名称：</td>
      <td><label>
        <input name="productname" type="text" id="productname" />
      </label></td>
    </tr>
        
    <tr align="center">
      <td>物品类别：</td>
      <td><label>
        <input name="productclass" type="text" id="productclass" />
      </label></td>
    </tr>
    <tr align="center">
      <td>货源:</td>
      <td><input name="supplier" type="text" id="supplier" /></td>
    </tr>
     <tr align="center">
      <td colspan="2">
      <input type="submit" name="Submit" value="查询" /></td>
    </tr>
  </table>
  <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
</form>
</center>
