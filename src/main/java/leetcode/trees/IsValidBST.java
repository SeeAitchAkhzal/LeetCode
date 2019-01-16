package leetcode.trees;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree
 */
public class IsValidBST {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {

        if (root == null)
            return true;
        return isValid(root, null, null);
    }

    boolean isValid(TreeNode root, Integer min, Integer max) {

        if (min != null && root.val <= min)
            return false;

        if (max != null && root.val >= max)
            return false;

        boolean lt = true;
        boolean rt = true;

        if (root.left != null) {

            lt = isValid(root.left, min, root.val);
        }

        if (root.right != null) {
            rt = isValid(root.right, root.val, max);
        }

        return lt && rt;
    }

}
