import java.util.Date;
import java.text.SimpleDateFormat;

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

    public Product(int id, String name, int price, int count, String category, String brand, Date MFG, Date EXP) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product [id='" + id + "', name='" + name + "', price='" + price + "', count='" + count + "', category='"
                + category + "', brand='" + brand + "', MFG='" + new SimpleDateFormat("dd-MM-yyyy").format(MFG)
                + "', EXP='"
                + new SimpleDateFormat("dd-MM-yyyy").format(EXP) + "']";
    }

}
