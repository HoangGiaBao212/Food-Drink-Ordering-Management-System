import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
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
            System.out.println("Có lỗi trong quá trình đọc dữ liệu!. Tạo dữ liệu mới?");
            System.out.println("1. Có");
            System.out.println("0. Không và thoát");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                accountList = new AccountList();
                productList = new ProductList();
                billList = new BillList();
            }
        }
    }

    public static void start() {
        Menu.setAccountList(accountList);
        Menu.login();
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
