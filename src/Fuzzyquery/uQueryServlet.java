package Fuzzyquery;

import commodityPage.Createfenye;
import commodityPage.userbean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@WebServlet("/uQueryServlet")
public class uQueryServlet extends HttpServlet {
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
        ArrayList ulook_List=(ArrayList)session.getAttribute("ulook_List");
        ArrayList fenye=(ArrayList)session.getAttribute("fenye");
        if(ulook_List!=null||ulook_List.size()!=0)
            ulook_List.clear();
        ulook_List=(ArrayList)arrayList.clone();
        if(fenye!=null||fenye.size()!=0)
            fenye.clear();
        if(ulook_List!=null&&values!=null)
        {//System.out.println("values3="+clook_List.size());
            userbean us=new userbean();
            for(int i=0;i<ulook_List.size();i++)
            {
                //System.out.println("values4="+clook_List.size());
                us=(userbean)ulook_List.get(i);
                if(us.getUid().contains(values))
                    continue;
                else if(us.getUname().contains(values))
                    continue;
                else if(us.getUclass().contains(values))
                    continue;
                else if(us.getProvider().contains(values))
                    continue;
                else if(us.getInprice().contains(values))
                    continue;
                else if(us.getOutprice().contains(values))
                    continue;
                else if(us.getExp().contains(values))
                    continue;
                ulook_List.remove(i);
                i--;

            }
            session.setAttribute("ulook_List",ulook_List);
            // System.out.println("values2="+values);
            int sum=0;
            if(ulook_List!=null)
                sum=ulook_List.size();
            Createfenye.Create(fenye,sum);
            session.setAttribute("fenye",fenye);
            //System.out.println("values1="+values);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
