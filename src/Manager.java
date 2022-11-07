import java.util.Date;

public class Manager extends Employee {

    @Override
    public String toString() {
        return "Manager: " + super.toString();
    }

    public Manager(String name, String address, Date dateOfBirth, Account account, int salary) {
        super(name, address, dateOfBirth, account, salary);
    }

    public Manager() {
    }
    
}
