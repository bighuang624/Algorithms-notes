package chapter4_1_Undirected_Graphs;

import algs4.Bag;
import algs4.In;
import algs4.StdOut;

/**
 * 找出一幅图的所有连通分量
 * @author huang
 */
public class TestCC {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        CC cc = new CC(G);
        
        int M = cc.count();
        StdOut.println(M + " components");
        
        Bag<Integer>[] components;
        components = (Bag<Integer>[]) new Bag[M];
        for(int i = 0; i < M; i++)
            components[i] = new Bag<Integer>();
        for(int v = 0; v < G.V(); v++) 
            components[cc.id(v)].add(v);
        for(int i = 0; i < M; i++) {
            for(int v : components[i])
                StdOut.print(v + " ");
            StdOut.println();
        }
        
    }
}
