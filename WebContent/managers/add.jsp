<%@page contentType="text/html;charset=gbk"%>
<html>
<head>
<style type="text/css">
<!--
body {
	background-image: url(../images/mainbg.jpg);
}
-->
</style>
  <link href="../css/updatecashier.css" rel="stylesheet" type="text/css">

</head>
<body>

<form id="form1" name="form1" method="post" action="add2.jsp">
  <table align="center" width="300" style="color:black">
    <tr>
      <th colspan="2">��Ʒ��Ϣ���</th>
    </tr>
    <tr>
      <td width="89">��Ʒ��ţ�</td>
      <td width="187">
        <input name="idproduct" type="text" id="idproduct" />
     </td>
    </tr>
    <tr>
      <td>��Ʒ���ƣ�</td>
      <td>
        <input name="productname" type="text" id="productname" />
      </td>
    </tr>
    <tr>
      <td>��Ʒ���</td>
      <td>
        <input name="classify" type="text" id="classify" />
      </td>
    </tr>
    <tr>
      <td>��Ӧ��:</td>
      <td><input name="supplier" type="text" id="supplier" />      </td>
    </tr>
    <tr>
      <td>���۸�</td>
      <td>
        <input name="in_price" type="text" id="in_price" />
      </td>
    </tr>
    <tr>
      <td>����۸�</td>
      <td><input name="out_price" type="text" id="out_price" />      </td>
    </tr>
    <tr>
      <td>�������</td>
      <td>
        <input name="amount" type="text" id="amount" />
      </td>
    </tr>
    <tr>
      <td>������</td>
      <td>
       <input name="describe" type="text" id="describe" />
     </td>
    </tr>

    <tr align="center">
      <td colspan="2">
        <input  type="submit" name="sure"  value="ȷ��">
        <input  type="reset"  name="clear" value="ȡ��">
      </td>
    </tr>
  </table>
  <label><br />
  </label>
</form>
</body>
</html>