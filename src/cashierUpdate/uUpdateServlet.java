package cashierUpdate;

import commodityPage.mysql;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/uUpdateServlet")
public class uUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String Cid=request.getParameter("Cid");
        String Cname=new String(request.getParameter("Cname").getBytes("ISO-8859-1"), "utf-8");
        String Csex=new String(request.getParameter("Csex").getBytes("ISO-8859-1"), "utf-8");
        String Cage=request.getParameter("Cage");
        String Cmoney=request.getParameter("Cmoney");
        if(Cid.equals("")){
            response.sendRedirect("/managers/Cashier_update.jsp");
        }
        else {
            try {
                mysql my = new mysql();
                my.setConn();
                String sql = "update cashier set Cid=' "+Cid+" ',Cname=' "+Cname+" ',Csex=' "+Csex+" ',Cage=' "+Cage+" ',Cmoney='"+Cmoney+" ' where Cid=' "+Cid+" ' ";
                my.setStmt2(my.getConn().prepareStatement(sql));
                int n = my.getStmt2().executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/CashierServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
