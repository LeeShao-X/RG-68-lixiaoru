package BusinessStatistics;

import commodityPage.Createfenye;
import commodityPage.mysql;
import BusinessStatistics.userbean;

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

@WebServlet("/StatisticsServlet")
public class StatisticsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        mysql my = new mysql();
        my.setConn();
        String sql = null;
        ResultSet rs = null;
        HttpSession session = request.getSession();
        ArrayList arrayList = new ArrayList();
        try {
            my.setStmt1(my.getConn().createStatement());
            sql = "select * from sall_product";
            rs = my.getStmt1().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {

            while (rs.next()) {
                BusinessStatistics.userbean userr = new userbean();
                userr.setUid(rs.getString("id"));
                userr.setUname(rs.getString("name"));
                userr.setUclass(rs.getString("class"));
                userr.setProvider(rs.getString("provider"));
                userr.setNum(rs.getString("num"));
                userr.setProfit(rs.getString("profit"));
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
        ArrayList ulook_List = new ArrayList(arrayList);
        session.setAttribute("arrayList", arrayList);
        session.setAttribute("sall_List", ulook_List);
        ArrayList fenye = new ArrayList();
        int sum = 0;
        if (arrayList != null)
            sum = arrayList.size();
        Createfenye.Create(fenye, sum);
        session.setAttribute("fenye", fenye);
        response.sendRedirect("/managers/sall_product.jsp?pages=1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
