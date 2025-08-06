package workshop.account.entity;

import exception.InsufficientBalanceException;

public class Account {
	private String custId;
	private String accId;
	private int balance;

	public Account() {
		System.out.println("test");
	}
	
	public Account(String custId, String accId, int balance) {
		this.custId = custId;
		this.accId = accId;
		this.balance = balance;
		
	}
	
	public void setBalance(int balance){
		this.balance = balance;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public void setCustId(String custId){
		this.custId = custId;
	}
	
	public String getCustId() {
		return this.custId;
	}
	
	public void setAccId(String accId){
		this.accId = accId;
	}
	
	public String getAccId() {
		return this.accId;
	}
	
	// 입금
	public void deposit(int amount) {
		this.balance += amount;
	}
	
	// 출금
		public void withdraw(int amount) throws InsufficientBalanceException {
			//잔액부족
			if(amount > this.balance) {
				String errMessage = String.format("잔액이 부족합니다. (요청 금액: %d, 현재 잔액: %d)", amount, this.balance);
				//Exception 강제로 발생 시킴
				throw new InsufficientBalanceException(errMessage);
			}
			this.balance -= amount;
		}
}
