package chapter1_4_Analysis_of_Algorithms;

import algs4.StdOut;
import algs4.StdRandom;

public class StopwatchTest {

    public static void main(String[] args) {
    
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];
        for(int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-1000000, 1000000);
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        double time = timer.elapsedTime();
        StdOut.println(cnt + " triples " + time + " seconds");
    }

}
