package chapter1_5_Case_Study_Union_Find;

import algs4.StdIn;
import algs4.StdOut;

public class UF {
    private int[] id; // 分量id（以触点作为索引）
    private int count; // 分量数量

    public UF(int N) {
        // 初始化分量 id 数组
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    
    /* quick-find 算法 */
//    public int find(int p) {
//        return id[p];
//    }
//
//    public void union(int p, int q) {
//        // 将 p 和 q 归并到同样的分量中
//        int pID = find(p);
//        int qID = find(q);
//        
//        // 如果 p 和 q 已经在相同的分量之中则不需要采取任何行动
//        if(pID == qID)
//            return;
//        
//        // 将 p 的分量重命名为 q 的名称
//        for(int i = 0; i < id.length; i++)
//            if(id[i] == pID)
//                id[i] = qID;
//        count--;
//    }
    
    /* quick-union 算法 */
    private int find(int p) {
        // 找出分量的名称
        while(p != id[p])
            p = id[p];
        return p;
    }
    
    private void union(int p, int q) {
        // 将 p 和 q 的根节点统一
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot)
            return;
        
        id[pRoot] = qRoot;
        
        count--;
    }

    public static void main(String[] args) {
        // 解决由StdIn得到的动态连通性问题
        int N = StdIn.readInt();    // 读取触点数量
        UF uf = new UF(N);    // 初始化 N 个分量
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();    // 读取整数对
            if (uf.connected(p, q))     // 如果已经连通则忽略
                continue;
            uf.union(p, q);    // 归并分量
            StdOut.println(p + " " + q);    // 打印连接
        }
        StdOut.println(uf.count + "components");
    }
}
