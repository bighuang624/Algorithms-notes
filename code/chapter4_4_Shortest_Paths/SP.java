package chapter4_4_Shortest_Paths;

/**
 * @author huang
 * 最短路径的 API
 */
public interface SP {
    // 从顶点 s 到 v 的距离，如果不存在则路径为无穷大
    double distTo(int v);
    // 是否存在从顶点 s 到 v 的路径
    boolean hasPathTo(int v);
    // 从顶点 s 到 v 的路径，如果不存在则为 null
    Iterable<DirectedEdge> pathTo(int v);
}
