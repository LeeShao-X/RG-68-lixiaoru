<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/12/27
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言界面</title>
    <style type="text/css">
        <!--
        body {
            background-image: url(../images/mainbg.jpg);
            background-size:100% 100%;
            background-repeat:no-repeat;
        }
        -->
    </style>
</head>

<body  style="font-family:楷体">
<div style="text-align:center;margin-top:100px">
    <h1 ><font color="red" >请在下方填写您的建议留言</h1></font>
    <form action="/LeaveMessageServlet" method="post">
        <table style="margin-left: 37%" border="1">
            <caption><font color="#FF9933">填写留言信息</caption></font>
            <tr><td><font color="#FF9933"> 留言标题</td></font>
                <td><input type="text" name="title"/></td></tr>
            <tr><td><font color="#FF9933"> 留言内容</td></font>
                <td><textarea name="message" rows="5" cols="35"></textarea></td>
            </tr>
        </table>
        <input type="submit" value="提交"/>
        <input type="reset" value="重置"/>
    </form>
    <a href="u_mainframe.jsp" target="_parent"><font color="#FF9933"> 返回主界面</a></font>
</div>
</body>
</html>
