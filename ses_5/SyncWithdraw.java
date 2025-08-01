package ses_5;

class Account {
    private int balance = 10000;
    public synchronized void withdraw(String name, int amount) {
        if (balance >= amount) {
            System.out.println(name + " is trying to withdraw " + amount);
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            balance -= amount;
            System.out.println(name + " completed withdrawal. Remaining balance: " + balance);
        } else {
            System.out.println(name + " tried to withdraw " + amount + " but not enough balance");
        }
    }
}

public class SyncWithdraw {
    public static void main(String[] args) {
        Account account = new Account();

        Thread t1 = new Thread(() -> account.withdraw("Alice", 8000));
        Thread t2 = new Thread(() -> account.withdraw("Bob", 8000));

        t1.start();
        t2.start();
    }
}

