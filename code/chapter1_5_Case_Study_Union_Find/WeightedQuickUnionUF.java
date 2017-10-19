package chapter1_5_Case_Study_Union_Find;

/**
 * 加权 quick-union 算法
 * @author huang
 */
public class WeightedQuickUnionUF {
    private int[] id;    // 父链接数组（由触点索引）
    private int[] sz;    // （由触点索引的）各个根节点所对应的分量的大小
    private int count;    // 连通分量的数量 
    
    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++)
            id[i] = i;
        sz = new int[N];
        for(int i = 0; i < N; i++)
            sz[i] = 1;
    }
    
    public int count() {
        return count;
    }
    
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    
    public int find(int p) {
        // 跟随链接找到根节点
        while(p != id[p])
            p = id[p];
        return p;
    }
    
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot)
            return;
        // 将小树的根节点连接到大树的根节点
        if(sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        count--;
    }
}
