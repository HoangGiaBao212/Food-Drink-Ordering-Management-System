package com.food.dink.management;

import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ProductList extends ArrayList implements IGetable<Product> {
    ProductList() {
    }

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    ProductList(ArrayList arrayList) {
        super(arrayList);
    }

    public Object search(String string) {
        for (Object object : array) {
            if (((Product) object).getName().indexOf(string) != -1) {
                return object;
            }
        }
        return null;
    }

    public void updateCountProductList(Bill bill) {
        for (int i = 0; i < bill.getIdProduct().length; i++) {
            for (Object object : array) {
                if (bill.getIdProduct()[i] == ((Product) object).getId()) {
                    ((Product) object).setCount(((Product) object).getCount() - bill.getAmount()[i]);
                    break;
                }
            }
        }
    }

    public void updateProduct(int idProduct, Product newProduct) {
        for (int i = 0; i < array.length; i++)
            if (((Product) array[i]).getId() == idProduct) {
                array[i] = newProduct;
                break;
            }
    }

    public void removeProduct(int idProduct) {
        for (int i = 0; i < array.length; i++)
            if (((Product) array[i]).getId() == idProduct) {
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array = Arrays.copyOf(array, array.length - 1);
                break;
            }
    }

    public int getNewId() {
        int id = 0;

        try {
            id = ((Product) array[array.length - 1]).getId() + 1;
            while (getById(id) != null) {
                id++;
            }
        } catch (Exception e) {
            // id = 0
        }

        return id;
    }

    public void display(Bill bill) {

        System.out.println("├────┬───────────────┬───────┬──────────┬────────────┬────────────┬─────┬────────────┤");
        System.out.println(String.format("│%-4s│%-15s│%-7s│%-10s│%-12s│%-12s│%-5s│%-12s│", "id", "Tên", "Loại", "Hiệu",
                "NSX", "HSD", "SL", "Giá"));
        System.out.println("├────┼───────────────┼───────┼──────────┼────────────┼────────────┼─────┼────────────┤");

        for (Object object : array) {
            if (((Product) object).checkOutOfDate())
                continue;
            System.out.println(
                    String.format("│%-4s│%-15s│%-7s│%-10s│%-12s│%-12s│%-5s│%-12s│", ((Product) object).getId(),
                            ((Product) object).getName(),
                            ((Product) object).getCategory(),
                            ((Product) object).getBrand(),
                            new SimpleDateFormat("dd-MM-yyyy").format(((Product) object).getMFG()),
                            new SimpleDateFormat("dd-MM-yyyy").format(((Product) object).getEXP()),
                            ((Product) object).getCount(),
                            ((Product) object).getPrice()));
        }
        System.out.println("├────┼───────────────┼───────┼──────────┼────────────┼────────────┼─────┼────────────┤");
        if (bill.getIdProduct().length == 0)
            return;

        for (int i = 0; i < bill.getIdProduct().length; i++) {
            Product product = this.getById(bill.getIdProduct()[i]);
            int total = bill.getAmount()[i] * product.getPrice();
            System.out.println(
                    String.format("│%-4s│%-15s│%-7s│%-10s│%-12s│%-12s│%-5s│%-12s│",
                            product.getId(),
                            product.getName(),
                            product.getCategory(),
                            product.getBrand(),
                            new SimpleDateFormat("dd-MM-yyyy").format(product.getMFG()),
                            new SimpleDateFormat("dd-MM-yyyy").format(product.getEXP()),
                            bill.getAmount()[i],
                            String.format("%,d VND", total)));
        }
    }

    public void display() {
        System.out.println("├────┬───────────────┬───────┬──────────┬────────────┬────────────┬─────┬────────────┤");
        System.out.println(String.format("│%-4s│%-15s│%-7s│%-10s│%-12s│%-12s│%-5s│%-12s│", "id", "Tên", "Loại", "Hiệu",
                "NSX", "HSD", "SL", "Giá"));
        System.out.println("├────┼───────────────┼───────┼──────────┼────────────┼────────────┼─────┼────────────┤");

        for (Object object : array) {
            if (((Product) object).checkOutOfDate()) {
                System.out.println(
                        String.format(ANSI_RED + "│%-4s│%-15s│%-7s│%-10s│%-12s│%-12s│%-5s│%-12s│" + ANSI_RESET,
                                ((Product) object).getId(),
                                ((Product) object).getName(),
                                ((Product) object).getCategory(),
                                ((Product) object).getBrand(),
                                new SimpleDateFormat("dd-MM-yyyy").format(((Product) object).getMFG()),
                                new SimpleDateFormat("dd-MM-yyyy").format(((Product) object).getEXP()),
                                ((Product) object).getCount(),
                                ((Product) object).getPrice()));

            } else {
                System.out.println(
                        String.format("│%-4s│%-15s│%-7s│%-10s│%-12s│%-12s│%-5s│%-12s│", ((Product) object).getId(),
                                ((Product) object).getName(),
                                ((Product) object).getCategory(),
                                ((Product) object).getBrand(),
                                new SimpleDateFormat("dd-MM-yyyy").format(((Product) object).getMFG()),
                                new SimpleDateFormat("dd-MM-yyyy").format(((Product) object).getEXP()),
                                ((Product) object).getCount(),
                                ((Product) object).getPrice()));
            }
        }

    }

    @Override
    public Product getById(int id) {
        for (Object object : array) {
            if (((Product) object).getId() == id) {
                return (Product) object;
            }
        }
        return null;
    }

    @Override
    public Product[] getByString(String string, String type) {
        Product[] products = new Product[0];
        for (Object object : array) {
            if (type.equals("absolute")) {
                if (((Product) object).getName().equalsIgnoreCase(string)) {
                    products = Arrays.copyOf(products, products.length + 1);
                    products[products.length - 1] = (Product) object;
                }
            } else {
                if (((Product) object).getName().toLowerCase().contains(string.toLowerCase()) ||
                        ((Product) object).getCategory().toLowerCase().contains(string.toLowerCase()) ||
                        ((Product) object).getBrand().toLowerCase().contains(string.toLowerCase())) {
                    products = Arrays.copyOf(products, products.length + 1);
                    products[products.length - 1] = (Product) object;
                }
            }
        }
        return products;
    }
}