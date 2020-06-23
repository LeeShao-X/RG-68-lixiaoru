<%@ page import="java.util.ArrayList" %>
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
        $("#sall_page_"+spage).css({"color":"#ffffff","background-color":"aqua"})
    });
</script>
<body background="../images/mainbg.jpg" style="text-align: center;height: 100%;min-height: 500px;background-repeat:no-repeat ;
background-size:100% 100%;">
<%int zong=0;%>
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
<p><font color="red"><a href="u_sall.jsp" >继续添加</a></font></p>
<div style="width:1100px;margin: 0 auto;">
    <div>
        <table border="2"bordercolor="black"cellpadding="5"  align="center">
            <tr>
            <th >商品编号</th>
            <th>商品名称</th>
            <th>商品类别</th>
            <th>价格</th>
            <th>数量</th>
            <th>金额</th>
            </tr>
            <%
                ArrayList array=(ArrayList)session.getAttribute("sall_List");
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
                <td><%=us.getOutprice()%></td>
                <td><%=us.getSallnum()%></td>
                <td><%=us.getProfit()%></td>
            </tr>
            <%
                    } for(int i=0;i<sum;i++){
                    userbean us=(userbean)array.get(i);
                        zong+=us.getProfit();}
                }
            %>
        </table></div>
    <div style="margin-left: 500px;height: 50px;">
        <ul class="fenye" style="padding-left: 0px;">
            <% if(Page!=1){%>
            <li><a href="u_sall3.jsp?pages=<%=(Page-1)%>">◀</a></li>
            <%}%>
            <% for(int i=0;i<k;i++){ if(str[i]!="..."){%>
            <li ><a href="u_sall3.jsp?pages=<%=str[i]%>" id="sall_page_<%=str[i]%>"><%=str[i]%></a></li>
            <%} else{%>
            <li ><%=str[i]%></li>
            <%}}%>
            <% if(k>5&&str[5].equals("...")){%>
            <li><a href="u_sall3.jsp?pages=<%=(Page+1)%>">▶</a></li><%} }%>
        </ul>
    </div>
    <p style="font-size:15px;text-align:center; color:red" ><strong>您本次消费的总金额为：<%=zong%>元</strong></p>
</div>
</body>
</html>
