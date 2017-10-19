package chapter1_1_Programming_Model;

import algs4.StdIn;
import algs4.StdOut;

public class Ex3 {
    public static void main(String[] args) {
        int a = StdIn.readInt();
        int b = StdIn.readInt();
        int c = StdIn.readInt();
        if(a == b && a == c) {
            StdOut.println("equal");
        } else {
            StdOut.println("not equal");
        }
    }
}
