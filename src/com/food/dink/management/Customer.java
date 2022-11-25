package com.food.dink.management;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer extends Person {
    private int point = 0;

    public Customer() {
    }

    public Customer(int point) {
        this.point = point;
    }

    public Customer(String name, String address, Date dateOfBirth, Account account, int point) {
        super(name, address, dateOfBirth, account);
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        while (point < 0) {
            System.out.print("Nhập điểm: ");
            point = Menu.getInputNumber();
        }
        this.point = point;
    }

    @Override
    public void input() {
        super.input();
        System.out.print("Nhập điểm: ");
        setPoint(Menu.getInputNumber());
    }

    @Override
    public String toString() {
        return "Customer [name='" + name + "', address='" + address + "', dateOfBirth='"
                + new SimpleDateFormat("dd-MM-yyyy").format(dateOfBirth) + "', point='" + point + "']";
    }

}