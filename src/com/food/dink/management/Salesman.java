package com.food.dink.management;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Salesman extends Employee implements IEvaluate {
    public Salesman() {
    }

    public Salesman(String name, String address, Date dateOfBirth, Account account, int salary) {
        super(name, address, dateOfBirth, account, salary);
    }

    @Override
    public String toString() {
        return "Salesman [name='" + name + "', address='" + address + "', dateOfBirth='"
                + new SimpleDateFormat("dd-MM-yyyy").format(dateOfBirth) + "', salary='" + salary + "']";
    }

    @Override
    public String evaluate() {
        // TODO Auto-generated method stub
        return null;
    }

    public double netSalary(BillList billList) {
        int counterBill = billList.counterBill("Salesman", getAccount().getId(), new Date());
        double netSalary = salary * (1 - (0.08 + 0.015 + 0.01) + 0.0001*counterBill);
        return netSalary;
    }
}
