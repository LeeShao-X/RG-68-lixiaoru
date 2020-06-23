package kucunPage;

import commodityPage.Createfenye;
import commodityPage.mysql;
import kucunPage.userbean;

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

@WebServlet("/kucunServlet")
public class kucunServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        mysql my = new mysql();
        my.setConn();
        String sql = null;
        ResultSet rs = null;
        HttpSession session = request.getSession();
        ArrayList arrayList = new ArrayList();
        try {
            my.setStmt1(my.getConn().createStatement());
            sql = "select * from product";
            rs = my.getStmt1().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {

            while (rs.next()) {
                userbean userr = new userbean();
                userr.setUid(rs.getString("id"));
                userr.setUname(rs.getString("uname"));
                userr.setUclass(rs.getString("class"));
                userr.setProvider(rs.getString("provider"));
                userr.setNum(rs.getString("num"));
                userr.setExp(rs.getString("exp"));
                // userr.setUtype(rs.getInt("utype"));
                //System.out.println(userr.getUcarnum());
                arrayList.add(userr);
            }
            rs.close();
            my.getStmt1().close();
            my.getConn().close();

        } catch (Exception e) {

            e.printStackTrace();
        }
        ArrayList kucun_List = new ArrayList(arrayList);
        session.setAttribute("arrayList", arrayList);
        session.setAttribute("kucun_List", kucun_List);
        ArrayList fenye = new ArrayList();
        int sum = 0;
        if (arrayList != null)
            sum = arrayList.size();
        Createfenye.Create(fenye, sum);
        session.setAttribute("fenye", fenye);
        response.sendRedirect("/managers/kucun.jsp?pages=1");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
