public class Account {
    private int id;
    private String acc;
    private String pass;
    private Person person;

    public Account(int id, String acc, String pass, Person person) {
        this.id = id;
        this.acc = acc;
        this.pass = pass;
        this.person = person;

    }

    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;

    }
}