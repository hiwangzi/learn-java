package com.hiwangzi;

/*To print a multiplication table*/
public class MultiplicationTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {//Control number of rows
            for (int j = 1; j <= i; j++) {//Control number of columns
                System.out.print(j + " * " + i + " = " + (i * j) + "\t");
            }
            System.out.println();
        }
    }
}