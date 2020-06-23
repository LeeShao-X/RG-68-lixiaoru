package Fuzzyquery;

import commodityPage.Createfenye;
import kucunPage.userbean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@WebServlet("/kQueryServlet")
public class kQueryServlet extends HttpServlet {
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
        ArrayList kucun_List=(ArrayList)session.getAttribute("kucun_List");
        ArrayList fenye=(ArrayList)session.getAttribute("fenye");
        if(kucun_List!=null||kucun_List.size()!=0)
            kucun_List.clear();
        kucun_List=(ArrayList)arrayList.clone();
        if(fenye!=null||fenye.size()!=0)
            fenye.clear();
        if(kucun_List!=null&&values!=null)
        {//System.out.println("values3="+kucun_List.size());
            userbean us=new userbean();
            for(int i=0;i<kucun_List.size();i++)
            {
                //System.out.println("values4="+kucun_List.size());
                us=(userbean)kucun_List.get(i);
                if(us.getUid().contains(values))
                    continue;
                else if(us.getUname().contains(values))
                    continue;
                else if(us.getUclass().contains(values))
                    continue;
                else if(us.getProvider().contains(values))
                    continue;
                else if(us.getNum().contains(values))
                    continue;
                else if(us.getExp().contains(values))
                    continue;
                kucun_List.remove(i);
                i--;

            }
            session.setAttribute("kucun_List",kucun_List);
            //System.out.println("values2="+values);
            int sum=0;
            if(kucun_List!=null)
                sum=kucun_List.size();
            Createfenye.Create(fenye,sum);
            session.setAttribute("fenye",fenye);
            //System.out.println("values1="+values);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
