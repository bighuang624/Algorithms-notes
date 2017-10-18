package chapter1_4_Analysis_of_Algorithms;

import algs4.StdOut;
import algs4.StdRandom;

public class DoublingRatio {

    public static double timeTrial(int N) {
        // 为处理 N 个随机的六位整数的 ThreeSum.count() 计时
        int MAX = 1000000;
        int[] a = new int[N];
        for(int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        
        double prev = timeTrial(125);
        for(int N = 250; true; N *= 2) {
            double time = timeTrial(N);
            StdOut.printf("%6d %7.1f ", N, time);
            StdOut.printf("%5.1f\n", time/prev);
            prev = time;
        }
        
    }
    
}
