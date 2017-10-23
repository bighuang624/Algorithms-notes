package chapter4_2_Directed_Graphs;

import algs4.StdOut;

/*
 * 拓扑排序
 */
public class Topological {
    private Iterable<Integer> order;    // 顶点的拓扑排序
    
    public Topological(Digraph G) {
        DirectedCycle cyclefinder = new DirectedCycle(G);
        if(!cyclefinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();    // 一幅有向无环图的拓扑顺序即为所有顶点的逆后序排列
        }
    }
    
    public Iterable<Integer> order() {
        return order;
    }
    
    public boolean isDAG() {
        return order != null;
    }
    
    public static void main(String[] args) {
        String filename = args[0];
        String separator = args[1];
        SymbolDigraph sGraph = new SymbolDigraph(filename, separator);
        
        Topological top = new Topological(sGraph.G());
        
        for(int v : top.order())
            StdOut.println(sGraph.name(v));
    }
}
