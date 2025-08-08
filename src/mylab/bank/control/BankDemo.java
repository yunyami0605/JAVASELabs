package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.AccountNotFoundException;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        SavingsAccount s1 = bank.createSavingsAccount("홍길동", 10000, 3.0);
        CheckingAccount c1 = bank.createCheckingAccount("김철수", 20000, 5000);
        SavingsAccount s2 = bank.createSavingsAccount("이영희", 30000, 2.0);

        bank.printAllAccounts();

        System.out.println("\n1. 입금/출금 테스트");
        try {
            bank.deposit(s1.getAccountNumber(), 5000);
            bank.withdraw(c1.getAccountNumber(), 3000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println("\n2. 이자 적용 테스트");
        s1.applyInterest();

        System.out.println("\n3. 계좌 이체 테스트");
        try {
            bank.transfer(s2.getAccountNumber(), c1.getAccountNumber(), 5000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        bank.printAllAccounts();

        System.out.println("\n4. 예외 테스트");
        try {
            bank.withdraw(c1.getAccountNumber(), 6000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.findAccount("AC9999");
        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}