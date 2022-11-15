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
            Person person = ((Account)object).getPerson();
            switch (type) {
                case "Customer":
                    if (person instanceof Customer) {
                        // person.display("list");
                        System.out.printf("|%15s|%40s|%40s|\n", ((Customer) person).name,  ((Customer)person).address);
                    }
                    break;
                case "Salesman":
                    if (person instanceof Salesman) {
                        System.out.printf("|%15s|%40s\n", ((Salesman)person).name, ((Salesman)person ).salary );
                    }
                    break;
                case "Manager":
                    if (person instanceof Manager) {
                        System.out.printf("|%15s|%40s|\n ",((Manager)person).name,(( Manager)person).salary);
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

