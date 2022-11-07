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

    @Override
    public String toString() {
        return "Account [id=" + id + ", username=" + username + ", password=" + password + ", person=" + person + "]";
    }

    public void input() {

        System.out.print("Nhập username: ");
        username = scanner.nextLine();
        System.out.print("Nhập password: ");
        password = scanner.next();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    }
}