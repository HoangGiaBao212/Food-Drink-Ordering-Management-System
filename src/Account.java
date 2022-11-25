import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Account {
    private static final Scanner scanner = new Scanner(System.in);
    private int id;
    private String username;
    private String password;
    private Person person;

    public Account() {
    }

    public Account(int id, String username, String password, Person person) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.person = person;
        if (this.person != null)
            this.person.setAccount(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean checkLogin(String password) {
        return (this.password).equals(password);
    }

    @Override
    public String toString() {

        return "Account [id='" + id + "', username='" + username + "', password='" + password + "', person='" + person
                + "']";

    }

    public void display() {
        System.out.println("├────────────────────────────────────────────────────────────────────────────────────┤");
        if (id == -1)
            System.out.println(String.format("│  %-12s :%-68s│", "Id", "Guess Account"));

        else
            System.out.println(String.format("│  %-12s :%-68s│", "Id", id));
        System.out.println(String.format("│  %-12s :%-68s│", "Username", username));
        System.out.println(String.format("│  %-12s :%-68s│", "Password", "*".repeat(password.length())));
        System.out.println(String.format("│  %-12s :%-68s│", "Họ và tên", person.getName()));
        System.out.println(String.format("│  %-12s :%-68s│", "Địa chỉ", person.getAddress()));
        System.out.println(String.format("│  %-12s :%-68s│", "Ngày sinh",
                new SimpleDateFormat("dd-MM-yyyy").format((person.getDateOfBirth()))));
        if (getPerson() instanceof Customer)
            System.out.println(String.format("│  %-12s :%-68s│", "Điểm", ((Customer) person).getPoint()));
        else
            System.out.println(String.format("│  %-12s :%-68s│", "Lương", ((Employee) person).getSalary()));

    }

    public void input() {
        System.out.print("Nhập username: ");
        username = scanner.nextLine();
        System.out.print("Nhập password: ");
        password = scanner.nextLine();
    }

    public void input(String person) {
        person = person.toLowerCase();
        if (!person.equals("customer") && !person.equals("salesman") && !person.equals("manager"))
            return;
        System.out.print("Nhập username: ");
        setUsername(scanner.nextLine());
        System.out.print("Nhập password: ");
        setPassword(scanner.nextLine());
        Person newPerson = null;
        switch (person) {
            case "customer" -> {
                newPerson = new Customer();
            }
            case "salesman" -> {
                newPerson = new Salesman();
            }
            case "manager" -> {
                newPerson = new Manager();
            }
            default -> {
                return;
            }
        }
        newPerson.input();
        newPerson.setAccount(this);
        setPerson(newPerson);
    }

    public void changeAttribute(int attribute) {
        Person newPerson = getPerson();
        switch (attribute) {
            case 1 -> {
                System.out.print("Nhập username: ");
                setUsername(scanner.nextLine());
            }
            case 2 -> {
                System.out.print("Nhập password: ");
                setPassword(scanner.nextLine());
            }
            case 3 -> {
                System.out.print("Nhập tên: ");
                newPerson.setName(scanner.nextLine());
                setPerson(newPerson);
            }
            case 4 -> {
                System.out.print("Nhập địa chỉ: ");
                newPerson.setAddress(scanner.nextLine());
                setPerson(newPerson);
            }
            case 5 -> {
                System.out.print("Nhập ngày sinh: ");
                newPerson.setDateOfBirth(Menu.getInputDate());
                setPerson(newPerson);
            }
            case 6 -> {
                if (newPerson instanceof Salesman) {
                    System.out.print("Nhập lương: ");
                    ((Salesman) newPerson).setSalary(Menu.getInputNumber());
                    setPerson(newPerson);
                } else if (newPerson instanceof Customer) {
                    System.out.print("Nhập điểm: ");
                    ((Customer) newPerson).setPoint(Menu.getInputNumber());
                    setPerson(newPerson);
                }
            }
        }
    }
}