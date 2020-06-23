<%@page contentType="text/html;charset=gbk"%>
<html>
<head>
    <title>商品信息总览</title>

</head>
<script src="../js/jquery-3.3.1.js"></script>
<style type="text/css">
    <!--
    body {
        background-image: url(../images/mainbg.jpg);
        background-size:100% 100%;
        background-repeat:no-repeat;
    }
    -->
</style>
<html>
<br><br>
<body>
<p style="font-size:30px;text-align:center;"><strong>货物出售</strong></p>
<form >
    <label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br />
    </label>
    <table border="3"bordercolor="white"cellpadding="10" style="margin: 0 auto">
        <tr align="center">
            <td width="80">物品编号：</td>
            <td width="100"><label>
                <input  />
            </label></td>
        </tr>
        <tr align="center">
            <td>物品名称：</td>
            <td><label>
                <input  />
            </label></td>
        </tr>

        <tr align="center">
            <td>售出量：</td>
            <td><label>
                <input  />
            </label></td>
        </tr>
        <tr align="center">
            <td colspan="2"><label>
                <input type="submit" name="Submit" value="继续" />
            </label>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <label>
                    <input type="reset" name="Submit2" value="重置" />
                </label></td>
        </tr>
    </table>
    <label><br />
    </label>
</form>
<div style="margin: 0 auto;width: 50px"><a href="../managers/sall_product.jsp" ><button>结算</button></div></a>
</body>
</html>