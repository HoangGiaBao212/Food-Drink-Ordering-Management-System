import java.util.Date;

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
}
