package chapter3_1_Symbol_Tables;

public class SequentialSearchST<Key, Value>{
    private Node first;    // 链表首结点
    private class Node {
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    
    public Value get(Key key) {
        // 查找给定的键，返回相关联的值
        for(Node x = first; x != null; x = x.next)
            if(key.equals(x.key))
                return x.val;    // 命中
        return null;    // 未命中
    }
    
    public void put(Key key, Value val) {
        // 查找给定的键，找到则更新其值，否则在表中新建结点
        for(Node x = first; x != null; x = x.next)
            if(key.equals(x.key)) {
                x.val = val;
                return;    // 命中，更新
            }
        first = new Node(key, val, first);    // 未命中，新建结点
    }
    
}
