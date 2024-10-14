package dev.lukewang.chapter02.sync.bank.ext;

import dev.lukewang.chapter02.sync.bank.Bank;

public class BadBank extends Bank {

    public BadBank(int n, double initialBalance) {
        super(n, initialBalance);
    }

    @Override
    public void transfer(int from, int to, double amount) {
        log.info(Thread.currentThread().getName());
        accounts[from] -= amount;
        log.info("{} from {} to {}", amount, from, to);
        accounts[to] += amount;
        log.info("Total Balance: {}", String.format("%.2f", this.getTotalBalance()));
    }
}
