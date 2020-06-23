package bean;

public class UserBean {
	private String id;
	private String username;//用户名
    private String password;//密码都是与数据库匹配的，下面是set和get函数
    private String se;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSe() {
		return se;
	}
	public void setSe(String se) {
		this.se = se;
	}

}