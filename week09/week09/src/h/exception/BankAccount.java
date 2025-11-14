package h.exception;


// 보통 Exception을 상속받지 않고 런타임 Exception을 상속받는 이유는 무엇인가?
class InsufficientBalanceException extends RuntimeException {

    private int current;
    private int request;

    public InsufficientBalanceException(int current, int request) {
        super("잔액 부족 " + current + " / " + request);
        this.current = current;
        this.request = request;
    }
}

public class BankAccount {

    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            throw new InsufficientBalanceException(balance, amount);
        }
        balance -= amount;
    }

    public static void main(String[] args) {
        BankAccount ba = new BankAccount(10000);
        try {
            ba.withdraw(100000);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(ba.balance);
    }
}
