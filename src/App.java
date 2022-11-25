public class App {
    private static AccountList accountList = null;
    private static ProductList productList = null;
    private static BillList billList = null;
    private static final String ACCOUNTDATAPATH = "./data/AccountData";
    private static final String PRODUCTDATAPATH = "./data/ProductData";
    private static final String BILLDATAPATH = "./data/BillData";

    public static void init() {
        try {
            accountList = new AccountList(FileUtil.readDataFromFile(ACCOUNTDATAPATH));
            productList = new ProductList(FileUtil.readDataFromFile(PRODUCTDATAPATH));
            billList = new BillList(FileUtil.readDataFromFile(BILLDATAPATH));
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
        FileUtil.writeDataToFile(ACCOUNTDATAPATH, accountList);
        FileUtil.writeDataToFile(PRODUCTDATAPATH, productList);
        FileUtil.writeDataToFile(BILLDATAPATH, billList);
    }

    public static void main(String[] args) {
        init();
        start();
        end();
    }
}
