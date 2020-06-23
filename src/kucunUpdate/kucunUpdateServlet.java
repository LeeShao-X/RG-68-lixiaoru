package kucunUpdate;

import commodityPage.mysql;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet( "/kucunUpdateServlet")
public class kucunUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String id=request.getParameter("id");
        String uname=new String(request.getParameter("uname").getBytes("ISO-8859-1"), "utf-8");
        String uclass=new String(request.getParameter("class").getBytes("ISO-8859-1"), "utf-8");
        String provider=new String(request.getParameter("provider").getBytes("ISO-8859-1"), "utf-8");
        String inprice=request.getParameter("inprice");
        String outprice=request.getParameter("outprice");
        String num=request.getParameter("num");
        String exp=new String(request.getParameter("exp").getBytes("ISO-8859-1"), "utf-8");
        if(id.equals(" ")){
            response.sendRedirect("/managers/change.jsp");
        }
        else {
            try {
                mysql my = new mysql();
                my.setConn();
                String sql = "update product set id=' "+id+" ',uname=' "+uname+" ',class=' "+uclass+" ',provider=' "+provider+" ',inprice='"+inprice+" ',outprice='"+outprice+" ',num='"+num+" ' ,exp='"+exp+" ' where id=' "+id+" ' ";
                my.setStmt2(my.getConn().prepareStatement(sql));
                int n = my.getStmt2().executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/kucunServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
