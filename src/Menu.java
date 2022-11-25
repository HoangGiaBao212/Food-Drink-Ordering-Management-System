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

    private Menu() {
    }

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
            login();

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
            MenuContent.showMenuCustomer(currentAccount.getId());
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
                                int totalAll = bill.totalAll(currentProductList);
                                if (currentAccount.getId() != -1) {
                                    choice = -1;
                                    while (choice != 1 && choice != 2) {
                                        MenuContent.clearScreen();
                                        MenuContent.showMenuPoint(currentProductList, currentAccount, bill);
                                        choice = Menu.getChoice();
                                        int newPoint;
                                        int billPoint = totalAll / 100;
                                        int currentCustomerPoint = ((Customer) currentAccount.getPerson()).getPoint();
                                        switch (choice) {
                                            case 1:
                                                if (currentCustomerPoint >= totalAll)
                                                    totalAll = 0;
                                                else
                                                    totalAll -= currentCustomerPoint;
                                                newPoint = currentCustomerPoint - bill.totalAll(currentProductList);
                                                if (newPoint < 0)
                                                    newPoint = 0;
                                                newPoint += billPoint;
                                                ((Customer) currentAccount.getPerson()).setPoint(newPoint);
                                                currentAccountList.updateAccount(currentAccount.getId(),
                                                        currentAccount);
                                                currentBillList.append(bill);
                                                currentProductList.updateCountProductList(bill);
                                                MenuContent
                                                        .notification(String.format("Số tiền cần thành toán: %,d VND",
                                                                totalAll));
                                                MenuContent.notification("Thanh toán thành công!");
                                                break;
                                            case 2:
                                                newPoint = currentCustomerPoint + billPoint;
                                                ((Customer) currentAccount.getPerson()).setPoint(newPoint);
                                                currentAccountList.updateAccount(currentAccount.getId(),
                                                        currentAccount);
                                                currentBillList.append(bill);
                                                currentProductList.updateCountProductList(bill);
                                                MenuContent
                                                        .notification(String.format("Số tiền cần thành toán: %,d VND",
                                                                totalAll));
                                                MenuContent.notification("Thanh toán thành công!");
                                                break;
                                            default:
                                                break;
                                        }
                                    }

                                } else {
                                    currentBillList.append(bill);
                                    currentProductList.updateCountProductList(bill);
                                    MenuContent
                                            .notification(String.format("Số tiền cần thành toán: %,d VND",
                                                    totalAll));
                                    MenuContent.notification("Thanh toán thành công!");
                                }
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
                    if (currentAccount.getId() == -1) // -1 is id guest
                        break;
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
                                Account changeCustomerAccount = currentAccountList.getById(currentAccount.getId());
                                while (choice != 0) {
                                    MenuContent.clearScreen();
                                    MenuContent.showMenuCustomerChangeInfo(changeCustomerAccount);
                                    choice = getChoice();
                                    changeCustomerAccount.changeAttribute(choice);
                                    currentAccountList.updateAccount(currentAccount.getId(), changeCustomerAccount);
                                }
                                choice = -1;
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
                    bill.setIdCustomer(accountCustomer.getId());
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
                                int totalAll = bill.totalAll(currentProductList);
                                if (accountCustomer.getId() != -1) {
                                    choice = -1;
                                    while (choice != 1 && choice != 2) {
                                        MenuContent.clearScreen();
                                        MenuContent.showMenuPoint(currentProductList, accountCustomer, bill);
                                        choice = Menu.getChoice();
                                        int newPoint;
                                        int billPoint = totalAll / 100;
                                        int currentCustomerPoint = ((Customer) accountCustomer.getPerson()).getPoint();
                                        switch (choice) {
                                            case 1:
                                                if (currentCustomerPoint >= totalAll)
                                                    totalAll = 0;
                                                else
                                                    totalAll -= currentCustomerPoint;
                                                newPoint = currentCustomerPoint - bill.totalAll(currentProductList);
                                                if (newPoint < 0)
                                                    newPoint = 0;
                                                newPoint += billPoint;
                                                ((Customer) accountCustomer.getPerson()).setPoint(newPoint);
                                                currentAccountList.updateAccount(accountCustomer.getId(),
                                                        accountCustomer);
                                                currentBillList.append(bill);
                                                currentProductList.updateCountProductList(bill);
                                                MenuContent
                                                        .notification(String.format("Số tiền cần thành toán: %,d VND",
                                                                totalAll));
                                                MenuContent.notification("Thanh toán thành công!");
                                                break;
                                            case 2:
                                                newPoint = currentCustomerPoint + billPoint;
                                                ((Customer) accountCustomer.getPerson()).setPoint(newPoint);
                                                currentAccountList.updateAccount(accountCustomer.getId(),
                                                        accountCustomer);
                                                currentBillList.append(bill);
                                                currentProductList.updateCountProductList(bill);
                                                MenuContent
                                                        .notification(String.format("Số tiền cần thành toán: %,d VND",
                                                                totalAll));
                                                MenuContent.notification("Thanh toán thành công!");
                                                break;
                                            default:
                                                break;
                                        }
                                    }

                                } else {
                                    currentBillList.append(bill);
                                    currentProductList.updateCountProductList(bill);
                                    MenuContent
                                            .notification(String.format("Số tiền cần thành toán: %,d VND",
                                                    totalAll));
                                    MenuContent.notification("Thanh toán thành công!");
                                }
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
                                    MenuContent.notification("Id khách hàng không đúng!");
                                break;
                            case 3: // xóa
                                System.out.print("Nhập id sản phẩm cần xóa: ");
                                idSalesman = Menu.getInputNumber();
                                Account removeSalesmanAccount = currentAccountList.getById(idSalesman);
                                if (removeSalesmanAccount != null
                                        && removeSalesmanAccount.getPerson() instanceof Salesman) {
                                    currentAccountList.removeAccount(idSalesman);
                                    MenuContent.notification("Xoá nhân viên bán hàng thành công!");
                                } else
                                    MenuContent.notification("Id nhân viên bán hàng không đúng!");
                                break;
                            default:
                                break;
                        }
                    }
                    choice = -1;
                    break;
                case 3: // quản lý khách hàng
                    while (choice != 0) {
                        int idCustomer;
                        MenuContent.clearScreen();
                        MenuContent.showMenuManagerCustomer(currentAccountList);
                        choice = Menu.getChoice();
                        switch (choice) {
                            case 1: // thêm khách hàng
                                Account newCustomer = new Account();
                                newCustomer.setId(currentAccountList.getNewId());
                                newCustomer.input("Customer");
                                currentAccountList.append(newCustomer);
                                break;
                            case 2: // sửa
                                System.out.print("Nhập id khách hàng cần sửa: ");
                                idCustomer = Menu.getInputNumber();
                                Account changeCustomerAccount = currentAccountList.getById(idCustomer);
                                if (changeCustomerAccount != null
                                        && changeCustomerAccount.getPerson() instanceof Customer) {
                                    while (choice != 0) {
                                        MenuContent.clearScreen();
                                        MenuContent.showMenuManagerCustomer(changeCustomerAccount);
                                        choice = getChoice();
                                        changeCustomerAccount.changeAttribute(choice);
                                        currentAccountList.updateAccount(idCustomer, changeCustomerAccount);
                                    }
                                    choice = -1;
                                } else
                                    MenuContent.notification("Id nhân viên bán hàng không đúng!");
                                break;
                            case 3: // xóa
                                System.out.print("Nhập id khách hàng cần xóa: ");
                                idCustomer = Menu.getInputNumber();
                                Account removeCustomerAccount = currentAccountList.getById(idCustomer);
                                if (removeCustomerAccount != null
                                        && removeCustomerAccount.getPerson() instanceof Customer) {
                                    currentAccountList.removeAccount(idCustomer);
                                    MenuContent.notification("Xoá khách hàng thành công!");
                                } else
                                    MenuContent.notification("Id khách hàng không đúng!");
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

}