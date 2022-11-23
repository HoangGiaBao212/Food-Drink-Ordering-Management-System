public class AccountUtil {
    static AccountList accountList = null;

    static public Account createAccount(char choice) {
        Account tempAccount = new Account();
        Person tempPerson = null;
        /**
         * 0, Tạo tài khoản cho Khách
         * 1, Tạo tài khoản cho Salesman
         * 2, Tạo tài khoản cho Manager
         * Q, Thoát
         */
        tempAccount.input();

        if (Character.toUpperCase(choice) == '0') {
            tempPerson = new Customer();
        } else if (Character.toUpperCase(choice) == '1') {
            tempPerson = new Salesman();
        } else if (Character.toUpperCase(choice) == '2') {
            tempPerson = new Manager();
        }
        tempPerson.input();

        tempAccount.setPerson(tempPerson);

        return tempAccount;
    }

    static public void updateAccount(Account account) {
    }
}
