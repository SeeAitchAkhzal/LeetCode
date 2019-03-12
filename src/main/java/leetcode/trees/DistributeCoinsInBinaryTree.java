package leetcode.trees;

/**
 * Runtime: 10 ms, faster than 100.00% of Java online submissions for Distribute Coins in Binary Tree.
 */
public class DistributeCoinsInBinaryTree {

    int moves = 0;

    public int distributeCoins(TreeNode root) {

        if (root == null)
            return moves;

        recurse(root);

        return moves;

    }

    int recurse(TreeNode root) {

        if (root == null)
            return 0;

        int leftCount = recurse(root.left);
        if (leftCount != 0)
            moves += Math.abs(leftCount);

        int rightCount = recurse(root.right);
        if (rightCount != 0)
            moves += Math.abs(rightCount);

        return root.val + leftCount + rightCount - 1;
    }

}
