package chapter1_1_Programming_Model;

import algs4.StdOut;

public class Ex30 {

    public static void main(String[] args) {
        
        int N = 10;
        boolean[][] arr = new boolean [N][N];
        setArrBoolean(arr);
        
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                StdOut.printf("%b ", arr[i][j]);
            }
            StdOut.println();
        }
    }
    
    public static void setArrBoolean(boolean[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                arr[i][j] = true;
                for(int k = 2; k <= i; k++) {
                    if((i % k == 0) && (j % k == 0)) {
                        arr[i][j] = false;
                    }
                }
            }
        }   
    }

}
