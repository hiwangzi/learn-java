package com.hiwangzi;

public class TwoDimensionTranspose {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '2', '3', '4'}, {'5', '6', '7', '8'}, {'9', 'A', 'B', 'C'}};

        print(matrix);
        System.out.println();
        char[][] result = transpose(matrix);
        print(result);
    }

    public static void print(char[][] matrix) {
        for (char[] row : matrix) {
            for (char cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }

    public static char[][] transpose(char[][] matrix) {
        char result[][] = new char[matrix[0].length][matrix.length];
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}
