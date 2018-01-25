package com.company.utils;

public class MathUtils {

    public static int[][] sumMatrix(int[][] a, int[][] b) {
        int lenghtStr = a.length;
        int lengthCols = a[0].length;

        int[][] result = new int[lenghtStr][lengthCols];

        for (int i = 0; i < lenghtStr; i++) {

            for (int j = 0; j < lengthCols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        return result;
    }


    public static int[][] multipleMatrix(int[][] a, int[][] b) {
        int m = a.length;
        int n = b[0].length;
        int o = b.length;

        int[][] result = new int[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < o; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    /**
     * переворачивает вектор в матрицу размерностью [1][n]
     */
    public static int[][] revertVector(int[] vector) {

        int[][] result = new int[vector.length][1];

        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < 1; j++) {
                result[i][j] = vector[i];
            }
        }

        return result;
    }


    /**
     * разворачивает матрицу в вектор размерность [m * n]
     */
    public static int[] matrixToVector(int[][] matrix) {
        int[] result = new int[matrix.length * matrix[0].length];

        int k = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[k] = matrix[i][j];
                k++;
            }
        }

        return result;
    }

    /**
     * инициализаця вектора перед обучением
     */
    public static int[] initalizeVector(int[] vector) {
        int[] result = new int[vector.length];

        for (int i = 0; i < vector.length; i++) {
            result[i] = vector[i] > 0 ? 1 : -1;
        }

        return result;
    }

    /**
     * инициализация матрицы перед обучением
     */
    public static int[][] initializeMatrix(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < result.length; i++) {

            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = matrix[i][j] > 0 ? 1 : 0;
            }
        }

        return result;
    }
}
