package chapter2_1_Elementary_Sorts;

import algs4.StdOut;

/**
 * 希尔排序
 * @author huang
 */
@SuppressWarnings({"rawtypes", "unused", "unchecked"})
public class Shell {
    public static void sort(Comparable[] a) {
        // 将 a[] 按升序排列
        int N = a.length;
        int h = 1;
        while(h < N / 3)
            h = 3 * h + 1;    // 1, 4, 13, 40, 121, 364, 1093, ...
        while(h >= 1) {
            // 将数组变为 h 有序
            for(int i = h; i < N; i++) {
                // 将 a[i] 插入到 a[i-h]，a[i-2*h]，a[i-3*h]... 之中
                for(int j = i; j >= h && less(a[j], a[j -h]); j -= h)
                    exch(a, j, j-h);
            }
            h /= 3;
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
