package chapter1_2_Data_Abstraction;

import java.util.Arrays;

public class StaticSETofInts {
    private int[] a;
    public StaticSETofInts(int[] keys) {
        a = new int[keys.length];
        for(int i = 0; i < keys.length; i++) {
            a[i] = keys[i];  // 保护性复制
        }
        Arrays.sort(a);
    }
    public boolean contains(int key) {
        return rank(key) != -1;
    }
    private int rank(int key) {
        // 二分查找
        int lo = 0;
        int hi = a.length;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(key > a[mid]) {
                lo = mid + 1;
            } 
            else if(key < a[mid]) {
                hi = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
