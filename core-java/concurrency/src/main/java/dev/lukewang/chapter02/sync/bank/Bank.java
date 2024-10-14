package dev.lukewang.chapter02.sync.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public abstract class Bank {
    protected static final Logger log = LoggerFactory.getLogger(Bank.class);
    protected final double[] accounts;

    public Bank(int n, double initialBalance) {
        this.accounts = new double[n];
        Arrays.fill(this.accounts, initialBalance);
    }

    public abstract void transfer(int from, int to, double amount) throws InterruptedException;

    public double getTotalBalance() {
        double sum = 0.0;
        for (double a : accounts) {
            sum += a;
        }
        return sum;
    }

    public int size() {
        return accounts.length;
    }

}
