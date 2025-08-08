package mylab.bank.entity;

public abstract class Account {
	/*
	 * 주요 기능: 
	 * 기본적인 계좌 정보(계좌번호, 소유자, 잔액) 관리
	 * 입금(deposit)과 출금(withdraw) 기능 제공
	 * 데이터: 계좌번호(accountNumber), 계좌소유자 이름(ownerName), 현재 잔액(balance)
	 * */
	
    private String accountNumber;
    private String ownerName;
    protected double balance;

    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    

    // 출금
    public void withdraw(double amount) throws mylab.bank.exception.InsufficientBalanceException {
        if (this.balance >= amount) {
        	this.balance -= amount;
        	
            System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + this.balance + "원");
        } else {
            throw new mylab.bank.exception.InsufficientBalanceException("잔액 부");
        }
    }
    
 // 입금
    public void deposit(double amount) {
    	this.balance += amount;
    	
        System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + this.balance);
    }

    public abstract String toString();
}
