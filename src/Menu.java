import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
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
        MenuContent.showMenuLogin();
        choice = Menu.getChoice();

        if (choice == 1) {
            while (currentAccount == null) {
                System.out.print("Nhập username: ");
                String username = Menu.getInput();
                System.out.print("Nhập password: ");
                String password = Menu.getInput();
                currentAccount = currentAccountList.login(username, password);
                if (currentAccount == null) {
                    MenuContent.clearScreen();
                    MenuContent.showMenuLoginFailed();
                    choice = Menu.getChoice();
                    if (choice == 0)
                        break;
                }
            }
        } else if (choice == -1) {
            System.out.println("Kết thúc phiên!");
            return;
        }

        if (currentAccount == null) {
            MenuContent.notification("Bạn đang dùng tài khoản khách");
            currentAccount = new Account(-1, "guest", "1234", new Customer("Guest", "VN", new Date(), null, 0));
        } else {
            MenuContent.notification("Xin chào " + currentAccount.getPerson().getName() + " !");
        }
    }

    public static void showMenu() {
        while (true) {
            MenuContent.clearScreen();
            currentAccount = null;
            if (currentAccount == null) {
                login();
            }
            if (currentAccount == null) {
                return;
            } else if (currentAccount.getPerson() instanceof Customer) {
                menuPermissionCustomer();
            } else if (currentAccount.getPerson() instanceof Salesman) {
                menuPermissionSalesman();
            } else if (currentAccount.getPerson() instanceof Manager) {
                menuPermissionManager();
            }
        }
    }

    public static int getChoice() {
        int choice;
        if (currentAccount == null) {
            System.out.print("User > ");
        } else {
            System.out.print(currentAccount.getUsername().substring(0, 1).toUpperCase()
                    + currentAccount.getUsername().substring(1).toLowerCase() + " > ");
        }
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                return choice;
            } catch (Exception e) {
                System.out.println("Input không chính xác!!!");
            }
        }
    }
    public static int getInputNumber() {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                return choice;
            } catch (Exception e) {
                System.out.println("Input không chính xác!!!");
            }
        }
    }
    public static String getInput() {
        return scanner.nextLine();
    }

    public static void menuPermissionCustomer() {
        int choice = -1;
        while (choice != 0) {
            MenuContent.clearScreen();
            MenuContent.showMenuPermissionCustomer();
            choice = Menu.getChoice();
            Bill bill = new Bill();
            bill.setIdCustomer(currentAccount.getId());
            switch (choice) {
                case 1:
                    // Product
                    while (choice != 0) {
                        MenuContent.clearScreen();
                        MenuContent.showMenuPermissionCustomerProduct(currentProductList);
                        choice = Menu.getChoice();
                        switch (choice) {
                            case 1:
                                int idProduct;
                                int amount;
                                System.out.print("Nhập id sản phẩm: ");
                                idProduct = Menu.getChoice();
                                System.out.print("Nhập số lượng: ");
                                amount = Menu.getChoice();
                                bill.append(idProduct, amount);
                                break;
                            case 2:
                                break;
                            default:
                                break;
                        }
                    }
                    choice = -1;
                    break;
                case 2:
                    // Bill
                    while (choice != 0) {
                        MenuContent.clearScreen();
                        MenuContent.showMenuPermissionCustomerInfo(currentAccount);
                        choice = Menu.getChoice();
                    }
                    choice = -1;
                    break;
                default:
                    break;
            }
        }
    }

    public static void menuPermissionSalesman() {

    }

    public static void menuPermissionManager() {
        int choice;
        while (true) {
            MenuContent.showMenuPermissionManager();
            choice = Menu.getChoice();
            System.out.println(choice);
            if (choice == 1) {
            } else if (choice == 2) {
            } else if (choice == 0) {
                choice = -1;
                break;
            }
        }
    }

}