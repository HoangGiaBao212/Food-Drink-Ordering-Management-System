import java.text.Format;
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
    public void display(){
        /**
         * @TODO:
         * [ ] show all info of account
         */

// id
// username
// password
// Ho va ten getPerson().getName()
// Dia chi
// ngay sinh
// diem
System.out.printf(String.format("%-13d%-25s%-10s%20s\n",id,username,password,getPerson()));



    }
    public void input() {
        System.out.print("Nhập username: ");
        username = scanner.nextLine();
        System.out.print("Nhập password: ");
        password = scanner.next();
    }
 public static void main(String [] args )
 {
    System.out.printf("%-13s%-25s%-10s%12s\n","id ","username ","password","Person ");
 }
}