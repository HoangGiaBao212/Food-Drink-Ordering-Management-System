import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Bill {
    int id;
    int idCustomer;
    int idSalesman;
    int[] idProduct;
    int[] amount;
    int point;
    Date paymentTime;

    public Bill() {
        id = -1;
        idCustomer = -1;
        idSalesman = -1;
        idProduct = new int[0];
        amount = new int[0];
        point = 0;
        paymentTime = new Date();
    }

    public Bill(int id, int idCustomer, int idSalesman, int[] idProduct, int[] amount, int point, Date paymentTime) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.idSalesman = idSalesman;
        this.idProduct = idProduct;
        this.amount = amount;
        this.point = point;
        this.paymentTime = paymentTime;
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

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public void append(int idProduct, int amount, ProductList productList) {
        Product product = (Product) productList.find(idProduct);
        for (int i = 0; i < this.idProduct.length; i++) {
            if (this.idProduct[i] == idProduct) {
                if (this.amount[i] + amount > product.getCount()) {
                    MenuContent.notification("Không đủ số lượng!");
                    return;
                }
                this.amount[i] += amount;
                if (this.amount[i] <= 0)
                    this.delete(idProduct);
                return;
            }
        }
        if (amount > product.getCount()) {
            MenuContent.notification("Không đủ số lượng!");
            return;
        }
        this.idProduct = Arrays.copyOf(this.idProduct, this.idProduct.length + 1);
        this.amount = Arrays.copyOf(this.amount, this.amount.length + 1);
        this.idProduct[this.idProduct.length - 1] = idProduct;
        this.amount[this.amount.length - 1] = amount;
    }

    public void delete(int idProduct) {
        for (int i = 0; i < this.idProduct.length; i++) {
            if (this.idProduct[i] == idProduct) {
                for (int j = i; j < this.idProduct.length - 1; j++) {
                    this.idProduct[j] = this.idProduct[j + 1];
                    this.amount[j] = this.amount[j + 1];
                }
                this.idProduct = Arrays.copyOf(this.idProduct, this.idProduct.length - 1);
                this.amount = Arrays.copyOf(this.amount, this.amount.length - 1);
                return;
            }
        }
        MenuContent.notification("Không tìm thấy sản phẩm!");
        return;
    }

    public void changeAmount(int idProduct, int newAmount, ProductList productList) {
        for (int i = 0; i < this.idProduct.length; i++) {
            if (this.idProduct[i] == idProduct) {
                if (newAmount > ((Product) productList.find(idProduct)).getCount()) {
                    MenuContent.notification("Không đủ số lượng!");
                    return;
                }
                this.amount[i] = newAmount;
                return;
            }
        }
        MenuContent.notification("Không tìm thấy sản phẩm!");
        return;
    }

    @Override
    public String toString() {
        return "Bill [id='" + id + "', idCustomer='" + idCustomer + "', idSalesman='" + idSalesman + "', idProduct='"
                + Arrays.toString(idProduct) + "', amount='" + Arrays.toString(amount) + "', point='" + point
                + "', paymentTime='" + new SimpleDateFormat("dd-MM-yyyy").format(paymentTime) + "']";
    }

    /**
     * This method
     */
    public void display(ProductList productList) {
        System.out.println("├────────────────────────────────────────────────────────────────────────────────────┤");
        System.out.println(String.format("│  %-15s:%-66d│", "id", id));
        System.out.println(String.format("│  %-15s:%-66d│", "Ten khach hang", idCustomer));
        System.out.println(String.format("│  %-15s:%-66d│", "Ten nhan vien", idSalesman));
        System.out.println(String.format("│  %-15s:%-66d│", "Diem", point));
        System.out.println(String.format("│  %-15s:%-66s│", "Ngay",
                new SimpleDateFormat("dd-MM-yyyy").format(paymentTime)));
        System.out.println("├────┬────────────────────┬──────────────┬─────┬─────────────────────────────────────┤");
        System.out.println(
                String.format("│%-4s│%-20s│%-14s│%-5s│%-37s│", "Id", "Ten san pham", "Gia goc", "SL", "Thanh Tien"));
        System.out.println("├────┼────────────────────┼──────────────┼─────┼─────────────────────────────────────┤");
        int totalAll = 0;
        for (int i = 0; i < idProduct.length; i++) {
            Product product = (Product) productList.find(idProduct[i]);
            int total = product.getPrice() * amount[i];
            totalAll += total;
            System.out.println(
                    String.format("│%-4d│%-20s│%-14s│%-5s│%-37s│", product.getId(), product.getName(),
                            product.getPrice(), amount[i], String.format("%,d", total)));
        }
        System.out.println("├────┴────────────────────┴──────────────┴─────┼─────────────────────────────────────┤");
        System.out.println(
                String.format("│  %-44s│%-37s│", "Tong tien thanh toan", String.format("%,d VND", totalAll)));
    }

}
