import java.util.Date;

public class Person {
    private String name, adress;
    private Date birth;

    public Person(String name, String adress, Date birth) {
        this.name = name;
        this.adress = adress;
        this.birth = birth;
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

}
