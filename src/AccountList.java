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

    public Object findGetById(int id) {
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
            Person person = ((Account) object).getPerson();
            switch (type) {
                case "Customer":
                    if (person instanceof Customer) {
                        System.out.println(String.format("│%5d│%11s│%35s│%20s│%9d│", ((Account) object).getId(),
                                person.getName(), ((Customer) person).address,
                                new SimpleDateFormat("dd-MM-yyyy").format(((Customer) person).getDateOfBirth()),
                                ((Customer) person).getPoint()));
                    }
                    break;
                case "Salesman":
                    if (person instanceof Salesman) {
                        System.out.println(String.format("│%5d│%13s│%33s│%20s│%9d│", ((Account) object).getId(),
                                person.getName(), ((Salesman) person).address,
                                new SimpleDateFormat("dd-MM-yyyy").format(((Salesman) person).getDateOfBirth()),
                                ((Salesman) person).getSalary()));
                    }
                    break;
                case "Manager":
                    if (person instanceof Manager) {
                        System.out.println(String.format("│%5d│%11s│%35s│%20s│%9d│", ((Account) object).getId(),
                                ((Manager) person).getName(), ((Manager) person).address,
                                new SimpleDateFormat("dd-MM-yyyy").format(((Manager) person).getDateOfBirth()),
                                ((Manager) person).getSalary()));
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
