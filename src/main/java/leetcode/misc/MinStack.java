package leetcode.misc;

import java.util.Stack;

/**
 * Runtime: 96 ms, faster than 85.99% of Java online submissions for Min Stack.
 */
public class MinStack {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> min = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {

        s.push(x);

        if(min.size() == 0)
            min.push(x);
        else if(s.peek() <= min.peek())
            min.push(x);

    }

    public void pop() {

        int ret = s.pop();

        if(min.peek() == ret)
            min.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min.peek();
    }

}
