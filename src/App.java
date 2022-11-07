import java.util.Date;

public class App {
    static Account currentAccount = null;
    static AccountList accountList = new AccountList();
    static ProductList productList = new ProductList();
    static PaymentList paymentList = new PaymentList();

    public static void init() {
        // @TODO Add init data
    }

    public static void start() {
        accountList.append(new Account(
                -1,
                "root",
                "1234",
                new Manager(
                        "Root",
                        "VN",
                        new Date(),
                        null,
                        0)));
        Menu.setAccountList(accountList);
        currentAccount = Menu.login();
        Menu.setAccount(currentAccount);
        System.out.println(currentAccount);
        int choice = -1;
        while (choice != 0) {
            choice = Menu.showMenu();
        }
    }

    public static void main(String[] args) {
        init();
        start();
    }
}
