package chapter6_3_Suffix_Arrays;

import algs4.In;
import algs4.StdIn;
import algs4.StdOut;

/**
 * @author huang
 * keyword-in-context
 * 上下文的关键词的索引用例
 */
public class KWIC {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int context = Integer.parseInt(args[1]);    //  关键词的前后若干个字符
        
        String text = in.readAll().replaceAll("\\s+", " ");
        int N = text.length();
        SuffixArray sa = new SuffixArray(text);
        
        while(StdIn.hasNextLine()) {
            String q = StdIn.readLine();
            for(int i = sa.rank(q); i < N && sa.select(i).startsWith(q); i++) {
                int from = Math.max(0, sa.index(i) - context);
                int to = Math.min(N-1, from + q.length() + 2 * context);
                StdOut.println(text.substring(from, to));
            }
            StdOut.println();
        }
    }
}
