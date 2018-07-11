package com.hiwangzi;

public class NumSwap {
    public static void main(String[] args) {
        int a[] = {1};
        int b[] = {2};
        System.out.println("Swap 1:");
        System.out.println("--Before: " + a[0] + ", " + b[0]);
        Swap1(a, b);
        System.out.println("--After: " + a[0] + ", " + b[0] + "\n");

        a[0] = 1;
        b[0] = 2;
        System.out.println("Swap 2:");
        System.out.println("--Before: " + a[0] + ", " + b[0]);
        Swap2(a, b);
        System.out.println("--After: " + a[0] + ", " + b[0]);
    }

    public static void Swap1(int num1[], int num2[]) {
        int temp = num1[0];
        num1[0] = num2[0];
        num2[0] = temp;
    }

    public static void Swap2(int num1[], int num2[]) {
        int temp[];
        temp = num1;
        num1 = num2;
        num2 = temp;
    }
}