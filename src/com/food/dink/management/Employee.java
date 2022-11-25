package com.food.dink.management;
import java.util.Date;

abstract class Employee extends Person {
    protected int salary;

    public int getSalary() {
        return salary;
    }

    protected Employee() {
    }

    protected Employee(String name, String address, Date dateOfBirth, Account account, int salary) {
        super(name, address, dateOfBirth, account);
        this.salary = salary;
    }

    public void setSalary(int salary) {
        while (salary <= 0) {
            System.out.print("Nhập lương: ");
            salary = Menu.getInputNumber();
        }
        this.salary = salary;
    }

    @Override
    public void input() {
        super.input();
        System.out.print("Nhập lương: ");
        setSalary(Menu.getInputNumber());
    }
}