package com.food.dink.management;
public class App {
    private static AccountList accountList = null;
    private static ProductList productList = null;
    private static BillList billList = null;
    private static final String ACCOUNT_DATA_PATH = "./data/AccountData";
    private static final String PRODUCT_DATA_PATH = "./data/ProductData";
    private static final String BILL_DATA_PATH = "./data/BillData";

    public static void init() {
        try {
            accountList = new AccountList(FileUtil.readDataFromFile(ACCOUNT_DATA_PATH));
            productList = new ProductList(FileUtil.readDataFromFile(PRODUCT_DATA_PATH));
            billList = new BillList(FileUtil.readDataFromFile(BILL_DATA_PATH));
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
        FileUtil.writeDataToFile(ACCOUNT_DATA_PATH, accountList);
        FileUtil.writeDataToFile(PRODUCT_DATA_PATH, productList);
        FileUtil.writeDataToFile(BILL_DATA_PATH, billList);
    }

    public static void main(String[] args) {
        init();
        start();
        end();
    }
}
