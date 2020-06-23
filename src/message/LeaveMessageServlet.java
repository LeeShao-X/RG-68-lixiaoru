package message;

import commodityPage.mysql;

import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/LeaveMessageServlet")
public class LeaveMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        messageBean mb = new messageBean();
        String mid=(String)session.getAttribute("inputuid");

        String mname=(String)session.getAttribute("inputusername");

        mb.setTime(new Date(System.currentTimeMillis()));

        String mtitle=new String(request.getParameter("title").getBytes("ISO-8859-1"), "utf-8");

        String mmessage=new String(request.getParameter("message").getBytes("ISO-8859-1"), "utf-8");

        try {
            mysql my = new mysql();
            my.setConn();
            String sql="insert into message(mid,mname,mtime,mtitle,mmessage) values(' "+mid+" ',' "+mname+" ',' "+mb.getTime()+" ',' "+mtitle+" ','"+mmessage+" ')";
               my.setStmt2(my.getConn().prepareStatement(sql));
               int n = my.getStmt2().executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/employ/leavemessage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
