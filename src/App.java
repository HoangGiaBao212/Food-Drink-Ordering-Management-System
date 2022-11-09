import java.util.Date;

public class App {
    static Account currentAccount = null;
    static AccountList accountList = null;
    static ProductList productList = null;
    static PaymentList paymentList = null;

    public static void init() {
        accountList = new AccountList(FileUtil.readObjectFromFile("src/accountList.txt"));
    }

    public static void start() {
        Menu.setAccountList(accountList);
        currentAccount = Menu.login();
        Menu.setAccount(currentAccount);
        System.out.println(currentAccount);
        Menu.showMenu();
    }

    public static void main(String[] args) {
        init();
        start();
    }
}
