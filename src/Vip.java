import java.util.Date;
import java.util.HashSet;

class Vip {
    private String vipName;
    private String vipNumber;
    private String vipPwd;

    Date getOpenDate() {
        return openDate;
    }

    private Date openDate;

    int getIntegral() {
        return integral;
    }

    void setIntegral(int integral) {
        this.integral = integral;
    }

    private int integral;

    private static HashSet<String> vipNumberSet=new HashSet<>();

    Vip(String vipName, String vipPwd, Date openDate) {

        this.vipName = vipName;
        this.vipPwd = vipPwd;
        this.openDate = openDate;
        this.integral = 100;
        do {
            vipNumber = (int)(Math.random()*10000 )+ "";
        } while (vipNumberSet.contains(vipNumber));
        vipNumberSet.add(vipNumber);
    }

    boolean checkPassWd(String passWd) {
        return passWd.equals(this.vipPwd);
    }

    void setVipPwd(String vipPwd) {
        this.vipPwd = vipPwd;
    }

    String getVipNumber() {
        return vipNumber;
    }

    String getVipName() {
        return vipName;
    }


}
