package chapter4_3_Minimum_Spanning_Tree;

import java.beans.Visibility;

import algs4.MinPQ;
import algs4.Queue;

/*
 * 最小生成树的 Prim 算法的延时实现
 */
public class LazyPrimMST {
    private boolean[] marked;    // 最小生成树的顶点
    private Queue<Edge> mst;    // 最小生成树的边 
    private MinPQ<Edge> pq;    // 横切边（包括失效的边）
    
    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new MinPQ<Edge>();
        marked = new boolean[G.V()];
        mst = new Queue<Edge>();
        
        visit(G, 0);
        while(!pq.isEmpty()) {
            Edge e = pq.delMin();    // 从 pq 中得到权重最小的边
            
            int v = e.either(),
                w = e.other(v);
            if(marked[v] && marked[w])
                continue;    // 跳过失效的边
            mst.enqueue(e);    // 将边加入到树中
            if(!marked[v])    // 将顶点（v 或 w）添加到树中
                visit(G, v);
            if(!marked[w])
                visit(G, w);
        }
    }
    
    private void visit(EdgeWeightedGraph G, int v) {
        // 标记顶点 v 并将所有连接 v 和未被标记顶点的边加入 pq
        marked[v] = true;
        for(Edge e : G.adj(v))
            if(!marked[e.other(v)])
                pq.insert(e);
    }
    
    public Iterable<Edge> edges() {
        return mst;
    }
    
    public double weight() {
        
    }
}
