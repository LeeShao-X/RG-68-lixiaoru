package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import DBUtil.DBUtil;

public class Userdao {
	public int login(String id ,String username,String password,String se)
    {
		String str1="guanli";
		String str2="shouyin";
        Connection conn = DBUtil.getConn();//这里就是从DBUtil类里面得到连接
        Statement state =null;
        ResultSet rs = null;
        int flag=0;
        try
        {
        	if(se.equals(str1)){
        		String sql = "select * from manager where id='"+id+"' and name='"+username+"'";//SQL语句,
        		state = conn.createStatement();
        		rs=state.executeQuery(sql);
            if(rs.next())
            {
                if(rs.getString("password").equals(password))
                {
                    flag=1;
                }
                rs.close();
            }
        	}
        	if(se.equals(str2)){
        		String sql = "select * from employ where id='"+id+"' and name='"+username+"'";//SQL语句,
        		state = conn.createStatement();
        		rs=state.executeQuery(sql);
            if(rs.next())
            {
                if(rs.getString("password").equals(password))
                {
                    flag=2;
                }
                rs.close();
            }
        	}
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        finally
        {
            DBUtil.close(rs, state, conn);
        }
        return flag;
    }
    

}