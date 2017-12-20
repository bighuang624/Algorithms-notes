package chapter2_2_Mergesort;

import algs4.StdOut;

/**
 * @author huang
 * 自底向上的归并排序
 */
@SuppressWarnings({"rawtypes", "unused", "unchecked"})
public class MergeBU {
    private static Comparable[] aux;    // 归并所需的辅助数组
    
    public static void sort(Comparable[] a) {
        // 进行 lgN 次两两归并
        int N = a.length;
        aux = new Comparable[N];
        for(int sz = 1; sz < N; sz = sz+sz)
            for(int lo = 0; lo < N - sz; lo += sz+sz)
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));    // 最后一个子数组的大小只有在数组大小是 sz 的偶数倍时才会等于 sz，否则小于 sz
    }
    
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        // 将 a[lo..mid] 和 a[mid+1..hi] 归并
        int i = lo, j = mid + 1;
        
        for(int k = lo; k <= hi; k++)    // 将 a[lo..hi] 复制到 aux[lo..hi]
            aux[k] = a[k];
        
        for(int k = lo; k <= hi; k++)
            if(i > mid)    // 左半边元素用尽
                a[k] = aux[j++];
            else if(j > hi)    // 右半边元素用尽
                a[k] = aux[i++];
            else if(less(aux[i], aux[j]))
                a[k] = aux[i++];
            else
                a[k] = aux[j++];               
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
