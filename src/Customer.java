import java.util.Date;

public class Customer extends Person {
    private int point;

    public Customer(int point) {
        this.point = point;
    }

    public Customer(String name, String address, Date dateOfBirth, Account account, int point) {
        super(name, address, dateOfBirth, account);
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}