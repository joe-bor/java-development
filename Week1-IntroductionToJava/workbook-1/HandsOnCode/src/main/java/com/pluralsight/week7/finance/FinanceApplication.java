package com.pluralsight.week7.finance;

public class FinanceApplication {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("123", "Pam", 12500);
        Valuable account2 = new BankAccount("456", "gary", 1500);

        account1.deposit(100);
//        account2.deposit(100) ->> doesnt work since the pointer holds a ref to Valuable type (which doesnt have the deposit method)
    }
}
