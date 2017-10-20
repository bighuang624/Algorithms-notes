package chapter4_1_Undirected_Graphs;

import algs4.Stack;

/**
 * edgeTo[w]=v 表示 v-w 是第一次访问 w 时经过的边
 * edgeTo[] 数组是一颗用父链接表示的以 s 为根且含有所有与 s 连通的顶点的树
 * @author huang
 */
public class DepthFirstPaths {
    private boolean[] marked;  // 这个顶点上调用过 dfs() 了吗？
    private int[] edgeTo;  // 从起点到一个顶点的已知路径上的最后一个顶点
    private final int s;  // 起点
    
    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }
    
    private void dfs(Graph G, int v) {
        marked[v] = true;
        for(int w : G.adj(v))
            if(!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
    }
    
    public boolean hasPathTo(int v) {
        return marked[v];
    }
    
    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<>();
        for(int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
}
