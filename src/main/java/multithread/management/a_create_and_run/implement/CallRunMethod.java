package multithread.management.a_create_and_run.implement;

public class CallRunMethod {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(1);
        calculator.run(); // 直接调用 run() 就是普通方法调用
    }
}
