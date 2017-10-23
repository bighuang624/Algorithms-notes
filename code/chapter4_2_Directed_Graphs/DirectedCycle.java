package chapter4_2_Directed_Graphs;

import algs4.Stack;

public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;    // 有向环中的所有顶点（如果存在）
    private boolean[] onStack;    // 递归调用的栈上的所有顶点
    
    public DirectedCycle(Digraph G) {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for(int v = 0; v < G.V(); v++) {
            if(!marked[v])
                dfs(G, v);
        }
    }
    
    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for(int w : G.adj(v))
            if(this.hasCycle())
                return;
            else if(!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
            else if(onStack[w]) {
                cycle = new Stack<Integer>();
                for(int x = v; x != w; x = edgeTo[x])
                    cycle.push(x);
                cycle.push(w);
                cycle.push(v);
            }
        onStack[v] = false;
    }
    
    public boolean hasCycle() {
        return cycle != null;
    }
    
    public Iterable<Integer> cycle() {
        return cycle;
    }
}
