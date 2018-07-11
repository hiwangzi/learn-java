package com.hiwangzi;

public class MatrixTranspose {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        print(matrix);
        System.out.println();
        transpose(matrix);
        print(matrix);
    }

    public static void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }

    public static void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
