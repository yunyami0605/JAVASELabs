package mylab.bank.entity;

import mylab.bank.exception.*;
import java.util.ArrayList;
import java.util.List;

// 은행 시스템의 주요 관리 클래스로, 계좌 생성과 관리를 담당
public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 1000;
    }

    private String getNewAccountNumber() {
        return "AC" + (this.nextAccountNumber++);
    }

    // Saving 계좌 생성
    public SavingsAccount createSavingsAccount(String ownerName, double balance, double interestRate) {
        String accountNumber = this.getNewAccountNumber();
        SavingsAccount ac = new SavingsAccount(accountNumber, ownerName, balance, interestRate);
        this.accounts.add(ac);
        
        System.out.println("Saving 계좌가 생성되었습니다: " + ac);
        return ac;
    }

    //체킹 계좌 생성
    public CheckingAccount createCheckingAccount(String ownerName, double balance, double limit) {
        String accountNumber = this.getNewAccountNumber();
        CheckingAccount ac = new CheckingAccount(accountNumber, ownerName, balance, limit);
        this.accounts.add(ac);
        
        System.out.println("체킹 계좌가 생성되었습니다: " + ac);
        return ac;
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account ac : this.accounts) {
            if (ac.getAccountNumber().equals(accountNumber)) {
                return ac;
            }
        }
        throw new AccountNotFoundException(accountNumber);
    }

    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        this.findAccount(accountNumber).deposit(amount);
    }

    public void withdraw(String accountNumber, double amount) throws Exception {
    	this.findAccount(accountNumber).withdraw(amount);
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws Exception {
        Account from = this.findAccount(fromAccountNumber);
        Account to = this.findAccount(toAccountNumber);
        from.withdraw(amount);
        to.deposit(amount);
        
        System.out.printf("%.1f원이 %s에서 %s로 송금되었습니다.\n", amount, fromAccountNumber, toAccountNumber);
    }

    public void printAllAccounts() {
        System.out.println("모든 계좌 목록:");
        for (Account acc : this.accounts) {
            System.out.println(acc);
        }
        
    }
}
