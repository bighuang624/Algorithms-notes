package chapter4_1_Undirected_Graphs;

import algs4.StdIn;
import algs4.StdOut;

public class TestSymbolGraph {

    public static void main(String[] args) {
        String filename = args[0];
        String delim = args[1];
        SymbolGraph sGraph = new SymbolGraph(filename, delim);
        
        Graph G = sGraph.G();
        
        while(StdIn.hasNextLine()) {
            String source = StdIn.readLine();
            for(int w : G.adj(sGraph.index(source)))
                StdOut.println("    " + sGraph.name(w));
        }
    }

}
