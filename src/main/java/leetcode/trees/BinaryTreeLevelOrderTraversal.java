package leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Runtime: 1 ms, faster than 88.42% of Java online submissions for Binary Tree Level Order Traversal.
 */
public class BinaryTreeLevelOrderTraversal {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        if (root == null)
            return result;

        q.add(root);

        while (!q.isEmpty()) {

            List<Integer> level = new ArrayList<Integer>();
            int lim = q.size();
            for (int i = 0; i < lim; i++) {
                TreeNode n = q.poll();
                level.add(n.val);
                if (n.left != null)
                    q.add(n.left);
                if (n.right != null)
                    q.add(n.right);
            }

            result.add(level);

        }

        return result;
    }

}
