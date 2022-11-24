import java.io.Console;
import java.util.Date;
import java.util.Scanner;

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

    public static AccountList getCurrentAccountList() {
        return currentAccountList;
    }

    public static void setCurrentAccountList(AccountList currentAccountList) {
        Menu.currentAccountList = currentAccountList;
    }

    public static ProductList getCurrentProductList() {
        return currentProductList;
    }

    public static void setCurrentProductList(ProductList currentProductList) {
        Menu.currentProductList = currentProductList;
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
                // String password = Menu.getInput();
                String password = Menu.getInputPassword();
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
                menuCustomer();
            } else if (currentAccount.getPerson() instanceof Salesman) {
                menuSalesman();
            } else if (currentAccount.getPerson() instanceof Manager) {
                menuManager();
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

    public static String getInputPassword() {
        Console console = System.console();
        String password = "";
        for (char element : console.readPassword()) {
            password += element;
        }
        return password;
    }

    public static String getInput() {
        return scanner.nextLine();
    }

    public static void menuCustomer() {
        int choice = -1;
        while (choice != 0) {
            MenuContent.clearScreen();
            MenuContent.showMenuCustomer();
            choice = Menu.getChoice();
            Bill bill = new Bill();
            bill.setIdCustomer(currentAccount.getId());
            switch (choice) {
                case 1:
                    // Product
                    while (choice != 0) {
                        MenuContent.clearScreen();
                        MenuContent.showMenuCustomerProduct(currentProductList, bill);
                        choice = Menu.getChoice();
                        switch (choice) {
                            case 1:
                                int idProduct;
                                int amount;
                                System.out.print("Nhập id sản phẩm: ");
                                idProduct = Menu.getInputNumber();
                                System.out.print("Nhập số lượng: ");
                                amount = Menu.getInputNumber();
                                bill.append(idProduct, amount, currentProductList);
                                break;
                            case 2:
                                while (choice != 0) {
                                    MenuContent.clearScreen();
                                    MenuContent.showMenuCustomerProduct(bill, currentProductList);
                                    choice = Menu.getChoice();
                                    switch (choice) {
                                        case 1:
                                            int newAmount;
                                            System.out.print("Nhập id sản phẩm: ");
                                            idProduct = Menu.getInputNumber();
                                            System.out.print("Nhập số lượng: ");
                                            newAmount = Menu.getInputNumber();
                                            bill.changeAmount(idProduct, newAmount, currentProductList);
                                            break;
                                        case 2:
                                            System.out.print("Nhập id sản phẩm: ");
                                            idProduct = Menu.getInputNumber();
                                            bill.delete(idProduct);
                                            break;
                                        default:
                                            break;
                                    }
                                }
                                choice = -1;
                                break;
                            case 3:
                                currentProductList.updateProductList(bill);
                                currentBillList.append(bill);
                                MenuContent.notification("Thanh toán thành công!");
                                choice = 0;
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
                        MenuContent.showMenuCustomerInfo(currentAccount);
                        choice = Menu.getChoice();
                        switch (choice) {
                            case 1:
                                while (choice != 0) {
                                    MenuContent.clearScreen();
                                    MenuContent.showMenuCustomerPurchaseHistory(currentAccountList, currentProductList,
                                            currentBillList, currentAccount);
                                    choice = Menu.getChoice();
                                    switch (choice) {
                                        case 1:
                                            int idBill;
                                            System.out.print("Nhập id Bill: ");
                                            idBill = Menu.getInputNumber();
                                            Bill billFind = ((Bill) currentBillList.find(idBill,
                                                    currentAccount.getId()));
                                            if (billFind != null) {
                                                while (choice != 0) {
                                                    MenuContent.clearScreen();
                                                    MenuContent.showMenuCustomerPurchaseHistory(currentProductList,
                                                            billFind);
                                                    choice = Menu.getChoice();
                                                }
                                            } else
                                                MenuContent.notification("không tìm thấy hóa đơn!");
                                            choice = -1;
                                            break;
                                        default:
                                            break;
                                    }
                                }
                                choice = -1;
                                break;
                            case 2:
                                break;
                            default:
                                break;
                        }
                    }
                    choice = -1;
                    break;
                default:
                    break;
            }
        }

    }

    public static void menuSalesman() {
        int choice = -1;
        while (choice != 0) {
            MenuContent.showMenuSalesman();
            Bill bill = new Bill();
            AccountList accountList = new AccountList();
            choice = Menu.getChoice();
            System.out.println(choice);
            switch (choice) {
                case 1:
                    System.out.printf("Nhập thông tin người mua:");
                    int idProduct;
                    int amount;
                    System.out.print("Nhập id sản phẩm: ");
                    idProduct = Menu.getInputNumber();
                    System.out.print("Nhập số lượng: ");
                    amount = Menu.getInputNumber();
                    bill.append(idProduct, amount, currentProductList);
                    break;
                case 2: // chức năng hiện ds người dùng
                    MenuContent.showMenuCustomerListInfo();
                    currentAccountList.display("Customer");
                    System.out.println(
                            "├─────┴───────────┴───────────────────────────────────┴────────────────────┴─────────┤");
                    while (choice != 0) {
                        MenuContent.showMenuSearchCustomer();
                        choice = Menu.getChoice();
                        switch (choice) {
                            case 1:
                                int idCustomer;
                                System.out.printf("Nhập id Cần Tìm: ");
                                idCustomer = Menu.getInputNumber();
                                Account account = (Account) currentAccountList.findGetById(idCustomer);
                                if (account != null && account.getPerson() instanceof Customer)
                                    account.display();
                                else
                                    MenuContent.notification("Không tìm thấy id!");
                                choice = -1;
                                break;
                            case 2:
                                choice = -1;
                                break;
                        }
                    }
                    choice = -1;
                    break;
                default:
                    break;
            }
        }

    }

    public static void menuManager() {
        int choice = -1;
        while (choice != 0) {
            MenuContent.showMenuManager();
            choice = Menu.getChoice();
            Bill bill = new Bill();
            System.out.println(choice);
            switch (choice) {
                case 1: // quản lý sản phẩm
                    MenuContent.clearScreen();
                    MenuContent.showMenuManagerProduct(currentProductList, bill);
                    choice = Menu.getChoice();
                    switch (choice) {
                        case 1: // thêm sp
                        case 2: // sửa sp
                        case 3: // xóa sp
                        default:
                            break;
                    }
                    choice = -1;
                    break;
                case 2: // quản lý nhân viên
                    MenuContent.clearScreen();
                    MenuContent.showMenuSalesmanListInfo();
                    currentAccountList.display("Salesman");
                    System.out.println(
                            "├─────┴─────────────┴─────────────────────────────────┴────────────────────┴─────────┤");
                    MenuContent.showMenuManagerSalesman();
                    choice = Menu.getChoice();
                    switch (choice) {
                        case 1: // thêm nhân viên
                        case 2: // sửa
                        case 3: // xóa
                        default:
                            break;
                    }
                    choice = -1;
                    break;
                case 3: // quản lý khách hàng
                    MenuContent.clearScreen();
                    MenuContent.showMenuCustomerListInfo();
                    currentAccountList.display("Customer");
                    System.out.println(
                            "├─────┴───────────┴───────────────────────────────────┴────────────────────┴─────────┤");
                    MenuContent.showMenuManagerCustomer();
                    choice = Menu.getChoice();
                    switch (choice) {
                        case 1: // thêm khách hàng
                        case 2: // sửa
                        case 3: // xóa
                        default:
                            break;
                    }
                    choice = -1;
                    break;
                default:
                    break;
            }
        }
    }

}