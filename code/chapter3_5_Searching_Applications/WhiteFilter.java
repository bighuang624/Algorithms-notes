package chapter3_5_Searching_Applications;

import java.util.HashSet;

import algs4.In;
import algs4.StdIn;
import algs4.StdOut;

/**
 * @author huang
 * 白名单过滤器
 */
public class WhiteFilter {
    public static void main(String[] args) {
        HashSet<String> set;
        set = new HashSet<String>();
        In in = new In(args[0]);
        while(!in.isEmpty())
            set.add(in.readString());
        while(!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if(set.contains(word))
                StdOut.print(word + " ");
        }
    }
}
