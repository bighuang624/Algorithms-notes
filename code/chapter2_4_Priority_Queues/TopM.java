package chapter2_4_Priority_Queues;

import algs4.MinPQ;
import algs4.Stack;
import algs4.StdIn;
import algs4.StdOut;

public class TopM {
    public static void main(String[] args) {
        // 打印输入流中最大的 M 行
        int M = Integer.parseInt(args[0]);
        MinPQ<Transaction> pq = new MinPQ<>(M+1);
        while(StdIn.hasNextLine()) {
            // 为下一行输入创建一个元素并放入优先队列中
            pq.insert(new Transaction(StdIn.readLine()));
            if(pq.size() > M)
                pq.delMin();    // 如果优先队列中存在 M+1 
        }    // 最大的 M 个元素都在优先队列中
        
        Stack<Transaction> stack = new Stack<Transaction>();
        while(!pq.isEmpty()) 
            stack.push(pq.delMin());
        for(Transaction t : stack)
            StdOut.println(t);
    }
}
