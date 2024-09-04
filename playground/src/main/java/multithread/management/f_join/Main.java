package multithread.management.f_join;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DataSourcesLoader dsLoader = new DataSourcesLoader();
        Thread thread1 = new Thread(dsLoader, "DataSourceThread");
        NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
        Thread thread2 = new Thread(ncLoader, "NetworkConnectionLoader");
        thread1.start();
        thread2.start();
        // 使用 join 主线程会等待两个线程执行完毕，然后执行后面语句
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 可以达到类似的效果
        // Thread.sleep(10000);

        System.out.printf("Main: Configuration has been loaded: %s\n", new Date());
    }
}
