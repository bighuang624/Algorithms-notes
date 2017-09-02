package chapter1_1_Programming_Model;

import algs4.StdOut;

public class Ex7b {
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i < 1000; i++)
            for(int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);
    }
}
