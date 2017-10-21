package chapter4_1_Undirected_Graphs;

/**
 * 利用深度优先，判断 G 是否是无向图（假设不存在自环或平行边）
 * @author huang
 */
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;
    public Cycle(Graph G) {
        marked = new boolean[G.V()];
        for(int s = 0; s < G.V(); s++)
            if(!marked[s])
                dfs(G, s, s);
    }
    
    private void dfs(Graph G, int v, int u) {
        marked[v] = true;
        for(int w : G.adj(v)) {
            if(!marked[w])
                dfs(G, w, v);
            else if(w != u)    // v 是从 u 深度遍历得到的。因为不存在平行边，所以 w != v 即刻认为遇到了之前遍历过的点（即有环）
                hasCycle = true;
        }
    }
    
    public boolean hasCycle() {
        return hasCycle;
    }
}
