import java.util.Date;
import java.util.Scanner;

public class Customer extends Person {
    private int point = 0;

    public Customer() {
    }

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

    public void input() {
        super.input();
    }

    @Override
    public String toString() {
        return super.toString() + "Customer [point=" + point + "]";
    }

}