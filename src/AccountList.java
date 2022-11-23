import java.util.Date;
import java.text.SimpleDateFormat;
public class AccountList extends ArrayList {

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

    public Object find(int id) {
        for (Object object : array) {
            if (((Account) object).getId() == id) {
                return object;
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

    public void display(String type) {
        for (Object object : array) {
            // Account account =  ((Account) object).getId();
            Person person = ((Account) object).getPerson();
            switch (type) {
                case "Customer":
                    if (person instanceof Customer) {
                        System.out.printf("│%5d│%11s│%35s│%20s│%9d│\n",((Account) object).getId(), ((Customer) person).getName(), ((Customer) person).address, new SimpleDateFormat("dd-MM-yyyy").format(((Customer) person).getDateOfBirth()), ((Customer) person).getPoint() );
                    }
                    break;
                case "Salesman":
                    if (person instanceof Salesman) {
                        System.out.printf("│%15s│%35s│\n", ((Salesman) person).name, ((Salesman) person).salary);
                    }
                    break;
                case "Manager":
                    if (person instanceof Manager) {
                        System.out.printf("│%15s│%35s│\n", ((Manager) person).name, ((Manager) person).salary);
                    }
                    break;
                default:
                    /**
                     * @TODO:
                     *        fix later
                     */
                    break;
            }
        }
    }

}
