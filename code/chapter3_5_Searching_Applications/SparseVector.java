package chapter3_5_Searching_Applications;

import chapter3_4_Hash_Tables.LinearProbingHashST;

/**
 * @author huang
 * 能够完成点乘的稀疏向量
 */
public class SparseVector {
    private LinearProbingHashST<Integer, Double> st;
    public SparseVector() {
        st = new LinearProbingHashST<Integer, Double>();
    }
    public int size() {
        return st.size();
    }
    public void put(int i, double x) {
        st.put(i, x);
    }
    public double get(int i) {
        if(!st.contains(i))
            return 0.0;
        return st.get(i);
    }
    public double dot(double[] that) {
        double sum = 0.0;
        for(int i : st.keys())
            sum += that[i] * this.get(i);
        return sum;
    }
    
}
