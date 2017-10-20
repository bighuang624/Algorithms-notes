package chapter4_1_Undirected_Graphs;

/**
 * 查找连通分量
 * @author huang
 */
public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;  // 既用来计量连通分量，同时作为连通分量的下标
    
    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for(int s = 0; s < G.V(); s++)
            if(!marked[s]) {
                dfs(G, s);
                count++;
            }
    }
    
    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for(int w : G.adj(v))
            if(!marked[w])
                dfs(G, w);
    }
    
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }
    
    public int id(int v) {
        return id[v];
    }
    
    public int count() {
        return count;
    }
}
