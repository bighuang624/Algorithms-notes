package chapter2_3_Quicksort;

import algs4.StdOut;
import algs4.StdRandom;
import chapter1_4_Analysis_of_Algorithms.Stopwatch;
import chapter1_4_Analysis_of_Algorithms.ThreeSum;
import chapter2_1_Elementary_Sorts.Insertion;
import chapter2_1_Elementary_Sorts.SortCompare;

/**
 * 快速排序切换到插入排序
 * @author huang
 */
@SuppressWarnings({"rawtypes", "unused", "unchecked"})
public class Ex25 {
    public static void main(String[] args) {
        
        for(int N = 1000; N <= 1000000; N *= 10) {
            Comparable[] a = new Comparable[N];
            for(int i = 0; i < N; i++)
                a[i] = StdRandom.uniform(-1000000, 1000000);
            for(int M = 0; M <= 30; M++) {
                Comparable[] b = a.clone();
                Stopwatch timer = new Stopwatch();
                sort(b, 1);
                double time = timer.elapsedTime();
                StdOut.println("Array size: " + N + ", M = " + M + ", time: " + time + " seconds");
            }
        }
    }
    
    public static void sort(Comparable[] a, int M) {
        StdRandom.shuffle(a);    // 消除对输入的依赖
        sort(a,0, a.length - 1, M);
    }
    
    private static void sort(Comparable[] a, int lo, int hi, int M) {
        if(hi <= lo + M) {
            insertSort(a, lo, hi);
            return;
        }
        int j = partition(a, lo, hi);    // 切分
        sort(a, lo, j-1, M);    // 将左半部分 a[lo .. j-1]
        sort(a, j+1, hi, M);    // 将右半部分 a[j+1 .. hi]
    }
    
    private static void insertSort(Comparable[] a, int lo, int hi) {
        int N = a.length;
        for(int i = lo; i < hi+1; i++) {
            for(int j = i; j > 0 && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
        }
    }
    
    private static int partition(Comparable[] a, int lo, int hi) {
        // 将数组切分为 a[lo .. i-1]，a[i]，a[i+1 .. hi]
        int i = lo, j = hi+1;    // 左右扫描指针
        Comparable v = a[lo];    // 切分元素
        while(true) {
            // 扫描左右，检查扫描是否结束并交换元素
            while(less(a[++i], v))
                if(i == hi)
                    break;
            while(less(v, a[--j]))
                if(j == lo)
                    break;
            if(i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    
    private static boolean less(Comparable v, Comparable w) {
        // 对元素进行比较
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        // 将元素交换位置
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        // 在单行中打印数组
        for(int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        // 测试数组元素是否有序
        for(int i = 1; i < a.length; i++)
            if(less(a[i], a[i - 1]))
                return false;
        return true;
    }
}
