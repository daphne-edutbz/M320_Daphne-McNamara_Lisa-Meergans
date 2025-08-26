package ch.tbz;

public class BankAccount {
    private String accountNumber;
    private String owner;
    private double balance;

    public BankAccount(String accountNumber, String owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " to " + owner);
        } else {
            System.out.println("Cannot deposit " + amount + " to " + owner);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn " + amount + " from " + owner);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void transfer(double amount, BankAccount destination) {
        if (amount > 0 && amount <= balance) {
            withdraw(amount);
            destination.deposit(amount);
            System.out.println("Transferred " + amount + " to " + destination.owner);
        } else {
            System.out.println("Transfer failed");
        }

    }
    public double getBalance() {
        return balance;
    }
    public String getOwner() {
        return owner;
    }
}
