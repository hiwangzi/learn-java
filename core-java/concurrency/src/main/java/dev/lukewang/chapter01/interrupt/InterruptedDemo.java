package dev.lukewang.chapter01.interrupt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InterruptedDemo {
    private static final Logger log = LoggerFactory.getLogger(InterruptedDemo.class);

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                if (Thread.interrupted()) {
                    log.debug("Printing thread {} interrupted ", Thread.currentThread().getName());
                    return;
                }
                log.debug("Printing thread {}, now is {}", Thread.currentThread().getName(), System.currentTimeMillis());
            }
        });
        log.debug("开始咯");
        t.start();
        Thread.sleep(2);
        log.debug("打断t");
        t.interrupt();
        log.debug("结束咧");
    }
}
