package chapter4_3_Minimum_Spanning_Tree;

import algs4.In;
import algs4.StdOut;

/*
 * 最小生成树测试
 */
public class TestMST {

    public static void main(String[] args) {
        
        In in = new In(args[0]);
        EdgeWeightedGraph G;
        G = new EdgeWeightedGraph(in);
        
        MST mst = new MST(G);
        for(Edge e : mst.edges())
            StdOut.println(e);
        StdOut.println(mst.weight());

    }

}
