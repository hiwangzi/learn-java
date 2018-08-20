package com.hiwangzi;

public class StringTest{
    public static void main(String [] args){
        String ab="ab";
        String a="a";

        // 「变量」与「变量连接字符串（匿名对象）」比较
        System.out.println(ab.equals((a+"b")));
        System.out.println(ab==(a+"b"));

        // 「字符串（匿名对象）」与「变量连接字符串（匿名对象）」比较
        System.out.println();
        System.out.println("ab".equals(("a"+"b")));
        System.out.println("ab"==("a"+"b"));

        System.out.println();
        System.out.println(ab.equals(("a"+"b")));
        System.out.println(ab==("a"+"b"));

        System.out.println();
        System.out.println("ab".equals(ab));
        System.out.println("ab"==ab);

        System.out.println();
        System.out.println(ab.equals("ab"));
        System.out.println(ab=="ab");
    }
}