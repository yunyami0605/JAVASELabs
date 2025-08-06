package workshop.account.entity;

public class Account {
	private String custId;
	private String accId;
	private int balance;
	
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
	public void withdrawal(int amount) {
		this.balance -= amount;
	}
}
