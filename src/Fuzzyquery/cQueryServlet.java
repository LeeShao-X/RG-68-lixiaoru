package Fuzzyquery;

import commodityPage.Createfenye;
import cashierPage.userbean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@WebServlet("/cQueryServlet")
public class cQueryServlet extends HttpServlet {
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
        ArrayList cashier_List=(ArrayList)session.getAttribute("cashier_List");
        ArrayList fenye=(ArrayList)session.getAttribute("fenye");
        if(cashier_List!=null||cashier_List.size()!=0)
            cashier_List.clear();
        cashier_List=(ArrayList)arrayList.clone();
        if(fenye!=null||fenye.size()!=0)
            fenye.clear();
        if(cashier_List!=null&&values!=null)
        {//System.out.println("values3="+cashier_List.size());
            userbean us=new userbean();
            for(int i=0;i<cashier_List.size();i++)
            {
                //System.out.println("values4="+cashier_List.size());
                us=(userbean)cashier_List.get(i);
                if(us.getCid().contains(values))
                    continue;
                else if(us.getCname().contains(values))
                    continue;
                else if(us.getCsex().contains(values))
                    continue;
                else if(us.getAge().contains(values))
                    continue;
                else if(us.getCmoney().contains(values))
                    continue;
                cashier_List.remove(i);
                i--;

            }
            session.setAttribute("cashier_List",cashier_List);
            // System.out.println("values2="+values);
            int sum=0;
            if(cashier_List!=null)
                sum=cashier_List.size();
            Createfenye.Create(fenye,sum);
            session.setAttribute("fenye",fenye);
            //System.out.println("values1="+values);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
