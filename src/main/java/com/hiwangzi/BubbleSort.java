package com.hiwangzi;

/*Bubble Sort*/
public class BubbleSort {
    public static void main(String args[]) {
        int[] array = {7, 6, 3, 6, 9, 2, 5, 21};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
};