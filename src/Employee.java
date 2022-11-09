import java.util.Date;

abstract class Employee extends Person {
    protected int salary;

    public int getSalary() {
        return salary;
    }

    protected Employee() {
    }

    protected Employee(String name, String address, Date dateOfBirth, Account account, int salary) {
        super(name, address, dateOfBirth, account);
        this.salary = salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}