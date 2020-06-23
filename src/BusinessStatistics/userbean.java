package BusinessStatistics;

public class userbean {
    private  String uid;//商品编号
    private  String uname;//商品名称
    private  String uclass; //商品类别
    private  String provider;//制造厂商
    private  String num;//存货量

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    private  String profit; //商品类别
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUclass() {
        return uclass;
    }

    public void setUclass(String uclass) {
        this.uclass = uclass;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }


    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }


    public userbean() {
    }
}

