package multithread.management.create.extend;

public class Main {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            multithread.management.create.extend.Calculator calculator = new multithread.management.create.extend.Calculator(i);
            calculator.start();
        }
    }
}
