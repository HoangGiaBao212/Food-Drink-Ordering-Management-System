import java.util.Date;

public class Person {
    private String name;
    private String address;
    private Date dateOfBirth;
    private Account account;

    public Person() {
    }

    public Person(String name, String address, Date dateOfBirth, Account account) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.account = account;
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
        return "Person [name=" + name + ", address=" + address + ", dateOfBirth=" + dateOfBirth + "]";
    }

}
