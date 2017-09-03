package chapter1_1_Programming_Model;

import algs4.StdOut;

public class Ex9 {

    public static void main(String[] args) {
        
        int a = Integer.parseInt(args[0]);
        String result = "";
        
        for(int n = a; n > 0; n /= 2) {
            result = (n % 2) + result;
        }
        
        StdOut.println(result);
    
    }

}
