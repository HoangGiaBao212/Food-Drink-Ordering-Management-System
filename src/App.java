import java.util.Scanner;

public class App {
    private static AccountList accountList = null;
    private static ProductList productList = null;
    private static BillList billList = null;
    private static final String AccountDataPath = "./AccountData";
    private static final String ProductDataPath = "./AccountData";
    private static final String BillDataPath = "./AccountData";

    public static void init() {
        try {
            accountList = new AccountList(FileUtil.readDataFromFile(AccountDataPath));
            productList = new ProductList(FileUtil.readDataFromFile(ProductDataPath));
            billList = new BillList(FileUtil.readDataFromFile(BillDataPath));
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
        FileUtil.writeDataToFile(AccountDataPath, accountList);
        FileUtil.writeDataToFile(ProductDataPath, productList);
        FileUtil.writeDataToFile(BillDataPath, billList);
    }

    public static void main(String[] args) {
        init();
        start();
        end();
    }
}
