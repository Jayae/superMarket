import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        boolean goOn = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("**************************Welcome To SuperMarket!**************************");

        while (goOn) {
            System.out.println("What do you need?" +
                    "\n1、开卡  2、改密  3、增加积分  4、积分兑换  5、查询  6、退出");
            String option = scanner.next();
            int i = Integer.parseInt(option);
            switch (i) {
                case 1:
                    VipManager.getInstance().add();
                    break;
                case 2:
                    VipManager.getInstance().changePw();
                    break;
                case 3:
                    VipManager.getInstance().addIntegral();
                    break;
                case 4:
                    VipManager.getInstance().exchange();
                    break;
                case 5:
                    VipManager.getInstance().info();
                    break;
                case 6:
                    goOn = false;
                    System.out.println("感谢使用本系统，再见！");
                    break;
                default:
                    break;
            }
            System.out.println();

        }

    }
}
