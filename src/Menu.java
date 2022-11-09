import java.util.Date;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static Account currentAccount = null;
    private static AccountList currentAccountList = null;
    private static ProductList currentProductList = null;
    private static BillList currentBillList = null;

    public static void setAccount(Account account) {
        currentAccount = account;
    }

    public static void setAccountList(AccountList accountList) {
        currentAccountList = accountList;
    }

    public static void setProductList(ProductList productList) {
        currentProductList = productList;
    }

    public static void setBillList(BillList billList) {
        currentBillList = billList;
    }
    
    public static void login() {
        int choice;
        MenuContent.clearScreen();
        MenuContent.showMenuLogin();
        choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            while (currentAccount == null) {
                System.out.println("Nhập username: ");
                String username = scanner.nextLine();
                System.out.println("Nhập password: ");
                String password = scanner.nextLine();
                currentAccount = currentAccountList.login(username, password);
                if (currentAccount == null) {
                    System.out.println("Đăng nhập thất bại, đăng nhập lại ?");
                    System.out.println("1. Có");
                    System.out.println("0. Không");
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 0)
                        break;
                }
            }
        }

        if (currentAccount == null) {
            System.out.println("Bạn đang dùng tài khoản khách");
            currentAccount = new Account(-1, "guest", "1234", new Customer("Guest", "VN", new Date(), null, 0));
        }
    }

    public static void showMenu() {
        if (currentAccount.getPerson() instanceof Customer) {
            MenuContent.showMenuPermissionCustomer();
        } else if (currentAccount.getPerson() instanceof Salesman) {
            MenuContent.showMenuPermissionSalesman();
        } else if (currentAccount.getPerson() instanceof Manager) {
            MenuContent.showMenuPermissionManager();
        }
    }

    public static void showMenuPermissionCustomer() {
        System.out.println("1. Hiện danh sách sản phẩm.");
        System.out.println("2. Thông tin người dùng.");
        System.out.println("0. Thoát.");
    }

    public static void showMenuPermissionSalesman() {
        System.out.println("1. Tạo hóa đơn.");
        System.out.println("2. Tra cứu thông tin người dùng.");
        System.out.println("3. Kết ca.");
        System.out.println("0. Thoát.");
    }

    public static void showMenuPermissionManager() {
        System.out.println("1. Quản lý Sản phẩm");
        System.out.println("2. Quản lý Nhân viên");
        System.out.println("3. Quản lý Người dùng");
        System.out.println("0. Thoát");
    }

    public static int showMenuProduct() {
        /**
         * TODO:
         * [] show header attributes of product
         * [] display by table
         * [] get id product
         * [] check id valid and exist
         * [] return id if valid
         */
        return -1;
    }

}