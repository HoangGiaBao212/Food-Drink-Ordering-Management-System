public class AccountUtil {
    static AccountList accountList = null;

    static public Account createAccount(char chosse) {
        Account tempAccount = new Account();
        Person tempPerson = new Person();
        /**
         * 0, Tạo tài khoản cho Khách
         * 1, Tạo tài khoản cho Salesman
         * 2, Tạo tài khoản cho Manager
         * Q, Thoát
         */
        tempAccount.input();

        if (Character.toUpperCase(chosse) == '0') {
            tempPerson = new Customer();
        } else if (Character.toUpperCase(chosse) == '1') {
            tempPerson = new Salesman();
        } else if (Character.toUpperCase(chosse) == '2') {
            tempPerson = new Manager();
        }
        tempPerson.input();

        tempAccount.setPerson(tempPerson);

        return tempAccount;
    }

    static public void updateAccount(Account account) {

    }

    public static void main(String[] args) {
        System.out.println(AccountUtil.createAccount('1'));
    }
}
