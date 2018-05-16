package multithread.management.c_interrupt_1.extend;

public class PrimeGenerator extends Thread {

    @Override
    public void run() {
        long number = 1L;
        while (true) {
            if (isPrime(number)) {
                System.out.printf("Number %d is Prime\n", number);
            }
            if (isInterrupted()) {
                System.out.println("The Prime Generator has been Interrupted");
                return; // 此处若不主动结束，线程仍将持续运行
            }
            number++;
        }
    }

    private boolean isPrime(long number) {
        if (number < 2) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        for (long i = 2; i < number; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
