package chapter4_3_Minimum_Spanning_Tree;

import algs4.Bag;
import algs4.In;

/*
 * 加权无向图
 */
public class EdgeWeightedGraph {
    private final int V;    // 顶点总数
    private int E;    // 边的总数
    private Bag<Edge>[] adj;    // 邻接表
    
    @SuppressWarnings("unchecked")
    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for(int v = 0; v < V; v++)
            adj[v] = new Bag<Edge>();
    }
    
    public EdgeWeightedGraph(In in) {
        this(in.readInt());    // 读取 V 并将图初始化
        int E = in.readInt();    // 读取 E
        for(int i = 0; i < E; i++) {
            // 添加一条边
            int v = in.readInt();    // 读取一个顶点
            int w = in.readInt();    // 读取另一个顶点
            double weight = in.readDouble();    // 读取权重
            Edge e = new Edge(v, w, weight);
            addEdge(e);    // 添加一条连接它们的边
        }
    }
    
    public int V() {
        return V;
    }
    
    public int E() {
        return E;
    }
    
    public void addEdge(Edge e) {
        int v = e.either(),
            w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }
    
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }
    
    // 图的所有边
    public Iterable<Edge> edges() {
        Bag<Edge> b = new Bag<Edge>();
        for(int v = 0; v < V; v++)
            for(Edge e : adj[v])
                if(e.other(v) > v)
                    b.add(e);
        return b;
    }
    
}
