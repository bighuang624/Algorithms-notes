package chapter1_1_Programming_Model;

import algs4.StdOut;

public class Ex6 {
    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        for(int i = 0; i <= 15; i++){
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }
}