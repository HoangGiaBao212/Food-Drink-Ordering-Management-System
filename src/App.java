import java.util.Scanner;

public class App {
    private static AccountList accountList = null;
    private static ProductList productList = null;
    private static BillList billList = null;

    public static void init() {
        try {
            accountList = new AccountList(FileUtil.readDataFromFile("src/AccountData.txt"));
            productList = new ProductList(FileUtil.readDataFromFile("src/ProductData.txt"));
            billList = new BillList(FileUtil.readDataFromFile("src/BillData.txt"));
        } catch (Exception e) {
            int choice = 0;
            MenuContent.showMenuReadDataFailed();
            choice = Menu.getChoice();
            if (choice == 1) {
                accountList = new AccountList();
                productList = new ProductList();
                billList = new BillList();
            }
        }
        Menu.setAccountList(accountList);
        Menu.setProductList(productList);
        Menu.setBillList(billList);
    }

    public static void start() {
        Menu.showMenu();
    }

    public static void end() {
        FileUtil.writeDataToFile("src/AccountData.txt", accountList);
        FileUtil.writeDataToFile("src/ProductData.txt", productList);
        FileUtil.writeDataToFile("src/BillData.txt", billList);
    }

    public static void main(String[] args) {
        init();
        start();
        end();
    }
}
