import java.util.Date;

public class App {
    static Account currentAccount = null;
    static AccountList accountList = null;
    static ProductList productList = null;
    static BillList paymentList = null;

    public static void init() {
        accountList = new AccountList(FileUtil.readDataFromFile("src/AccountData.txt"));
        productList = new ProductList(FileUtil.readDataFromFile("src/ProductData.txt"));

    }

    public static void start() {
        Menu.setAccountList(accountList);
        currentAccount = Menu.login();
        Menu.setAccount(currentAccount);
        System.out.println(currentAccount);
        Menu.showMenu();
    }

    public static void end() {
        FileUtil.writeDataToFile("src/AccountData.txt", accountList);
        FileUtil.writeDataToFile("src/ProductData.txt", productList);
    }

    public static void main(String[] args) {
        init();
        start();
        end();
    }
}
