package multithread.management.b_get_and_set_thread_info;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {

        Thread[] threads = new Thread[10];
        Thread.State[] states = new Thread.State[10];

        try (FileWriter fileWriter = new FileWriter("./log.txt");
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            // 创建线程并变更线程信息
            for (int i = 0; i < 10; i++) {
                threads[i] = new Thread(new Calculator(i + 1));
                states[i] = threads[i].getState();

                printWriter.println("Main : Initial thread infomation");
                logThreadInfo(printWriter,threads[i]);

                if (i % 2 == 0) {
                    threads[i].setPriority(Thread.MAX_PRIORITY);
                } else {
                    threads[i].setPriority(Thread.MIN_PRIORITY);
                }
                threads[i].setName("线程 " + i);
            }

            // 启动线程
            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }

            // 记录线程状态变化
            boolean finish = false;
            while (!finish) {
                for (int i = 0; i < 10; i++) {
                    if (threads[i].getState() != states[i]) {
                        logThreadInfo(printWriter, threads[i], states[i]);
                        states[i] = threads[i].getState();
                    }
                }
                finish = true;
                for (int i = 0; i < 10; i++) {
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void logThreadInfo(PrintWriter pw, Thread thread, Thread.State oldState) {
        pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main : Old State: %s\n", oldState);
        pw.printf("Main : New State: %s\n", thread.getState());
        pw.printf("Main : ************************************\n");
    }

    private static void logThreadInfo(PrintWriter pw, Thread thread) {
        pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main : State: %s\n", thread.getState());
        pw.printf("Main : ************************************\n");
    }
}
