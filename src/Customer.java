import java.text.SimpleDateFormat;
import java.util.Date;

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

    public void display(String type) {
        switch (type.toLowerCase()) {
            case "info":
                /**
                 * @TODO: add case this
                 */
                break;
            case "list":

                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        return "Customer [name='" + name + "', address='" + address + "', dateOfBirth='"
                + new SimpleDateFormat("dd-MM-yyyy").format(dateOfBirth) + "', point='" + point + "']";
    }

}