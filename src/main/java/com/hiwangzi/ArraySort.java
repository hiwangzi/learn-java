package com.hiwangzi;

public class ArraySort {

    public static void main(String[] args) {
        int array[] = {7, 8, 6, 4, 2, 5};

        printArray(array);
        sort(array);
        printArray(array);


    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length - 1 - i; j++)
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }


    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
