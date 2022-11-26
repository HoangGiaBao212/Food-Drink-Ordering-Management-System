package com.food.dink.management;

import java.util.Date;
import java.util.Scanner;
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
    static Scanner scanner = new Scanner(System.in);

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
        while (price <= 0) {
            System.out.print("Nhập giá: ");
            price = Menu.getInputNumber();
        }
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        while (count < 0) {
            System.out.print("Nhập số lượng: ");
            count = Menu.getInputNumber();
        }
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
        while (!category.equals("Food") && !category.equals("Drink")) {
            System.out.print("Nhập loại: ");
            category = scanner.nextLine();
        }
        this.category = category;
    }

    public void input() {
        System.out.print("Nhập tên: ");
        setName(scanner.nextLine());
        System.out.print("Nhập giá: ");
        setPrice(Menu.getInputNumber());
        System.out.print("Nhập số lượng: ");
        setCount(Menu.getInputNumber());
        System.out.print("Nhập loại: ");
        setCategory(scanner.nextLine());
        System.out.print("Nhập thương hiệu: ");
        setBrand(scanner.nextLine());
        System.out.print("Nhập ngày sản xuất: ");
        setMFG(Menu.getInputDate());
        do {
            System.out.print("Nhập hạn sử dụng: ");
            setEXP(Menu.getInputDate());
            if (EXP.after(MFG) == false)
                System.out.println("Nhập hạn sử dụng không đúng!");
        } while (EXP.after(MFG) == false);
    }

    public void changeAttribute(int attribute) {
        switch (attribute) {
            case 1 -> {
                System.out.print("Nhập tên: ");
                setName(scanner.nextLine());
            }
            case 2 -> {
                System.out.print("Nhập giá: ");
                setPrice(Menu.getInputNumber());
            }
            case 3 -> {
                System.out.print("Nhập số lượng: ");
                setCount(Menu.getInputNumber());
            }
            case 4 -> {
                System.out.print("Nhập loại: ");
                setCategory(scanner.nextLine());
            }
            case 5 -> {
                System.out.print("Nhập thương hiệu: ");
                setBrand(scanner.nextLine());
            }
            case 6 -> {
                System.out.print("Nhập ngày sản xuất: ");
                setMFG(Menu.getInputDate());
            }
            case 7 -> {
                System.out.print("Nhập hạn sử dụng: ");
                setEXP(Menu.getInputDate());
            }
        }
    }

    public void display() {
        System.out.println("├────────────────────────────────────────────────────────────────────────────────────┤");
        System.out.println(String.format("│  %-14s: %-66s│", "Id product", id));
        System.out.println(String.format("│  %-14s: %-66s│", "Tên", name));
        System.out.println(String.format("│  %-14s: %-66s│", "Giá", price));
        System.out.println(String.format("│  %-14s: %-66s│", "Số lượng", count));
        System.out.println(String.format("│  %-14s: %-66s│", "Loại", category));
        System.out.println(String.format("│  %-14s: %-66s│", "Hiệu", brand));
        System.out.println(
                String.format("│  %-14s: %-66s│", "Ngày sản xuất", new SimpleDateFormat("dd-MM-yyyy").format(MFG)));
        System.out.println(
                String.format("│  %-14s: %-66s│", "Hạn sử dụng", new SimpleDateFormat("dd-MM-yyyy").format(EXP)));
    }

    @Override
    public String toString() {
        return "Product [id='" + id + "', name='" + name + "', price='" + price + "', count='" + count + "', category='"
                + category + "', brand='" + brand + "', MFG='" + new SimpleDateFormat("dd-MM-yyyy").format(MFG)
                + "', EXP='"
                + new SimpleDateFormat("dd-MM-yyyy").format(EXP) + "']";
    }

    public boolean checkOutOfDate() {
        Date currenDate = new Date();
        return !EXP.after(currenDate);
    }

}
