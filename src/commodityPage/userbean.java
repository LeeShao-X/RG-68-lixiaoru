package commodityPage;

public class userbean {
    private  String uid;//商品编号
    private  String uname;//商品名称
    private  String uclass; //商品类别
    private  String provider;//制造厂商
    private  String inprice;//进货价
    private  String outprice;//出货价
    private  int num;//存货量
    private  String exp;//商品全名
    private int sallnum;//出售量
    private int profit;//利润

    public int getSallnum() {
        return sallnum;
    }

    public void setSallnum(int sallnum) {
        this.sallnum = sallnum;
    }

    public int getProfit() {
        return profit;
    }
    public void setProfit(int profit) {
        this.profit = profit;
    }

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

    public String getInprice() {
        return inprice;
    }

    public void setInprice(String inprice) {
        this.inprice = inprice;
    }

    public String getOutprice() {
        return outprice;
    }

    public void setOutprice(String outprice) {
        this.outprice = outprice;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public userbean() {
    }
}

