import java.util.Date;

public abstract class Person {
    private String name, adress;
    private Date birth;
    private Account account;

    public Person(String name, String adress, Date birth, Account account) {
        this.name = name;
        this.adress = adress;
        this.birth = birth;
        this.account = account;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
