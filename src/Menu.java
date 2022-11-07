import java.util.Date;
import java.util.Scanner;

public class Menu {
    public static Scanner scanner = new Scanner(System.in);
    public static Account currentAccount = null;
    public static AccountList currentAccountList = null;

    public static void setAccount(Account account) {
        currentAccount = account;
    }
    public static void setAccountList(AccountList accountList){
        currentAccountList = accountList;
    }
    public static Account login() {
        System.out.println("Bạn có muốn đăng nhập không ?");
        System.out.println("1. Có");
        System.out.println("0. Không");
        int choice;
        choice = Integer.parseInt(scanner.nextLine());
        Account account = null;
        if (choice == 1) {
            while (account == null) {
                System.out.println("Nhập username: ");
                String username = scanner.nextLine();
                System.out.println("Nhập password: ");
                String password = scanner.nextLine();
                account = currentAccountList.login(username, password);
                if (account == null) {
                    System.out.println("Đăng nhập thất bại, đăng nhập lại ?");
                    System.out.println("1. Có");
                    System.out.println("0. Không");
                    choice = Integer.parseInt(scanner.nextLine());
                    if(choice == 0)
                        break;
                }
            }
        }
        if (account == null) {
            System.out.println("Bạn đang dùng tài khoản khách");
            account = new Account(-1, "guest", "1234", new Customer("Guest", "VN", new Date(), null, 0));
        }
        return account;
    }

    public static int showMenu() {
        if (currentAccount.getPerson() instanceof Customer) {
            return showMenuPermissionCustomer();
        } else if (currentAccount.getPerson() instanceof Manager) {
            return showMenuPermissionManager();
        } else if (currentAccount.getPerson() instanceof Salesman) {
            return showMenuPermissionSalesman();
        }
        return 0;
    }

    /**
     * Show permission customer function and return customer choice
     * 
     * @return int
     */
    public static int showMenuPermissionCustomer() {
        /**
         * TODO:
         * [x] display customer function list
         * [x] get customer choice
         * [x] check customer choice
         * [x] return customer choice if valid
         */
        System.out.println("1. Hiện danh sách sản phẩm.");
        System.out.println("2. Thông tin người dùng.");
        System.out.println("0. Thoát.");
        int customerChoice;
        do {
            System.out.print("Lựa chọn: ");
            customerChoice = Integer.parseInt(scanner.nextLine());
        } while (customerChoice < 0 || customerChoice > 2);
        return customerChoice;
    }

    /**
     * Show table product list and return id product selected
     * 
     * @return int
     */
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

    /**
     * show permission salesman function and return salesman choice
     * 
     * @return int
     */
    public static int showMenuPermissionSalesman() {
        /**
         * TODO:
         * [x] display salesman function list
         * [x] get salesman choice
         * [x] check salesman choice
         * [x] return salesman choice if valid
         */
        System.out.println("1. Tạo hóa đơn.");
        System.out.println("2. Tra cứu thông tin người dùng.");
        System.out.println("3. Kết ca.");
        System.out.println("0. Thoát.");

        int choice;
        do {
            System.out.print("Lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
        } while (choice < 0 || choice > 3);
        return choice;
    }

    public static int showMenuPermissionManager() {
        /**
         * TODO:
         * [x] display manager function list
         * [x] get manager choice
         * [x] check manager choice
         * [x] return manager choice if valid
         */
        System.out.println("1. Tạo hóa đơn.");
        System.out.println("2. Tra cứu thông tin người dùng.");
        System.out.println("3. Kết ca.");
        System.out.println("0. Thoát.");

        int choice;
        do {
            System.out.print("Lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
        } while (choice < 0 || choice > 3);
        return choice;
    }
}