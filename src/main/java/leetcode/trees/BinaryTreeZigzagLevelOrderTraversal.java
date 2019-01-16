package leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Runtime: 3 ms, faster than 16.82% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null)
            return result;

        Queue<TreeNode> q = new LinkedList();
        Stack<TreeNode> s = new Stack<>();
        q.add(root);
        boolean flip = false;

        while (!q.isEmpty()) {

            int lim;
            List<Integer> curr = new ArrayList();
            lim = q.size();

            for (int i = 0; i < lim; i++) {
                TreeNode n = q.poll();
                curr.add(n.val);

                if (!flip) {
                    if (n.left != null)
                        s.add(n.left);
                    if (n.right != null)
                        s.add(n.right);
                } else {
                    if (n.right != null)
                        s.add(n.right);
                    if (n.left != null)
                        s.add(n.left);
                }
            }

            while (!s.isEmpty()) {
                q.add(s.pop());
            }

            flip = !flip;
            result.add(curr);
        }

        return result;
    }

}
