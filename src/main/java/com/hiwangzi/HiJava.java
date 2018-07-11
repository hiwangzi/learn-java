package com.hiwangzi;

public class HiJava {

    public static void main(String[] args) {
        int i1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};// 源数组
        int i2[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};// 目标数组
        System.arraycopy(i1, 3, i2, 8, 3);// 调用拷贝方法(正常拷贝)
        // copy(i1,0,i2,8,2);//数组越界调用
        // System.arraycopy(i1,0,i2,8,2);//系统提供的方法，同上数组越界调用
        for (int i = 0; i < i2.length; i++) {
            System.out.print(i2[i] + "\t");
        }

        //String str="hello";
//		System.out.println(str[0]);
    }
}
