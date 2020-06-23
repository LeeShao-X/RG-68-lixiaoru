<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 99392
  Date: 2018/12/7
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="commodityPage.userbean"%>
<%@page import="commodityPage.fenyes"%>
<html>
<head>
    <title>商品信息总览</title>
    <style type="text/css">
        .fenye
        {
            float: left;
            margin-left: 10%;
            background-color: #ffffff;
            text-align:center;
        }
        .fenye li{
            line-height:30px;
            width: 30px;
            display: block;
            border: 1px solid rgba(7, 5, 11, 0.09);
            float: left;

        }
        .fenye li a{
            display: block;
            text-decoration:none;
            color: #999999;
        }
        .fenye li a:hover{
            background-color: rgba(7, 5, 11, 0.09);
            text-decoration:none;
        }
    </style>
</head>
<script src="../js/jquery.min.js"></script>
<script src="../js/jquery-3.3.1.js"></script>
<script type=text/javascript >
    $(document).ready(function() {
        var  str=window.location.search;
        var n;
        var spage = str.substr(str.lastIndexOf("=")+1);
        $("#ulook_page_"+spage).css({"color":"#ffffff","background-color":"aqua"})
    });
    function buttons_ulook1() {
        n=$(" input[ name='finds' ] ").val();
        if(n==""||n==null)
        {
            alert("输入不能为空！！！！");
        }
        $.ajax(
            {
                url:"/uQueryServlet",
                type:"POST",
                data:{ values:n},
                success:function (){
                    //  alert("000000");
                    pages=1;
                    window.location="ulook.jsp?pages=1";
                },
            });

    };



</script>
<body background="../images/mainbg.jpg" style="text-align: center;height: 100%;min-height: 500px;background-repeat:no-repeat ;
background-size:100% 100%;">
<%
    String pages=request.getParameter("pages");
    int Page=0;
    ArrayList fenye=(ArrayList) session.getAttribute("fenye");
    if(pages==null)
        Page=1;
    else if(fenye!=null&&fenye.size()!=0&&pages!=null)
        Page=Integer.parseInt(pages);
    int k=0;
    String[] str;
    if(Page!=0)
    {
        fenyes fen=(fenyes)fenye.get(Page-1);
        str=fen.getStr();
        k=fen.getAns();
%>
<div style="width:1100px;margin: 0 auto;">
<div style="width:1100px;margin-top: 100px;margin-left: auto;margin-bottom: 20px">
    <input style="height: 30px" type="text" name="finds" size="30" placeholder="商品编号/名称">
    <input type="button" style="width: 80px;
        padding:8px;
        background-color: #428bca;
        border-color: #357ebd;
        color: #fff;
        -moz-border-radius: 10px;
        -webkit-border-radius: 10px;
        border-radius: 10px; /* future proofing */
        -khtml-border-radius: 10px; /* for old Konqueror browsers */
        text-align: center;
        vertical-align: middle;
        border: 1px solid transparent;
        font-weight: 200;
        font-size:125%  " onclick="buttons_ulook1();" value="搜索">
    <input type="button" style="width: 80px;
        padding:8px;
        background-color: #428bca;
        border-color: #357ebd;
        color: #fff;
        -moz-border-radius: 10px;
        -webkit-border-radius: 10px;
        border-radius: 10px; /* future proofing */
        -khtml-border-radius: 10px; /* for old Konqueror browsers */
        text-align: center;
        vertical-align: middle;
        border: 1px solid transparent;
        font-weight: 200;
        font-size:125% " id="buttons_ulook2" value="全部">
</div>
<div>
<table border="2"bordercolor="black"cellpadding="5"  align="center">

    <tr>
    <th >商品编号</th>
    <th>商品名称</th>
    <th>商品类别</th>
    <th>制造厂商</th>
    <th >进货价</th>
    <th >出货价</th>
    <th>存货量</th>
    <th>描述</th>
    </tr>
    <%
            ArrayList array=(ArrayList)session.getAttribute("ulook_List");
            if(array==null)
                out.print("<script>alert(\"无此查询！！！！\")</script>");
            else if(Page>0){
                int sum=array.size();
                for(int i=(Page-1)*4;i<Page*4&&i<sum;i++)
                {
                    userbean us=(userbean)array.get(i);
    %>

    <tr>
        <td><%=us.getUid()%></td>
        <td><%=us.getUname()%></td>
        <td><%=us.getUclass()%></td>
        <td><%=us.getProvider()%></td>
        <td><%=us.getInprice()%></td>
        <td><%=us.getOutprice()%></td>
        <td><%=us.getNum()%></td>
        <td><%=us.getExp()%></td>

    </tr>
    <% } }
    %>
</table></div>
<div style="margin-left: 500px;height: 50px;">
    <ul class="fenye" style="padding-left: 0px;">
        <% if(Page!=1){%>
        <li><a href="ulook.jsp?pages=<%=(Page-1)%>">◀</a></li>
        <%}%>
        <% for(int i=0;i<k;i++){ if(str[i]!="..."){%>
        <li ><a href="ulook.jsp?pages=<%=str[i]%>" id="ulook_page_<%=str[i]%>"><%=str[i]%></a></li>
        <%} else{%>
        <li ><%=str[i]%></li>
        <%}}%>
        <% if(k>5&&str[5].equals("...")){%>
        <li><a href="ulook.jsp?pages=<%=(Page+1)%>">▶</a></li><%} }%>
    </ul>
</div>
</div>
</body>
</html>
