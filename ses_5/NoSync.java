package ses_5;

class BankAccount {	
    private int balance = 10000;
    public void withdraw(String name, int amount) {
        if (balance >= amount) {
            System.out.println(name + " is trying to withdraw " + amount);
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            balance -= amount;
            System.out.println(name + " completed withdrawal. Remaining balance: " + balance);
        } else {
            System.out.println(name + " tried to withdraw " + amount + " but not enough balance.");
        }
    }
}
public class NoSync {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        
        Thread t1 = new Thread(() -> account.withdraw("Alice", 8000));
        Thread t2 = new Thread(() -> account.withdraw("Bob", 8000));
 
        t1.start();
        t2.start();
    }
}
