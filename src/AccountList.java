import java.util.Arrays;
import java.text.SimpleDateFormat;

public class AccountList extends ArrayList implements IGetable<Account> {

    public AccountList() {
    }

    public AccountList(ArrayList arrayList) {
        super(arrayList);
    }

    public Account login(String username, String password) {
        for (Object object : array) {
            if (((Account) object).getUsername().equals(username) && ((Account) object).checkLogin(password)) {
                return (Account) object;
            }
        }
        return null;
    }

    public Object search(String string) {
        for (Object object : array) {
            if (((Account) object).getPerson().getName().indexOf(string) != -1) {
                return object;
            }
        }
        return null;
    }

    public int getNewId() {
        int id = 0;

        try {
            id = ((Account) array[array.length - 1]).getId() + 1;
            while (getById(id) != null) {
                id++;
            }
        } catch (Exception e) {
            id = 0;
        }

        return id;
    }

    public void updateAccount(int idSalesman, Account newAccount) {
        for (int i = 0; i < array.length; i++)
            if (((Account) array[i]).getId() == idSalesman) {
                array[i] = newAccount;
                break;
            }
    }

    public void removeAccount(int idAccount) {
        for (int i = 0; i < array.length; i++)
            if (((Account) array[i]).getId() == idAccount) {
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array = Arrays.copyOf(array, array.length - 1);
                break;
            }
    }

    public void display(String type) {
        for (Object object : array) {
            Person person = ((Account) object).getPerson();
            switch (type) {
                case "Customer":
                    if (person instanceof Customer) {
                        System.out.println(String.format("│%-4s│%-20s│%-34s│%-12s│%-10s│", ((Account) object).getId(),
                                person.getName(), ((Customer) person).address,
                                new SimpleDateFormat("dd-MM-yyyy").format(((Customer) person).getDateOfBirth()),
                                ((Customer) person).getPoint()));
                    }
                    break;
                case "Salesman":
                    if (((Account) object).getId() == -2)// -2 is bot id
                        continue;
                    if (person instanceof Salesman) {
                        System.out.println(String.format("│%-4s│%-20s│%-34s│%-12s│%-10s│", ((Account) object).getId(),
                                person.getName(), ((Salesman) person).address,
                                new SimpleDateFormat("dd-MM-yyyy").format(((Salesman) person).getDateOfBirth()),
                                ((Salesman) person).getSalary()));
                    }
                    break;
                case "Manager":
                    if (person instanceof Manager) {
                        System.out.println(String.format("│%-4s│%-20s│%-34s│%-12s│%-10s│", ((Account) object).getId(),
                                ((Manager) person).getName(), ((Manager) person).address,
                                new SimpleDateFormat("dd-MM-yyyy").format(((Manager) person).getDateOfBirth()),
                                ((Manager) person).getSalary()));
                    }
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public Account getById(int id) {
        for (Object object : array) {
            if (((Account) object).getId() == id) {
                return (Account) object;
            }
        }
        return null;
    }

    @Override
    public Account[] getByString(String string) {
        Account[] accounts = new Account[0];

        for (Object object : array) {
            if (((Account) object).getUsername().contains(string) ||
                    ((Account) object).getPerson().getName().toLowerCase().contains(string.toLowerCase())) {
                accounts = Arrays.copyOf(accounts, accounts.length + 1);
                accounts[accounts.length - 1] = (Account) object;
            }
        }
        return accounts;
    }

}
