package dev.lukewang.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class IsInterruptedDemo {
    private static final Logger log = LoggerFactory.getLogger(IsInterruptedDemo.class);

    public static void main(String[] args) throws InterruptedException {
        var thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) { // 判断是否运行
                log.info("运行中");
            }
        });
        thread.start();
        // 3毫秒之后，调用interrupt方法，代表不继续运行
        Thread.sleep(3);
        thread.interrupt();
        log.info("程序运行结束");
    }
}
