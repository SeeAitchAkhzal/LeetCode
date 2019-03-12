package leetcode.misc;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * untime: 109 ms, faster than 61.81% of Java online submissions for Max Stack.
 * Memory Usage: 43.5 MB, less than 16.86% of Java online submissions for Max Stack.
 */
public class MaxStack {

    Stack<Integer> s = new Stack<>();
    PriorityQueue<Integer> q = new PriorityQueue<>((i1, i2)-> i2 - i1);

    /** initialize your data structure here. */
    public MaxStack() {

    }

    public void push(int x) {
        s.push(x);
        q.add(x);
    }

    public int pop() {
        int ret = s.pop();
        q.remove(ret);
        return ret;
    }

    public int top() {
        return s.peek();
    }

    public int peekMax() {
        return q.peek();
    }

    public int popMax() {
        int ret = q.poll();

        Stack<Integer> temp = new Stack<>();
        while(s.peek() != ret) {
            temp.push(s.pop());
        }

        s.pop();
        while(!temp.isEmpty()){
            s.push(temp.pop());
        }

        return ret;
    }

}
