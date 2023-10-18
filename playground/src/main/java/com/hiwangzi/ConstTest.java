package com.hiwangzi;

public class ConstTest {
    public static void main(String[] args) {
        Integer i2 = 10;
        Integer i3 = new Integer(10);

        Integer i4 = new Integer(5);
        Integer i5 = new Integer(5);

        Integer i6 = i4 + i5;
        System.out.println(i2 == i6);
        System.out.println(i3 == i6);
    }
    
}
