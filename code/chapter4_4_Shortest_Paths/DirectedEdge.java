package chapter4_4_Shortest_Paths;

/**
 * @author huang
 * 加权有向边的数据类型
 */
public class DirectedEdge {
    private final int v;    // 边的起点
    private final int w;    // 边的终点
    private final double weight;    // 边的权重
    
    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    
    public double weight() {
        return weight;
    }
    
    public int from() {
        return v;
    }
    
    public int to() {
        return w;
    }
    
    public String toString() {
        return String.format("%d->%d %.2f", v, w, weight);
    }
}
