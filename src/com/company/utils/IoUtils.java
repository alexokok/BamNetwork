package com.company.utils;

public class IoUtils {

    public static void showMatrix(int[][] a) {
        for (int[] anA : a) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(" " + anA[j] + " ");
            }

            System.out.println("");
        }
    }

    public static void showVector(int[] vector) {
        for (int aVector : vector) {
            System.out.print(aVector + " ");
        }

        System.out.println("");
    }
}
