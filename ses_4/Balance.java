package ses_4;

@SuppressWarnings("serial")
class InsufficientFundsException extends RuntimeException {
	public InsufficientFundsException(String message) {
		super(message);
	}
}
class BankAccount {
	private String accountHolder;
	private double balance;
	public BankAccount(String accountHolder, double initialBalance) {
		this.accountHolder = accountHolder;
		this.balance = initialBalance;
	}
	public void withdraw(double amount) throws InsufficientFundsException {
		if (amount > balance) {
			throw new InsufficientFundsException(
					"Insufficient Balance! Available: " + balance + ", Requested: " + amount);
		}
		balance -= amount;
		System.out.println("Withdrawal successful "+accountHolder+" Remaining balance: " + balance);
	}
}
public class Balance {
	public static void main(String[] args) {
		BankAccount myAccount = new BankAccount("Anand", 5000);
//		try {
//			myAccount.withdraw(7000); 
//		} catch (InsufficientFundsException e) {
//			System.out.println("Transaction failed: " + e.getMessage());
//		}
		
		myAccount.withdraw(2000);
	}
}
