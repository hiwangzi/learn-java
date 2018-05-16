package multithread.management.c_interrupt_1.implement;

public class Main {
    public static void main(String[] args) {

        Thread task = new Thread(new PrimeGenerator());
        task.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 向线程发送中断信号
        task.interrupt();
    }
}
