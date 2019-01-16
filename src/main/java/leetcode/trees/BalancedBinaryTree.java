package leetcode.trees;

/**
 * Runtime: 1 ms, faster than 99.69% of Java online submissions for Balanced Binary Tree.
 */
public class BalancedBinaryTree {
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        recurse(root);
        return isBalanced;
    }


    int recurse(TreeNode root){

        if(root == null) return 0;

        int lh = recurse(root.left);
        int rh = recurse(root.right);

        if(Math.abs(lh-rh) > 1) isBalanced = false;

        return Math.max(lh,rh) + 1;

    }

}
