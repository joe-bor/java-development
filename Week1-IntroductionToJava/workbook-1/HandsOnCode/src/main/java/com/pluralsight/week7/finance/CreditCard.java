package com.pluralsight.week7.finance;

public class CreditCard implements Valuable{
    private String name;
    private String accountNumber;
    private double balance;

    public CreditCard(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount){
        if (amount > 0){
            this.balance += amount;
        }
    }

    public void withdraw(double amount){
        this.balance -= Math.abs(amount);
    }


    @Override
    public double getValue() {
        return this.balance;
    }
}
