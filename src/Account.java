import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Account implements IAccount {
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
        /**
         * @TODO:
         *        [ ] show all info of account
         */

        // id
        // username
        // password
        // Ho va ten getPerson().getName()
        // Dia chi
        // ngay sinh
        // diem
        // ─ │ ┌ ┐ ┘ └ ┬ ┴ ┤ ├ ┼
        System.out.println("├────────────────────────────────────────────────────────────────────────────────────┤");
        System.out.println(String.format("│  %-12s :%-68s│", "Id", id));
        System.out.println(String.format("│  %-12s :%-68s│", "Username", username));
        System.out.println(String.format("│  %-12s :%-68s│", "Password", password));
        System.out.println(String.format("│  %-12s :%-68s│", "Họ và tên", person.getName()));
        System.out.println(String.format("│  %-12s :%-68s│", "Địa chỉ", person.getAddress()));
        System.out.println(String.format("│  %-12s :%-68s│", "Ngày sinh",
                new SimpleDateFormat("dd-MM-yyyy").format((person.getDateOfBirth()))));
        System.out.println(String.format("│  %-12s :%-68s│", "Điểm", ((Customer) person).getPoint()));
    }

    public void input() {
        System.out.print("Nhập username: ");
        username = scanner.nextLine();
        System.out.print("Nhập password: ");
        password = scanner.next();
    }

}