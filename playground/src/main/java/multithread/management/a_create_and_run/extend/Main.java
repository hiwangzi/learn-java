package multithread.management.a_create_and_run.extend;

public class Main {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            multithread.management.a_create_and_run.extend.Calculator calculator = new multithread.management.a_create_and_run.extend.Calculator(i);
            calculator.start();
        }
    }
}
