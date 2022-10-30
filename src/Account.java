public class Account {
    private int id;
    private String acc, pass;
    public Account(int id, String acc, String pass) {
        this.id = id;
        this.acc = acc;
        this.pass = pass;
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
}