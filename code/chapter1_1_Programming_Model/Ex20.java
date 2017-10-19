package chapter1_1_Programming_Model;

import algs4.StdOut;

public class Ex20 {

    public static void main(String[] args) {
        
        StdOut.print(ln10(9));

    }
    
    public static double ln10(int N) {
        
        if(N == 1)
            return Math.log10(1);
        return Math.log10(N) + ln10(N - 1);
    }

}
