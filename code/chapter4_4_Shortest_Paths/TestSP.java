package chapter4_4_Shortest_Paths;

import algs4.In;
import algs4.StdOut;

/**
 * @author huang
 * 最短路径测试
 */
public class TestSP {
    public static void main(String[] args) {
        EdgeWeightedDigraph G;
        G = new EdgeWeightedDigraph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        SP sp = new DijkstraSP(G, s);
        
        for(int t = 0; t < G.V(); t++) {
            StdOut.print(s + " to " + t);
            StdOut.printf(" (%4.2f): ", sp.distTo(t));
            if(sp.hasPathTo(t))
                for(DirectedEdge e : sp.pathTo(t))
                    StdOut.print(e + "    ");
            StdOut.println();
        }
    }
}
