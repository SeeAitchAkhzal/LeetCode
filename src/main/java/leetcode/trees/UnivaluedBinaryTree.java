package leetcode.trees;

/**
 * Runtime: 3 ms, faster than 99.85% of Java online submissions for Univalued Binary Tree.
 * Memory Usage: 36.8 MB, less than 100.00% of Java online submissions for Univalued Binary Tree.
 */
public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return true;
        return check(root, root.val);
    }

    boolean check(TreeNode root, int val) {
        if (root == null)
            return true;

        if (root.val != val)
            return false;

        return check(root.left, val) && check(root.right, val);
    }

}
