package chapter4_2_Directed_Graphs;

import algs4.Bag;
import algs4.In;
import algs4.StdOut;

/*
 * 深度优先搜索，解决单点可达性和多点可达性问题
 */
public class DirectedDFS {
    private boolean[] marked;
    
    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }
    
    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for(int s : sources)
            if(!marked[s])
                dfs(G, s);
    }
    
    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for(int w : G.adj(v))
            if(!marked[w])
                dfs(G, w);
    }
    
    public boolean marked(int v) {
        return marked[v];
    }
    
    public static void main(String[] args) {
        Digraph G = new Digraph(new In(args[0]));
        
        Bag<Integer> sources = new Bag<Integer>();
        for(int i = 1; i < args.length; i++)
            sources.add(Integer.parseInt(args[i]));
        
        DirectedDFS reachable = new DirectedDFS(G, sources);
        
        for(int v = 0; v < G.V(); v++)
            if(reachable.marked(v))
                StdOut.print(v + " ");
        StdOut.println();
    }
}
