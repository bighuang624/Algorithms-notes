package chapter4_1_Undirected_Graphs;

import algs4.In;
import algs4.ST;

public class SymbolGraph {
    
    private ST<String, Integer> st;    // 符号名 -> 索引
    private String[] keys;    // 索引 -> 符号名
    private Graph G;    // 使用索引表示顶点的图
    
    public SymbolGraph(String filename, String delim) {
        st = new ST<String, Integer>();
        In in = new In(filename);    // 第一遍
        while(in.hasNextLine()) {
            String[] a = in.readLine().split(delim);    // 读取字符串
            for(int i = 0; i < a.length; i++)
                if(!st.contains(a[i]))
                    st.put(a[i], st.size());
        }
        keys = new String[st.size()];    // 用来获得顶点名的反向索引是一个数组
        
        for(String name : st.keys())
            keys[st.get(name)] = name;
        
        G = new Graph(st.size());
        in = new In(filename);    // 第二遍
        while(in.hasNextLine()) {    // 构造图
            String[] a = in.readLine().split(delim);   // 将每一行的第一个顶点和该行的其他顶点相连
            int v = st.get(a[0]);
            for(int i = 1; i < a.length; i++)
                G.addEdge(v, st.get(a[i]));
        }
    }
    
    // key 是一个顶点吗
    boolean contains(String key) {
        return st.contains(key);
    }
    
    // key 的索引
    int index(String key) {
        return st.get(key);
    }
    
    // 索引 v 的顶点名
    String name(int v) {
        return keys[v];
    }
    
    // 隐藏的 Graph 对象
    Graph G() {
        return G;
    }
}
