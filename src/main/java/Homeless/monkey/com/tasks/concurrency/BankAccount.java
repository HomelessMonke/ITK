package Homeless.monkey.com.tasks.concurrency;

import java.math.BigDecimal;

public class BankAccount {

    private final long id;
    private BigDecimal balance;

    public long getId() {return id;}
    public BigDecimal getBalance () {return balance;}

    public BankAccount(long id, BigDecimal initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }

    public void deposit(BigDecimal amount){
        balance = balance.add(amount);
    }

    public void withdraw (BigDecimal amount){
        if(balance.compareTo(amount)<0)
            throw new IllegalStateException("На счету нет такой суммы");

        balance = balance.subtract(amount);
    }
}
