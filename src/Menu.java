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
                                bill.append(idProduct, amount);
                                break;
                            case 2:
                                boolean found;
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
                                            if (bill.changeAmount(idProduct, newAmount))
                                                MenuContent.notification("Thay đổi số lượng không thành công!");
                                            break;
                                        case 2:
                                            System.out.print("Nhập id sản phẩm: ");
                                            idProduct = Menu.getInputNumber();
                                            found = bill.delete(idProduct);
                                            if (!found)
                                                MenuContent.notification("Xóa không thành công!");
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
                    choice = -1;
                    break;
                case 2:
                    // Bill
                    while (choice != 0) {
                        MenuContent.clearScreen();
                        MenuContent.showMenuCustomerInfo(currentAccount);
                        choice = Menu.getChoice();
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
            choice = Menu.getChoice();
            System.out.println(choice);
            switch (choice) {
                case 1:
                    int idProduct;
                    int amount;
                    System.out.print("Nhập id sản phẩm: ");
                    idProduct = Menu.getInputNumber();
                    System.out.print("Nhập số lượng: ");
                    amount = Menu.getInputNumber();
                    break;
                case 2:
                    System.out.println(
                            "┌────────────────────────────────────────────────────────────────────────────────────┐");
                    System.out.printf("│%15s│%35s│%13s│%13s│\n", "Name", "Địa Chỉ", "Ngày sinh", "Điểm");
                    currentAccountList.display("Customer");
                    break;
                default:
                    break;
            }
        }

    }

    public static void menuManager() {
        int choice;
        while (true) {
            MenuContent.showMenuManager();
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