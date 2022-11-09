public class Bill {
    int id;
    int idCustomer;
    int idSalesman;
    int[] idProduct;
    int[] amount;
    int point;

    public Bill() {
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
    public void display() {
        
    }
}
