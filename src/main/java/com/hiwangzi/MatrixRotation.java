package com.hiwangzi;

/**
 * Created by Z-Wang on 10/4/2016.
 */
public class MatrixRotation {
    public static void main(String[] args) {

        System.out.println("---Test 1---");
        int[][] test1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 1, 2, 3}};
        printMatrix(test1);
        System.out.println();
        int[][] test1_rotated = rotation(test1);
        printMatrix(test1_rotated);

        System.out.println();
        System.out.println("---Test 2---");
        int[][] test2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(test2);
        System.out.println();
        int[][] test2_rotated = rotation(test2);
        printMatrix(test2_rotated);

        System.out.println();
        System.out.println("---Test 3---");
        System.out.println();
        int[][] test3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {0, 1, 2}};
        printMatrix(test3);
        System.out.println();
        int[][] test3_rotated = rotation(test3);
        printMatrix(test3_rotated);
    }

    static int[][] rotation(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length / 2; j++) {
                int temp = result[i][j];
                result[i][j] = result[i][(result[0].length - 1) - j];
                result[i][(result[0].length - 1) - j] = temp;
            }
        }
        return result;
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                if ((j + 1) % matrix[0].length == 0)
                    System.out.println();
            }
        }

    }
}
