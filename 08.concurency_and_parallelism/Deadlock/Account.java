package Deadlock;

public class Account {
    double balance;

    public Account(double startingBalance) {
        this.balance = startingBalance;
    }

    void withdraw(double amount) {
        this.balance -= amount;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    static void transfer(Account from, Account to, double amount) {
        synchronized (from) {
            synchronized (to) {
                System.out.println("Transfering money");
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }

    public static void main(String[] args) {
        Account from = new Account(100);
        Account to = new Account(100);
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                transfer(from, to, 5);
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                transfer(to, from, 2);
            }
        };
        for (int i = 0; i < 10000; i++) {
            thread1.start();
            thread2.start();
        }
    }
}