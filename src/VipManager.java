import java.text.SimpleDateFormat;
import java.util.*;

class VipManager {
    private Scanner scanner = new Scanner(System.in);

    private VipManager() {
    }

    private static VipManager vipManager;

    static VipManager getInstance() {
        return Objects.requireNonNullElseGet(vipManager, VipManager::new);
    }

    private static ArrayList<Vip> vips = new ArrayList<>();


    //验证
    private int checkVip() {

        System.out.println("请输入您的卡号：");
        String number = scanner.next();
        System.out.println("请输入您的密码：");
        String passWd = scanner.next();

        for (Vip v : vips) {
            if (v.getVipNumber().equals(number)) {
                if (v.checkPassWd(passWd)) {

                    System.out.println("认证成功！");
                    return vips.indexOf(v);
                } else {
                    System.out.println("密码错误！");
                    return -1;//密码错误
                }
            }
        }

        System.out.println("此账号不存在！");
        return -2;//ACCOUNT_NOT_EXIST

    }

    //开卡
    void add() {

        System.out.println("请输入您的名字：");
        String name = scanner.next();
        System.out.println("请输入您的密码：");
        String passWd = scanner.next();

        Vip mV = new Vip(name, passWd, new Date());
        vips.add(mV);
        System.out.println("创建成功！\n您的卡号为：" + mV.getVipNumber());
    }

    //改密
    void changePw() {


        int checkRes = checkVip();
        if (checkRes >= 0) {
            System.out.println("请输入新密码：");
            String newPw = scanner.next();
            System.out.println("请确认新密码：");
            String newPw1 = scanner.next();
            if (newPw.equals(newPw1)) {
                Vip mV = vips.get(checkRes);
                vips.remove(checkRes);
                mV.setVipPwd(newPw);
                vips.add(mV);
                System.out.println("密码修改成功！");
            }
        }

    }

    //增加积分
    void addIntegral() {
        int checkRes = checkVip();
        if (checkRes >= 0) {
            Vip mV = vips.get(checkRes);

            System.out.println("您当前的积分为：" + mV.getIntegral() + "\n您要添加多少积分？");
            int integral = scanner.nextInt();
            mV.setIntegral(mV.getIntegral() + integral);
            System.out.println("积分增加成功！您现在的积分为：" + mV.getIntegral());

        }

    }

    //积分兑换
    void exchange() {
        int checkRes = checkVip();
        if (checkRes >= 0) {
            Vip mV = vips.get(checkRes);
            System.out.println("您当前的积分为：" + mV.getIntegral() + "\n您要兑换多少积分？");
            int integral ;
            for (int i = 0; ; i++) {
                integral = scanner.nextInt();
                if (integral > mV.getIntegral()) {
                    System.out.println("超过您现有积分！请重新输入：");
                } else
                    break;
            }

            mV.setIntegral(mV.getIntegral() - integral);
            System.out.println("积分增加成功！您现在的积分为：" + mV.getIntegral());
        }
    }

    void info() {
        int checkRes = checkVip();
        if (checkRes >= 0) {
            Vip mV = vips.get(checkRes);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            System.out.println("用户名：" + mV.getVipName() + "\n账号：" + mV.getVipNumber() + "\n积分：" + mV.getIntegral() +
                    "\n账号创建日期" + simpleDateFormat.format(mV.getOpenDate()));
        }

    }

}
