package dev.lukewang.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunnableDemo {
    private static final Logger log = LoggerFactory.getLogger(RunnableDemo.class);

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new PrintTask());
        log.debug("开始咯");
        t.start();
        Thread.sleep(2);
        log.debug("打断t");
        t.interrupt();
        log.debug("结束咧");
    }
}
