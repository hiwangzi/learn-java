package dev.lukewang;

import static java.util.FormatProcessor.FMT;

public class StringTemplatesDemo {
    public static void main(String[] args) {
        System.out.println(sayHelloViaSTR("Tom"));
        System.out.println(sayHelloViaFMT("Jerry", 3.141592653));
    }

    public static String sayHelloViaSTR(String name) {
        return STR."Hello \{name}!";
    }

    public static String sayHelloViaFMT(String name, double num) {
        return FMT."Hello %1s\{name}, num: %10.4f\{num}!";
    }
}
