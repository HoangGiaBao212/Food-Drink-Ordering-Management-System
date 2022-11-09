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
        choice = Menu.getChoice();

        if (choice == 1) {
            while (currentAccount == null) {
                System.out.println("Nhập username: ");
                String username = Menu.getInput();
                System.out.println("Nhập password: ");
                String password = Menu.getInput();
                currentAccount = currentAccountList.login(username, password);
                if (currentAccount == null) {
                    MenuContent.showMenuLoginFailed();
                    choice = Menu.getChoice();
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
        while (true) {
            currentAccount = null;
            if (currentAccount == null) {
                login();
            }
            if (currentAccount.getPerson() instanceof Customer) {
                menuPermissionCustomer();
            } else if (currentAccount.getPerson() instanceof Salesman) {
                menuPermissionSalesman();
            } else if (currentAccount.getPerson() instanceof Manager) {
                menuPermissionManager();
            }
        }
    }

    public static int getChoice() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getInput() {
        return scanner.nextLine();
    }

    public static void menuPermissionCustomer() {
        int choice;
        while (true) {
            MenuContent.showMenuPermissionCustomer();
            choice = Menu.getChoice();
            System.out.println(choice);
            if (choice == 1) {
                MenuContent.showMenuPermissionCustomerProduct(currentProductList);
            } else if (choice == 2) {

                MenuContent.showMenuPermissionCustomerInfo(currentAccount);
            } else if (choice == 0) {
                choice = -1;
                break;
            }
        }
    }

    public static void menuPermissionSalesman() {
    }

    public static void menuPermissionManager() {
    }

}