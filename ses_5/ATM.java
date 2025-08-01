package ses_5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class BankAccountATM{
	private int balance = 10000;
	private final ReentrantLock lock = new ReentrantLock();
	
	public boolean withdraw(String user, int amount) {
		lock.lock();
		try {
			if(balance >= amount) {
				System.out.println(user + " is trying to withraw "+ amount);
				Thread.sleep(1000);
				balance -= amount;
				System.out.println(user + " completed withdrawal. Remaining : "+balance);
				return true;
			}else {
				System.out.println(user + " failed to withdraw "+ amount+" (Not enough balance)");
				return false;
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
			return false;
		}finally {
			lock.unlock();
		}
	}
	public int getBalance() {
		return balance;
	}
}

public class ATM {
	public static void main(String[] args) {
		BankAccountATM account = new BankAccountATM();
		AtomicInteger successfulWithdrawals = new AtomicInteger(0);
		//Create a thread pool of 3 ATMs
		ExecutorService atmPool = Executors.newFixedThreadPool(3);
		
		for(int i = 1; i<=5; i++) {
			String user = "User" + i;
			atmPool.submit(() -> {
				boolean success = account.withdraw(user, 3000);
				if(success) {
					successfulWithdrawals.incrementAndGet();
				}
			});
		}
		
		atmPool.shutdown();
		while(!atmPool.isTerminated()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Total successful withdraws : "+successfulWithdrawals.get());
	}
}
