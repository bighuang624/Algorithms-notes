package chapter1_1_Programming_Model;

import algs4.StdOut;
import algs4.StdRandom;

public class Ex13 {

    public static void main(String[] args) {

        int M = 3, N = 4;
        int[][] arr = new int[M][N];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                arr[i][j] = StdRandom.uniform(20);
        StdOut.println("oldArr: ");
        printArr(arr);
        StdOut.println("newArr: ");
        printArr(arrReverse(arr));

    }

    public static int[][] arrReverse(int[][] arr) {
        int[][] newArr = new int[arr[0].length][arr.length];
        for(int i = 0; i < newArr.length; i++)
            for(int j = 0; j < newArr[0].length; j++)
                newArr[i][j] = arr[j][i];

        return newArr;
    }

    public static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                StdOut.printf("%d  ",arr[i][j]);
            }
            StdOut.println();
            
        }

    }

}
