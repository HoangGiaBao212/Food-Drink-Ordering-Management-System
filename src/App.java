public class App {
    static Account currentAccount = null;
    static AccountList accountList = new AccountList();
    static ProductList productList = new ProductList();
    static PaymentList paymentList = new PaymentList();

    public static void init() {
        // @TODO Add init data
    }

    public static void start() {
        currentAccount = Menu.login();
    }

    public static void main(String[] args) {
        init();
        start();
    }
}
