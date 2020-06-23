<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/12/28
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String sql = "select id,name,src from img_src";
    List<ImageBean> list = ImageDao.querySrc(sql);
    // 如果结果集不为空
    if (list.size() > 0) {
%>
<table>
    <th>id</th><th>名称</th><th>图片</th>
        <%
        for (ImageBean bean : list) {
    %>
    <tr>
        <td><%=bean.getId() %></td>
        <td><%=bean.getName() %></td>
        <!-- 这里 src 路径，要根据目录结构来确定，如果图片显示个X，大多是路径问题 -->
        <td><img style="width:50px;height:50px" src="<%=bean.getSrc()%>"></td>
    </tr>
        <%
        } // for
    }// if
     %>
</body>
</html>
