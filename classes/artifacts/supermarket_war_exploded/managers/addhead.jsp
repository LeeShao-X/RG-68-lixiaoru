<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/12/28
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加头像</title>
</head>
<body>
<h1>文件上传</h1>
<!-- 表单enctype属性指定数据返回服务器时的编码类型， multipart/form-data表示不对字符编码，上传文件时使用-->
<form method="post" action="/imageuploadServlet" enctype="multipart/form-data">
    请选择一个文件: <input type="file" name="uploadFile" />
    <br/><br/>
    <input type="submit" value="上传" />
</form>
</body>
</html>
