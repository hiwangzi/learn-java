package dev.lukewang.thread;

public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        var thread = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) { // 判断是否运行
                    System.out.println("运行中");
                    Thread.sleep(1000L);
                }
            } catch (InterruptedException e) {
                System.out.println("终止");
                e.printStackTrace();
            }
        });
        thread.start();
        // 3秒之后，调用interrupt方法，代表不继续运行
        Thread.sleep(3000L);
        thread.interrupt();
        System.out.println("程序运行结束");
    }
}
