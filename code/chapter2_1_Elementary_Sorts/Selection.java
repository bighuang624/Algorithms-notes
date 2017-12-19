package chapter2_1_Elementary_Sorts;

import algs4.StdOut;

/**
 * 选择排序
 * @author huang
 */
@SuppressWarnings({"rawtypes", "unused", "unchecked"})
public class Selection {
    public static void sort(Comparable[] a) {
        // 将 a[] 按升序排列
        int N = a.length;
        for(int i = 0 ; i < N; i++) {
            // 将 a[i] 和 a[i...N]中最小的元素交换
            int min = i;    // 最小元素的索引
            for(int j = i+1; j < N; j++)
                if(less(a[j], a[min]))
                    min = j;
            exch(a, i, min);
        }
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
