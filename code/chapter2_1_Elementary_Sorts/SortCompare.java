package chapter2_1_Elementary_Sorts;

import algs4.StdOut;
import algs4.StdRandom;
import chapter1_4_Analysis_of_Algorithms.Stopwatch;

/**
 * @author huang
 * 比较两种排序算法
 */
@SuppressWarnings({"rawtypes"})
public class SortCompare {
    public static double time(String alg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        if(alg.equals("Insertion"))
            Insertion.sort(a);
        if(alg.equals("Selection"))
            Selection.sort(a);
        if(alg.equals("Shell"))
            Shell.sort(a);
//        if(alg.equals("Merge"))
//            Merge.sort(a);
//        if(alg.equals("Quick"))
//            Quick.sort(a);
//        if(alg.equals("Heap"))
//            Heap.sort(a);
        return timer.elapsedTime();
    }
    
    public static double timeRandomInput(String alg, int N, int T) {
        // 使用算法 alg 将 T 个长度为 N 的数组排序
        double total = 0.0;
        Double[] a = new Double[N];
        for(int t = 0; t < T; t++) {
            // 进行一次测试（生成一个数组并排序）
            for(int i = 0; i < N; i ++)
                a[i] = StdRandom.uniform();    /** 练习 2.5.31 */
            total += time(alg, a);
        }
        return total;
    }
    
    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1, N, T);    // 算法 1 的总时间
        double t2 = timeRandomInput(alg2, N, T);    // 算法 2 的总时间
        StdOut.printf("For %d random Doubles\n    %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2/t1, alg2);
    }
}
