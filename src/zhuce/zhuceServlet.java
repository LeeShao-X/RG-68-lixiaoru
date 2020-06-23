package zhuce;

import commodityPage.mysql;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/zhuceServlet")
public class zhuceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String uid=request.getParameter("uid");
        String uname=new String(request.getParameter("uname").getBytes("ISO-8859-1"), "utf-8");
        String uname1=uname.trim();
        String usex=new String(request.getParameter("usex").getBytes("ISO-8859-1"), "utf-8");
        String uage=request.getParameter("uage");
        String upwd=request.getParameter("upwd");
        try {
            mysql my = new mysql();
            my.setConn();
            String sql = "select * from employ where id=' "+uid+" ' ";
            my.setStmt2(my.getConn().prepareStatement(sql));
            ResultSet rs = my.getStmt2().executeQuery();
            if(rs.next()){
                System.out.print("<script>alert('该员工已存在！');location='zhuce.html';</script>");
            }
            else {
                sql="insert into employ (id,name,password,Csex,Cage,Cmoney) values(' "+uid+" ',' "+uname1+" ',' "+upwd+" ',' "+usex+" ',' "+uage+" ','"+2000+" ')";
                my.setStmt2(my.getConn().prepareStatement(sql));
                int n = my.getStmt2().executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("<script>alert('创建成功！');</script>");
        response.sendRedirect("/login.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
