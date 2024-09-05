package dev.lukewang.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrintTask implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(PrintTask.class);

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            if (Thread.interrupted()) {
                log.debug("Printing thread {} interrupted ", Thread.currentThread().getName());
                return;
            }
            log.debug("Printing thread {}, now is {}", Thread.currentThread().getName(), System.currentTimeMillis());
        }
    }
}
