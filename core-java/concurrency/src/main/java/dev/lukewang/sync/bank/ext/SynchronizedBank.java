package dev.lukewang.sync.bank.ext;

import dev.lukewang.sync.bank.Bank;

public class SynchronizedBank extends Bank {

    public SynchronizedBank(int n, double initialBalance) {
        super(n, initialBalance);
    }

    @Override
   public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        while (accounts[from]< amount){
            wait();
        }
        log.info(Thread.currentThread().getName());
        accounts[from] -= amount;
        log.info("{} from {} to {}", amount, from, to);
        accounts[to] += amount;
        log.info("Total Balance: {}", String.format("%.2f", this.getTotalBalance()));
    }
}
