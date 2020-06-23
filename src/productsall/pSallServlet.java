package productsall;

import commodityPage.Createfenye;
import commodityPage.mysql;
import commodityPage.userbean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

@WebServlet("/pSallServlet")
public class pSallServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        mysql my = new mysql();
        my.setConn();
        String sql = null;
        ResultSet rs = null;
        HttpSession session = request.getSession();
        String pidproduct=request.getParameter("idproduct");
        String idproduct=new String(pidproduct.getBytes("iso-8859-1"));

        String pproductname=request.getParameter("productname");
        String productname=new String(pproductname.getBytes("iso-8859-1"));

        String pamount=request.getParameter("add_amount");
        String amount=new String(pamount.getBytes("iso-8859-1"));
        List<userbean> arrayList = new ArrayList();
        userbean us = new userbean();
        if (session.getAttribute("arrayList") != null) {
            arrayList = (List<userbean>)session.getAttribute("arrayList");
        }
        try {
            my.setStmt1(my.getConn().createStatement());
            sql = "select * from product where id='"+idproduct+"'";
            rs = my.getStmt1().executeQuery(sql);
            int in=0,ou=0,mi=0,o=0;
            if(rs.next())
            {
                in=rs.getInt(5);
                ou=rs.getInt(6);
                int i=rs.getInt(7);
                int a= Integer.parseInt(amount);
                int k=i-a;
                my.setStmt2(my.getConn().prepareStatement(("update  product set num='"+k+"' where id='"+idproduct+"'")));
                int n = my.getStmt2().executeUpdate();
                userbean userr = new userbean();
                userr.setUid(rs.getString("id"));
                userr.setUname(rs.getString("uname"));
                userr.setUclass(rs.getString("class"));
                userr.setOutprice(rs.getString("outprice"));
                userr.setSallnum(a);
                int profit=ou*a;
                userr.setProfit(profit);
                arrayList.add(userr);
            }
            ResultSet rs2=my.getStmt1().executeQuery("select * from sall_product where id='"+idproduct+"'");
            if(rs2.next())
            {
                mi=ou-in;
                int j=rs2.getInt(5);
                int z=rs2.getInt(6);
                int a= Integer.parseInt(amount);
                int l=j+a;
                o=mi*a;
                z=o+z;
                my.setStmt2(my.getConn().prepareStatement(("update  sall_product set num='"+l+"',profit='"+z+"' where id='"+idproduct+"'")));
                int n = my.getStmt2().executeUpdate();
            }
            rs.close();
            my.getStmt1().close();
            my.getConn().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<userbean> sall_List = new ArrayList(arrayList);
        if (session.getAttribute("arrayList") != null) {
            sall_List =(List<userbean>)session.getAttribute("arrayList");
        }

        session.setAttribute("arrayList", arrayList);
        session.setAttribute("sall_List", sall_List);
        ArrayList fenye = new ArrayList();
        int sum = 0;
        if (arrayList != null)
            sum = arrayList.size();
        Createfenye.Create(fenye, sum);
        session.setAttribute("fenye", fenye);
        response.sendRedirect("/employ/u_sall.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
