package multithread.management.a_create_and_run.implement;

public class Main {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            Calculator calculator = new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
        }
    }
}
