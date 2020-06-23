package commodityPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class mysql {
    private String url="jdbc:mysql://localhost:3306/supermarket?useUnicode=true&characterEncoding=utf-8";
    private String user="root";
    private String password="123456";
    private String driverName="com.mysql.jdbc.Driver";
    private Connection conn=null;
    private Statement stmt1=null;
    private PreparedStatement stmt2=null;
    public Statement getStmt1() {
        return stmt1;
    }

    public void setStmt1(Statement stmt1) {
        this.stmt1 = stmt1;
    }

    public PreparedStatement getStmt2() {
        return stmt2;
    }

    public void setStmt2(PreparedStatement stmt2) {
        this.stmt2 = stmt2;
    }


    public Connection getConn() {
        return conn;
    }

    public void setConn() {
        this.conn = getConnection();
    }


    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDriverName() {
        return driverName;
    }
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    public Connection getConnection()
    {
        try {
            Class.forName(driverName);
            return DriverManager.getConnection(url,user,password);
        }catch(Exception e)
        {

        }
        return null;
    }
}
