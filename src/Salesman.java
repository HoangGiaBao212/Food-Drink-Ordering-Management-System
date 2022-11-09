import java.text.SimpleDateFormat;
import java.util.Date;

public class Salesman extends Employee {
    public Salesman() {
    }

    public Salesman(String name, String address, Date dateOfBirth, Account account, int salary) {
        super(name, address, dateOfBirth, account, salary);
    }

    @Override
    public String toString() {
        return "Salesman [name=" + name + ", address=" + address + ", dateOfBirth="
                + new SimpleDateFormat("dd-MM-yyyy").format(dateOfBirth) + ", salary=" + salary + "]";
    }
}
