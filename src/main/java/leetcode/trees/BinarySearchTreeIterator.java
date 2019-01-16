package leetcode.trees;

import java.util.Stack;

public class BinarySearchTreeIterator {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    int next;
    Stack<TreeNode> s = new Stack<>();

    public BinarySearchTreeIterator(TreeNode root) {
        while (root != null) {
            s.push(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        int ret;
        TreeNode n = s.pop();
        ret = n.val;

        if (n.right != null) {

            s.push(n.right);
            n = n.right;

            while (n.left != null) {
                s.push(n.left);
                n = n.left;
            }

            n = n.right;
        }

        return ret;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return s.size() != 0;
    }

}
