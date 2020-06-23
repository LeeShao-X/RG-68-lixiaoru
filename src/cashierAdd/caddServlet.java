package cashierAdd;

import commodityPage.mysql;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/caddServlet")
public class caddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String Cid=request.getParameter("Cid");
        String Cname=new String(request.getParameter("Cname").getBytes("ISO-8859-1"), "utf-8");
        String Csex=new String(request.getParameter("Csex").getBytes("ISO-8859-1"), "utf-8");
        String Cage=request.getParameter("Cage");
        String Cmoney=request.getParameter("Cmoney");
        try {
            mysql my = new mysql();
            my.setConn();
            String sql = "select * from cashier where Cid=' "+Cid+" ' ";
            my.setStmt2(my.getConn().prepareStatement(sql));
            ResultSet rs = my.getStmt2().executeQuery();
            if(rs.next()){
                System.out.print("<script>alert('该员工已存在！');location='Cashier.jsp';</script>");
            }
            else {
                sql="insert into cashier(Cid,Cname,Csex,Cage,Cmoney) values(' "+Cid+" ',' "+Cname+" ',' "+Csex+" ',' "+Cage+" ','"+Cmoney+" ')";
                my.setStmt2(my.getConn().prepareStatement(sql));
                int n = my.getStmt2().executeUpdate();
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        response.sendRedirect("/CashierServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
