package c02oop.javabase;

import java.math.BigInteger;

public class BigIntegerDemo {
    public static void main(String[] args) {
        BigInteger i = new BigInteger("123456789000");
        System.out.println(i.longValue()); // 123456789000
        System.out.println(i.multiply(i).longValue()); // 溢出，但是不会有异常
        System.out.println(i.multiply(i).longValueExact()); // java.lang.ArithmeticException: BigInteger out of long range
    }
}
