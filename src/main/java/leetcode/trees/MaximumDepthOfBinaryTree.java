package leetcode.trees;

/**
 * Runtime: 1 ms, faster than 73.46% of Java online submissions for Maximum Depth of Binary Tree.
 */
public class MaximumDepthOfBinaryTree {

    int max = 0;

    public int maxDepth(TreeNode root) {

        recurse(root, 0);
        return max;

    }

    void recurse(TreeNode root, int depth) {
        if (root == null)
            return;

        depth++;
        max = Math.max(depth, max);

        recurse(root.left, depth);
        recurse(root.right, depth);
    }

}
