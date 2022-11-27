package com.food.dink.management;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Manager extends Employee {
    public Manager() {
    }

    public Manager(String name, String address, Date dateOfBirth, Account account, int salary) {
        super(name, address, dateOfBirth, account, salary);
    }

    @Override
    public String toString() {
        return "Manager [name='" + name + "', address='" + address + "', dateOfBirth='"
                + new SimpleDateFormat("dd-MM-yyyy").format(dateOfBirth) + "', salary='" + salary + "']";
    }

    @Override
    public double netSalary(BillList billList) {
        double netSalary = salary * (1 - (0.08 + 0.015 + 0.01));
        return netSalary;
    }

}
