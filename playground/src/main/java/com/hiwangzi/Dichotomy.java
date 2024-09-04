package com.hiwangzi;

public class Dichotomy {
    private static int head = 0;
    private static int foot = 8;

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(dichotomy(array, 3));
    }

    public static int dichotomy(int[] array, int target) {
        if (target == array[(head + foot) / 2])
            return (head + foot) / 2;
        else if (head == foot)
            return -1;
        else if (target > array[(head + foot) / 2]) {
            head = (head + foot) / 2 + 1;
            //foot = foot;
            return dichotomy(array, target);
        } else {
            //head = head;
            foot = (head + foot) / 2 - 1;
            return dichotomy(array, target);
        }
    }

}
