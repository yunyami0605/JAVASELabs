package mylab.bank.exception;

public class WithdrawalLimitExceededException extends InsufficientBalanceException {
    public WithdrawalLimitExceededException(double limit) {
        super("출금 한도를 초과했습니다. 한도: " + limit + "원");
    }
}