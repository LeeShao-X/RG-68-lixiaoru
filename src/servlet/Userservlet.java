package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Userdao;


@SuppressWarnings("serial")
public class Userservlet extends HttpServlet
{
    //当从jsp跳转到servlet类时，首先执行service函数（这是定理）
    protected void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
    {
        req.setCharacterEncoding("utf-8");//设置字符集，避免乱码
        //获取jsp界面需要进行的操作，
        String method = req.getParameter("method");
        if(method.equals("login"))//转到login函数
        {
            login(req,resp);
        }
    }
    protected void login(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
    {
        int  count=0;
        HttpSession session=req.getSession();
        String id = req.getParameter("id1");
        session.setAttribute("inputuid",id);
        String username = req.getParameter("username1");
        session.setAttribute("inputusername",username);
        String password = req.getParameter("password1");
        String se = req.getParameter("se");
        Userdao userdao = new Userdao();//创建Userdao的实例
        int flag = userdao.login(id,username, password,se);//用来判断是否登陆成功
        if(flag==1) {
            System.out.println("登录成功！");
            count++;
            session.setAttribute("count",count);
            resp.sendRedirect(req.getContextPath()+"/managers/cmain.html");
        }
        else if(flag==2) {
            System.out.println("登录成功！");
            resp.sendRedirect(req.getContextPath()+"/employ/u_mainframe.jsp");
        }
        else {
            System.out.println("登录失败！");
            resp.sendRedirect(req.getContextPath()+"/loginerror.jsp");
        }
    }

}