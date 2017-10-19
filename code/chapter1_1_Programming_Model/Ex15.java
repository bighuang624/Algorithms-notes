package chapter1_1_Programming_Model;

import algs4.StdOut;

public class Ex15 {

    public static void main(String[] args) {
        
        int[] arr = {0, 1, 1, 1};
        int[] timesArr = histogram(arr, 2);
        for(int j = 0; j < timesArr.length; j++) {
            StdOut.printf("%d ", timesArr[j]);
        }
    }
    
    public static int[] histogram(int[] a, int M) {
        
        int[] arr = new int[M];
        for(int i = 0; i < M; i++){
            int times = 0;
            for(int j = 0; j < a.length; j++){
                if(a[j] == i)
                    times++;
            }
            arr[i] = times;
        }
        return arr;
    }

}
