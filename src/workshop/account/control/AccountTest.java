package workshop.account.control;

import exception.InsufficientBalanceException;
import workshop.account.entity.Account;

public class AccountTest {
	public static void main(String[] args) {
		Account account = new Account();
		
		account.setCustId("A1100");
		account.setAccId("221-21-3477");
		account.deposit(1000);
		System.out.println("Hell JAVA");
		System.out.println(account.getAccId());
		System.out.println(account.getCustId());
		System.out.println(account.getBalance());
		
		Account account2 = new Account("A2200", "221-21-4444", 2000);
		
		System.out.println(account2.getAccId());
		System.out.println(account2.getCustId());
		System.out.println(account2.getBalance());
		
		try {
			System.out.println("10000원 출금");
			account2.withdraw(10000);
			System.out.println("잔액 = " + account2.getBalance());
			
			System.out.println("5000원 출금");
			account2.withdraw(5000);
			System.out.println("잔액 = "    + account2.getBalance());
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
