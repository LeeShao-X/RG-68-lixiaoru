package Fuzzyquery;

import message.messageBean;
import commodityPage.Createfenye;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@WebServlet("/mQueryServlet")
public class mQueryServlet extends HttpServlet {
    static public  String get(String str ,HttpServletRequest request)
    {
        String s=null;
        try {
            s= new String(request.getParameter(str).getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return  s;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String values=request.getParameter("values");
        //System.out.println("values="+values);
        HttpSession session=request.getSession();
        ArrayList arrayList=(ArrayList)session.getAttribute("arrayList");
        ArrayList message_List=(ArrayList)session.getAttribute("message_List");
        ArrayList fenye=(ArrayList)session.getAttribute("fenye");
        if(message_List!=null||message_List.size()!=0)
            message_List.clear();
        message_List=(ArrayList)arrayList.clone();
        if(fenye!=null||fenye.size()!=0)
            fenye.clear();
        if(message_List!=null&&values!=null)
        {//System.out.println("values3="+cashier_List.size());
            messageBean us=new messageBean();
            for(int i=0;i<message_List.size();i++)
            {
                //System.out.println("values4="+cashier_List.size());
                us=(messageBean) message_List.get(i);
                String str = us.getTime().toString();
                if(us.getId().contains(values))
                    continue;
                else if(us.getName().contains(values))
                    continue;
                else if(str.contains(values))
                    continue;
                else if(us.getTitle().contains(values))
                    continue;
                else if(us.getMessage().contains(values))
                    continue;
                message_List.remove(i);
                i--;

            }
            session.setAttribute("message_List",message_List);
            // System.out.println("values2="+values);
            int sum=0;
            if(message_List!=null)
                sum=message_List.size();
            Createfenye.Create(fenye,sum);
            session.setAttribute("fenye",fenye);
            //System.out.println("values1="+values);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
