package chapter4_2_Directed_Graphs;

import algs4.Bag;
import algs4.In;

public class Digraph {
    
    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    
    @SuppressWarnings("unchecked")
    public Digraph(int V) {    // 创建一幅含有 V 个顶点但没有边的有向图
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    
    public Digraph(In in) {    // 从输入流 in 中读取一幅有向图
        this(in.readInt());    // 读取 V 并将图初始化
        int E = in.readInt();    // 读取 E
        for(int i = 0; i < E; i++) {
            // 添加一条边
            int v = in.readInt();    // 读取一个顶点
            int w = in.readInt();    // 读取另一个顶点
            addEdge(v, w);    // 添加一条连接它们的边
        }
    }
    
    public int V() {    // 顶点总数
        return V;
    }
    
    public int E() {    // 边的总数
        return E;
    }
    
    void addEdge(int v, int w) {    // 向有向图中添加一条边 v -> w
        adj[v].add(w);
        E++;
    }
    
    public Iterable<Integer> adj(int v) {    // 由 v 指出的边所连接的所有顶点
        return adj[v];
    }
    
    public Digraph reverse() {    // 该图的反向图
        Digraph R = new Digraph(V);
        for(int v = 0; v < V; v++)
            for(int w : adj(v))
                R.addEdge(w, v);
        return R;
    }
    
}
