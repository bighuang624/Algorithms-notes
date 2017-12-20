package chapter2_2_Mergesort;

import algs4.StdOut;

/**
 * @author huang
 * 自顶向下的归并排序
 */
@SuppressWarnings({"rawtypes", "unused", "unchecked"})
public class Merge {
    private static Comparable[] aux;    // 归并所需的辅助数组
    
    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }
    
    private static void sort(Comparable[] a, int lo, int hi) {
        // 将数组 a[lo..hi] 排序
        if(hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);    // 将左半边排序
        sort(a, mid + 1, hi);    // 将右半边排序
        if(less(a[mid+1], a[mid]))    // 为 false 则认为数组已经是有序的，跳过 merge()
            merge(a, lo, mid, hi);    // 归并结果
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
