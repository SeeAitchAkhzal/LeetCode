package leetcode.linkedlist;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Runtime: 4 ms, faster than 76.97% of Java online submissions for Flatten Nested List Iterator.
 */
public class FlattenNestedListIterator implements Iterator<Integer> {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    Iterator<NestedInteger> it;
    Stack<Iterator<NestedInteger>> s = new Stack<>();
    Integer next;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {

        it = nestedList.iterator();
        s.push(it);
    }

    @Override
    public Integer next() {

        return next;
    }

    @Override
    public boolean hasNext() {

        while (!s.isEmpty()) {
            it = s.pop();

            if (it.hasNext()) {

                NestedInteger ni = it.next();
                s.push(it);
                if (ni.isInteger()) {
                    next = ni.getInteger();
                    return true;
                } else {

                    s.push(ni.getList().iterator());
                }
            }
        }

        return false;
    }
}
