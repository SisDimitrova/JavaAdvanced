package BankAccount;

public class BankAccount {
    private static double interestRate = 0.02;
    private static int accountCount = 0;
    private int id;
    private double balance;


    public BankAccount() {
        accountCount++;
        this.id = accountCount;

    }

    public static double getInterestRate() {
        return interestRate;
    }

    public int getAccountCount() {
        return accountCount;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void setAccountCount(int accountCount) {
        this.accountCount = accountCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public  void deposit(double money) {
         this.balance += money;
    }
    public double getInterest(int years) {
        return   years * interestRate * this.balance;
    }
}
