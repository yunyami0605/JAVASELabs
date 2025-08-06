package workshop.account.control;

import workshop.account.entity.Account;

public class AccountTest {
	public static void main(String[] args) {
		Account account = new Account();
		
		account.setCustId("A1100");
		account.setAccId("221-21-3477");
		account.deposit(1000);
		System.out.println("Hell JAVA");
		
		Account account2 = new Account("A1100", "221-21-3477", 1000);
		
	}
}
