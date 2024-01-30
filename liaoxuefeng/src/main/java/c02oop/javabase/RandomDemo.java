package c02oop.javabase;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class RandomDemo {

    public static void main(String[] args) {
        System.out.println("伪随机数展示:");
        伪随机数展示();
        System.out.println("\n\n\n\n\n");

        System.out.println("真随机数展示:");
        真随机数展示();
    }

    public static void 伪随机数展示() {
        Random random = new Random(12345);
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(100));
        }
    }

    public static void 真随机数展示() {
        SecureRandom secureRandom = null;
        try {
            secureRandom = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            secureRandom = new SecureRandom();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(secureRandom.nextInt(100));
        }
    }
}
