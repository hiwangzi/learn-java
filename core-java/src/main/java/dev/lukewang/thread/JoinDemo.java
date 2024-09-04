package dev.lukewang.thread;

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread helloThread = new Thread(new JoinDemoRunnable());
        printAllStacks("=====调用start之前=====");
        helloThread.start();
        helloThread.join(); // 可以注释这行，对比前后执行结果
        printAllStacks("=====调用start之后=====");
    }
    
    /* 使用 join 的输出结果 ⬇️
    =====调用start之前=====
    线程号：0 = main
    线程号：1 = Monitor Ctrl-Break
    ====================
    =====进入子线程之后=====
    线程号：0 = main
    线程号：1 = Monitor Ctrl-Break
    线程号：2 = Thread-0
    ====================
    =====子线程睡眠结束=====
    线程号：0 = main
    线程号：1 = Monitor Ctrl-Break
    线程号：2 = Thread-0
    ====================
    hello
    =====调用start之后=====
    线程号：0 = main
    线程号：1 = Monitor Ctrl-Break
    ====================
     */

    /* 不使用 join 的输出结果 ⬇️
    =====调用start之前=====
    线程号：0 = main
    线程号：1 = Monitor Ctrl-Break
    ====================
    =====调用start之后=====
    线程号：0 = main
    线程号：1 = Monitor Ctrl-Break
    线程号：2 = Thread-0
    ====================
    =====进入子线程之后=====
    线程号：0 = Monitor Ctrl-Break
    线程号：1 = Thread-0
    ====================
    =====子线程睡眠结束=====
    线程号：0 = Monitor Ctrl-Break
    线程号：1 = Thread-0
    线程号：2 = DestroyJavaVM
    ====================
    hello
     */

    private static void printAllStacks(String description) {
        System.out.println(description);
        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
        int activeCount = currentGroup.activeCount();
        Thread[] threadsCopy = new Thread[activeCount];
        currentGroup.enumerate(threadsCopy);
        for (int i = 0; i < activeCount; i++)
            System.out.println("线程号：" + i + " = " + threadsCopy[i].getName());
        System.out.println("====================");
    }

    private static class JoinDemoRunnable implements Runnable {
        @Override
        public void run() {
            printAllStacks("=====进入子线程之后=====");

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            printAllStacks("=====子线程睡眠结束=====");
            System.out.println("hello");
        }
    }
}