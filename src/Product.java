import java.util.Date;

public class Product {
    private int id;
    private String name;
    private int price;
    private int count;
    private String category;
    private String brand;
    private Date MFG;
    private Date EXP;

    public Product() {
    }

    public Product(int id, String name, int price, int count, String brand, Date MFG, Date EXP) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.brand = brand;
        this.MFG = MFG;
        this.EXP = EXP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getMFG() {
        return MFG;
    }

    public void setMFG(Date MFG) {
        this.MFG = MFG;
    }

    public Date getEXP() {
        return EXP;
    }

    public void setEXP(Date EXP) {
        this.EXP = EXP;
    }
}
