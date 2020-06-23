package cashierPage;

import commodityPage.Createfenye;
import commodityPage.mysql;
import cashierPage.userbean;

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

@WebServlet("/CashierServlet")
public class CashierServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        commodityPage.mysql my = new mysql();
        my.setConn();
        String sql = null;
        ResultSet rs = null;
        HttpSession session = request.getSession();
        ArrayList arrayList = new ArrayList();
        try {
            my.setStmt1(my.getConn().createStatement());
            sql = "select * from cashier";
            rs = my.getStmt1().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                cashierPage.userbean userr = new userbean();
                userr.setCid(rs.getString("Cid"));
                userr.setCname(rs.getString("Cname"));
                userr.setCsex(rs.getString("Csex"));
                userr.setAge(rs.getString("Cage"));
                userr.setCmoney(rs.getString("Cmoney"));
                arrayList.add(userr);
            }
            rs.close();
            my.getStmt1().close();
            my.getConn().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList cashier_List = new ArrayList(arrayList);
        session.setAttribute("arrayList", arrayList);
        session.setAttribute("cashier_List", cashier_List);
        ArrayList fenye = new ArrayList();
        int sum = 0;
        if (arrayList != null)
            sum = arrayList.size();
        Createfenye.Create(fenye, sum);
        session.setAttribute("fenye", fenye);
        response.sendRedirect("/managers/Cashier.jsp?pages=1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}