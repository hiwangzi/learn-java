package dev.lukewang.chapter02.sync.bank.ext;

import dev.lukewang.chapter02.sync.bank.Bank;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockBank extends Bank {

    private final Lock bankLock = new ReentrantLock();
    private final Condition sufficientFunds = bankLock.newCondition();

    public ReentrantLockBank(int n, double initialBalance) {
        super(n, initialBalance);
    }

    @Override
    public void transfer(int from, int to, double amount) throws InterruptedException {
        bankLock.lock();
        try {
            while (this.accounts[from] < amount)
                sufficientFunds.await();
            log.info(Thread.currentThread().getName());
            accounts[from] -= amount;
            log.info("{} from {} to {}", amount, from, to);
            accounts[to] += amount;
            log.info("Total Balance: {}", String.format("%.2f", this.getTotalBalance()));
            sufficientFunds.signalAll();
        } finally {
            bankLock.unlock();
        }
    }

}
