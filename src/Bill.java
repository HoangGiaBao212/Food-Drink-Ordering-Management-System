import java.util.Arrays;

public class Bill {
    int id;
    int idCustomer;
    int idSalesman;
    int[] idProduct;
    int[] amount;
    int point;

    public Bill() {
        id = -1;
        idCustomer = -1;
        idSalesman = -1;
        idProduct = new int[0];
        amount = new int[0];
        point = 0;
    }

    public Bill(int id, int idCustomer, int idSalesman, int[] idProduct, int[] amount, int point) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.idSalesman = idSalesman;
        this.idProduct = idProduct;
        this.amount = amount;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdSalesman() {
        return idSalesman;
    }

    public void setIdSalesman(int idSalesman) {
        this.idSalesman = idSalesman;
    }

    public int[] getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int[] idProduct) {
        this.idProduct = idProduct;
    }

    public int[] getAmount() {
        return amount;
    }

    public void setAmount(int[] amount) {
        this.amount = amount;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void append(int idProduct, int amount) {
        for (int i = 0; i < this.idProduct.length; i++) {
            if (this.idProduct[i] == idProduct) {
                this.amount[i] += amount;
                return;
            }
        }
        this.idProduct = Arrays.copyOf(this.idProduct, this.idProduct.length);
        this.amount = Arrays.copyOf(this.amount, this.amount.length);
        this.idProduct[this.idProduct.length - 1] = idProduct;
        this.amount[this.amount.length - 1] = amount;
    }

    public void display() {

    }
}
