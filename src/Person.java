import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Person {
    private static final Scanner scanner = new Scanner(System.in);
    protected String name;
    protected String address;
    protected Date dateOfBirth;
    protected Account account;

    public Person() {
    }

    public Person(String name, String address, Date dateOfBirth, Account account) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.account = account;
        if (this.account != null)
            this.account.setPerson(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Person [name='" + name + "', address='" + address + "', dateOfBirth='" + new SimpleDateFormat("dd-MM-yyyy").format(dateOfBirth) + "']";
    }

    public void input() {
        System.out.print("Nhập tên: ");
        name = scanner.nextLine();

        System.out.print("Nhập địa chỉ: ");
        address = scanner.nextLine();

        SimpleDateFormat dateInput = new SimpleDateFormat("dd-MM-yyyy");
        while (dateOfBirth == null) {
            System.out.print("Nhập ngày sinh (dd-MM-yyyy): ");
            String strDate = scanner.nextLine();

            try {
                dateOfBirth = dateInput.parse(strDate);
                System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(dateOfBirth));
            } catch (Exception e) {
                System.out.println("Lỗi nhập, vui lòng nhập lại: ");
            }
        }

    }
}
