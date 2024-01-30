package c02oop.javabase;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal d1 = new BigDecimal("123.4500");
        BigDecimal d2 = d1.stripTrailingZeros();
        System.out.println(d1.scale()); // 4
        System.out.println(d2.scale()); // 2,因为去掉了00

        BigDecimal d3 = new BigDecimal("1234500");
        BigDecimal d4 = d3.stripTrailingZeros();
        System.out.println(d3.scale()); // 0
        System.out.println(d4.scale()); // -2，表示这个数是个整数，并且末尾有2个0
        System.out.println(d3); // 1234500
        System.out.println(d4); // 1.2345E+6
        System.out.println(d3.equals(d4)); // false，使用equals()方法不但要求两个BigDecimal的值相等，还要求它们的scale()相等
        System.out.println(d3.compareTo(d4)); // 0，总是使用compareTo()比较两个BigDecimal的值，所以这个方法更好！
        System.out.println(d3.toBigInteger().equals(d4.toBigInteger())); // true
    }
}
