package dev.lukewang.chapter02.sync.bank;

import dev.lukewang.chapter02.sync.bank.ext.BadBank;
import dev.lukewang.chapter02.sync.bank.ext.ReentrantLockBank;
import dev.lukewang.chapter02.sync.bank.ext.SynchronizedBank;

public class BankDemo {

    private static final int ACCOUNTS_COUNT = 100;
    private static final double INITIAL_BALANCE = 1000;
    private static final double MAX_AMOUNT = 1000;
    private static final int DELAY = 10;

    public static void main(String[] args) {
        Bank bank = new SynchronizedBank(ACCOUNTS_COUNT, INITIAL_BALANCE);
        for (int i = 0; i < ACCOUNTS_COUNT; i++) {
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while (true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);

                        Thread.sleep((int) (DELAY * Math.random()));
                    }

                } catch (InterruptedException e) {
                }
            };
            Thread thread = new Thread(r);
            thread.start();
        }
    }
}
