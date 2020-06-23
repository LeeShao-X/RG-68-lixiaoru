package liuyan;

import java.util.Date;
import message.messageBean;
import commodityPage.Createfenye;
import commodityPage.mysql;
import java.text.SimpleDateFormat;
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

@WebServlet("/liuyanServlet")
public class liuyanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        commodityPage.mysql my = new mysql();
        my.setConn();
        String sql = null;
        ResultSet rs = null;
        HttpSession session = request.getSession();
        ArrayList arrayList = new ArrayList();
        try {
            my.setStmt1(my.getConn().createStatement());
            sql = "select * from message";
            rs = my.getStmt1().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {


            while (rs.next()) {
                messageBean userr = new messageBean();
                userr.setId(rs.getString("mid"));
                userr.setName(rs.getString("mname"));
                String time = rs.getString("mtime");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = sdf.parse(time);
                userr.setTime(date);
                userr.setTitle(rs.getString("mtitle"));
                userr.setMessage(rs.getString("mmessage"));
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
        ArrayList message_List = new ArrayList(arrayList);
        session.setAttribute("arrayList", arrayList);
        session.setAttribute("message_List", message_List);
        ArrayList fenye = new ArrayList();
        int sum = 0;
        if (arrayList != null)
            sum = arrayList.size();
        Createfenye.Create(fenye, sum);
        session.setAttribute("fenye", fenye);
        response.sendRedirect("/managers/message.jsp?pages=1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
