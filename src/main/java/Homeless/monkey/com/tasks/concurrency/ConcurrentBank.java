package Homeless.monkey.com.tasks.concurrency;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentBank {

    private final ConcurrentHashMap<Long, BankAccount> accountsMap = new ConcurrentHashMap<>();

    public BankAccount createAccount(long id, BigDecimal balance) {
        BankAccount acc = new BankAccount(id, balance);
        BankAccount existing = accountsMap.putIfAbsent(id, acc);
        if (existing != null) {
            throw new IllegalArgumentException("Аккаунт уже существует");
        }
        return acc;
    }

    public void transfer(BankAccount fromAcc, BankAccount toAcc, BigDecimal amount) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " START transfer");
        System.out.printf("%s fromAcc:%s toAcc:%s amount:%s%n", threadName, fromAcc.getId(), toAcc.getId(), amount);

        if (fromAcc.getId() == toAcc.getId())
            throw new IllegalArgumentException("Id должны быть разные");

        BankAccount firstToLock = fromAcc.getId() < toAcc.getId() ? fromAcc : toAcc;
        BankAccount secondToLock = fromAcc.getId() < toAcc.getId() ? toAcc : fromAcc;

        synchronized (firstToLock) {
                System.out.printf("%s заблокировал аккаунт с id:%s%n", threadName, firstToLock.getId());
            synchronized (secondToLock) {
                System.out.printf("%s заблокировал аккаунт с id:%s%n", threadName, secondToLock.getId());
                fromAcc.withdraw(amount);
                toAcc.deposit(amount);
                System.out.printf("%s успешно совершил перевод%n", threadName, firstToLock.getId());
            }
        }
    }

    public BigDecimal getTotalBalance() {
        BigDecimal total = BigDecimal.ZERO;
        for (BankAccount acc : accountsMap.values()) {
            total = total.add(acc.getBalance());
        }
        return total;
    }
}
