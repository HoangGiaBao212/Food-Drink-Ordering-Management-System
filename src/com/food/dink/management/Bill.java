package com.food.dink.management;

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
        if (product == null || product.checkOutOfDate()) {
            MenuContent.notification("Id sản phẩm không đúng!");
            return;
        }
        
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
        if (amount <= 0 || amount > product.getCount()) {
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
    }

    @Override
    public String toString() {
        return "Bill [id='" + id + "', idCustomer='" + idCustomer + "', idSalesman='" + idSalesman + "', idProduct='"
                + Arrays.toString(idProduct) + "', amount='" + Arrays.toString(amount) + "', point='" + point
                + "', paymentTime='" + new SimpleDateFormat("dd-MM-yyyy").format(paymentTime) + "']";
    }

    public int totalAll(ProductList productList) {
        int totalAll = 0;
        for (int i = 0; i < idProduct.length; i++) {
            Product product = (Product) productList.find(idProduct[i]);
            totalAll += product.getPrice() * amount[i];
        }
        return totalAll;
    }

    public void display(ProductList productList, AccountList accountList) {
        Account customer = accountList.getById(idCustomer);
        Account salesman = accountList.getById(idSalesman);
        int totalAll = totalAll(productList);
        setPoint(totalAll / 100);
        if (customer == null) {
            customer = new Account(-1, "guest", "1234", new Customer("Guest", "VN", new Date(), null, 0));
        }

        System.out.println("├────────────────────────────────────────────────────────────────────────────────────┤");
        System.out.println(String.format("│  %-15s: %-65d│", "Id Bill", id));
        System.out.println(String.format("│  %-15s: %-65s│", "Tên khách hàng", customer.getPerson().getName()));
        System.out.println(String.format("│  %-15s: %-65s│", "Tên nhân viên", salesman.getPerson().getName()));
        System.out.println(String.format("│  %-15s: %-65d│", "Điểm", point));
        System.out.println(String.format("│  %-15s: %-65s│", "Ngày",
                new SimpleDateFormat("dd-MM-yyyy").format(paymentTime)));
        System.out.println("├────┬────────────────────┬──────────────┬─────┬─────────────────────────────────────┤");
        System.out.println(
                String.format("│%-4s│%-20s│%-14s│%-5s│%-37s│", "Id", "Tên sản phẩm", "Giá gốc", "SL", "Thành tiền"));
        System.out.println("├────┼────────────────────┼──────────────┼─────┼─────────────────────────────────────┤");
        for (int i = 0; i < idProduct.length; i++) {
            Product product = (Product) productList.find(idProduct[i]);
            int total = product.getPrice() * amount[i];
            System.out.println(
                    String.format("│%-4d│%-20s│%-14s│%-5s│%-37s│", product.getId(), product.getName(),
                            product.getPrice(), amount[i], String.format("%,d", total)));
        }
        System.out.println("├────┴────────────────────┴──────────────┴─────┼─────────────────────────────────────┤");
        System.out.println(
                String.format("│  %-44s│%-37s│", "Tổng tiền thanh toán", String.format("%,d VND", totalAll)));
    }

}
