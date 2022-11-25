package com.food.dink.management;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Person {
    private static final Scanner scanner = new Scanner(System.in);
    protected String name;
    protected String address;
    protected Date dateOfBirth;
    protected Account account;

    protected Person() {
        dateOfBirth = new Date();
    }

    protected Person(String name, String address, Date dateOfBirth, Account account) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.account = account;
        if (this.account != null)
            this.account.setPerson(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Person [name='" + name + "', address='" + address + "', dateOfBirth='"
                + new SimpleDateFormat("dd-MM-yyyy").format(dateOfBirth) + "']";
    }

    public void input() {
        System.out.print("Nhập tên: ");
        setName(scanner.nextLine());

        System.out.print("Nhập địa chỉ: ");
        setAddress(scanner.nextLine());

        System.out.print("Nhập ngày sinh: ");
        setDateOfBirth(Menu.getInputDate());
    }
}
