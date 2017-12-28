package chapter3_4_Hash_Tables;

import java.util.Iterator;

import algs4.Queue;
import chapter3_1_Symbol_Tables.SequentialSearchST;

@SuppressWarnings("unchecked")
public class SeparateChainingHashST<Key, Value> {
    private int N;    // 键值对总数
    private int M;    // 散列表的大小
    private SequentialSearchST<Key, Value>[] st;    // 存放链表对象的数组
    
    public SeparateChainingHashST() {
        this(997);
    }
    
    public SeparateChainingHashST(int M) {
        // 创建 M 条链表
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for(int i = 0; i < M; i++)
            st[i] = new SequentialSearchST<Key, Value>();
    }
    
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    
    public Value get(Key key) {
        return (Value) st[hash(key)].get(key);
    }
    
    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
    }
    
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for(int i = 0; i < M; i++)
            for(Iterator<Key> iter = (Iterator<Key>) st[i].keys(); iter.hasNext();)
                queue.enqueue(iter.next());
        return queue;
    }
}
