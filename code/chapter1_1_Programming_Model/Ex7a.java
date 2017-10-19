package chapter1_1_Programming_Model;

import algs4.StdOut;

public class Ex7a {

    public static void main(String[] args) {
        
        double t = 9.0;
        while(Math.abs(t - 9.0 / t) > .001)
            t = (9.0 / t + t) / 2.0;
        StdOut.printf("%.5f\n", t);

    }

}
