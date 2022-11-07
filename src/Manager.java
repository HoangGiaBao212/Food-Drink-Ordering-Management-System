import java.util.Date;

public class Manager extends Employee{
    protected int level = 0;

    public Manager(String name, String address, Date dateOfBirth, Account account, int salary, int level) {
        super(name, address, dateOfBirth, account, salary);
        this.level = level;
    }

    public Manager(int salary, int level) {
        super(salary);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Manager [level=" + level + "]";
    }
    
}
