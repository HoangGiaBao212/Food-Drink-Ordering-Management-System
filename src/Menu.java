import java.io.Console;
import java.text.SimpleDateFormat;
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

    public static Date getInputDate() {
        Date date = null;
        String strDate = "";
        SimpleDateFormat dateInput = new SimpleDateFormat("dd-MM-yyyy");
        while (date == null) {
            System.out.print("Date (dd-MM-yyyy) > ");
            strDate = scanner.nextLine();
            try {
                date = dateInput.parse(strDate);
            } catch (Exception e) {
                System.out.println("Input không chính xác!!!");
            }
        }
        return date;
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
            // -2 is id Bot
            bill.setIdSalesman(-2);
            bill.setId(currentBillList.getNewId());
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
                                    MenuContent.showMenuCustomerProduct(bill, currentProductList, currentAccountList);
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
                                currentProductList.updateCountProductList(bill);
                                currentBillList.append(bill);
                                MenuContent.showMenuCustomerInfo(currentAccount);
                                if (currentAccount.getId() != 1) {
                                    MenuContent.showMenuCustomerInfo(currentAccount);
                                    MenuContent.showMenuPoint(currentAccount);
                                    choice = Menu.getChoice();
                                    switch (choice) {
                                        case 1: // sử dụng điểm: tổng tiền(totalall) - điểm của khách nếu bằng 1 số lớn
                                                // hơn bằng 0
                                                // thì đó là tiền cần thanh toán và số điểm của khách sẽ về tổng
                                                // tiền/100
                                                // ngược lại nếu nhỏ hơn 0 thì tiền thanh toán là 0 và điểm còn lại là
                                                // điểm của khách trừ đi tổng tiền cộng với tổng tiền /100
                                        case 2:
                                            // điểm khách sẽ cộng thêm tổng tiền /100
                                    }
                                }
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
                                                            billFind, currentAccountList);
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
            MenuContent.clearScreen();
            MenuContent.showMenuSalesman();
            choice = Menu.getChoice();
            int idCustomer;
            Account accountCustomer;
            switch (choice) {
                case 1:
                    Bill bill = new Bill();
                    bill.setId(currentBillList.getNewId());
                    bill.setIdSalesman(currentAccount.getId());
                    System.out.print("Nhập id khách hàng: ");
                    idCustomer = Menu.getInputNumber();
                    accountCustomer = currentAccountList.getById(idCustomer);
                    if (accountCustomer == null || accountCustomer.getPerson() instanceof Employee) {
                        MenuContent.notification("Không tìm thấy id!");
                        MenuContent.clearScreen();
                        MenuContent.showMenuSearchIdFailed();
                        choice = Menu.getChoice();
                        switch (choice) {
                            case 1:
                                accountCustomer = new Account(-1, "guest", "1234",
                                        new Customer("Guest", "VN", new Date(), null, 0));
                                break;
                            case 2:
                                choice = 0;
                        }
                    }
                    bill.setIdCustomer(idCustomer);
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
                                    MenuContent.showMenuCustomerProduct(bill, currentProductList, currentAccountList);
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
                                currentProductList.updateCountProductList(bill);
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
                case 2: // chức năng hiện ds người dùng
                    while (choice != 0) {
                        MenuContent.clearScreen();
                        MenuContent.showMenuCustomerListInfo(currentAccountList, "feature");
                        choice = Menu.getChoice();
                        switch (choice) {
                            case 1:
                                System.out.print("Nhập id cần Tìm: ");
                                idCustomer = Menu.getInputNumber();
                                accountCustomer = currentAccountList.getById(idCustomer);
                                if (accountCustomer != null && accountCustomer.getPerson() instanceof Customer) {
                                    while (choice != 0) {
                                        MenuContent.clearScreen();
                                        MenuContent.showMenuCustomerListInfo(accountCustomer);
                                        choice = Menu.getChoice();
                                    }
                                } else
                                    MenuContent.notification("Không tìm thấy id!");
                                choice = -1;
                                break;
                            case 2:
                                System.out.print("Nhập tên cần Tìm: ");
                                String name = scanner.nextLine();
                                AccountList accountList = new AccountList();
                                accountList.setArray(currentAccountList.getByString(name));
                                if (accountList.getArray().length != 0) {
                                    while (choice != 0) {
                                        MenuContent.clearScreen();
                                        MenuContent.showMenuCustomerListInfo(accountList, "noFeature");
                                        choice = Menu.getChoice();
                                    }
                                    choice = -1;
                                } else
                                    MenuContent.notification("Tên không tìm thấy!");
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
            MenuContent.clearScreen();
            MenuContent.showMenuManager();
            choice = Menu.getChoice();
            switch (choice) {
                case 1: // quản lý sản phẩm
                    while (choice != 0) {
                        int idProduct;
                        MenuContent.clearScreen();
                        MenuContent.showMenuManagerProduct(currentProductList);
                        choice = Menu.getChoice();
                        switch (choice) {
                            case 1: // thêm sp
                                Product newProduct = new Product();
                                newProduct.setId(currentProductList.getNewId());
                                newProduct.input();
                                currentProductList.append(newProduct);
                                break;
                            case 2: // sửa sp
                                System.out.print("Nhập id sản phẩm cần sửa: ");
                                idProduct = Menu.getInputNumber();
                                Product changeProduct = currentProductList.getById(idProduct);
                                if (changeProduct != null) {
                                    while (choice != 0) {
                                        MenuContent.clearScreen();
                                        MenuContent.showMenuManagerProduct(changeProduct);
                                        choice = getChoice();
                                        changeProduct.changeAttribute(choice);
                                        currentProductList.updateProduct(idProduct, changeProduct);
                                    }
                                    choice = -1;
                                } else
                                    MenuContent.notification("Id sản phẩm không đúng!");
                                break;
                            case 3: // xóa sp
                                System.out.print("Nhập id sản phẩm cần sửa: ");
                                idProduct = Menu.getInputNumber();
                                Product removeProduct = currentProductList.getById(idProduct);
                                if (removeProduct != null) {
                                    currentProductList.removeProduct(idProduct);
                                    MenuContent.notification("Xoá sản phẩm thành công!");
                                } else
                                    MenuContent.notification("Id sản phẩm không đúng!");
                                break;
                            default:
                                break;
                        }
                    }
                    choice = -1;
                    break;
                case 2: // quản lý nhân viên
                    while (choice != 0) {
                        int idSalesman;
                        MenuContent.clearScreen();
                        MenuContent.showMenuSalesmanListInfo(currentAccountList);
                        choice = Menu.getChoice();
                        switch (choice) {
                            case 1: // thêm nhân viên
                                Account newSalesman = new Account();
                                newSalesman.setId(currentAccountList.getNewId());
                                newSalesman.input("Salesman");
                                currentAccountList.append(newSalesman);
                                break;
                            case 2: // sửa
                                System.out.print("Nhập id nhân viên bán hàng cần sửa: ");
                                idSalesman = Menu.getInputNumber();
                                Account changeSalesmanAccount = currentAccountList.getById(idSalesman);
                                if (changeSalesmanAccount != null
                                        && changeSalesmanAccount.getPerson() instanceof Salesman) {
                                    while (choice != 0) {
                                        MenuContent.clearScreen();
                                        MenuContent.showMenuSalesmanListInfo(changeSalesmanAccount);
                                        choice = getChoice();
                                        changeSalesmanAccount.changeAttribute(choice);
                                        currentAccountList.updateAccount(idSalesman, changeSalesmanAccount);
                                    }
                                    choice = -1;
                                } else
                                    MenuContent.notification("Id sản phẩm không đúng!");
                                break;
                            case 3: // xóa
                            default:
                                break;
                        }
                    }
                    choice = -1;
                    break;
                case 3: // quản lý khách hàng
                    MenuContent.clearScreen();
                    // MenuContent.showMenuCustomerListInfo();
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