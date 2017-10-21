package chapter4_1_Undirected_Graphs;

import algs4.StdIn;
import algs4.StdOut;

/**
 * 间隔的度数
 * @author huang
 */
public class DegreesOfSeparation {

    public static void main(String[] args) {
        
        SymbolGraph sGraph = new SymbolGraph(args[0], args[1]);
        Graph G = sGraph.G();
        
        String source = args[2];
        if(!sGraph.contains(source)) {
            StdOut.println(source + "not in database.");
            return;
        }
        
        int s = sGraph.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
        
        while(!StdIn.isEmpty()) {
            String sink = StdIn.readLine();
            if(sGraph.contains(sink)) {
                int t = sGraph.index(sink);
                if(bfs.hasPathTo(t))
                    for(int v : bfs.pathTo(t))
                        StdOut.println("    " + sGraph.name(v));
                else
                    StdOut.println("Not connected");
            }
            else
                StdOut.println("Not in database.");
        }

    }

}
