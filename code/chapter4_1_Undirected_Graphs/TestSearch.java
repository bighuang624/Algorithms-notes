package chapter4_1_Undirected_Graphs;

import algs4.In;
import algs4.StdOut;

public class TestSearch {

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        Search search = new Search(G, s);
        
        for(int v = 0; v < G.V(); v++)
            if(search.marked(v))
                StdOut.println(v + " ");
        StdOut.println();
        
        if(search.count() != G.V())
            StdOut.print("NOT ");
        StdOut.println("connected");

    }

}
