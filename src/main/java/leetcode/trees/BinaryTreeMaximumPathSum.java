package leetcode.trees;

/**
 * Runtime: 2 ms, faster than 41.53% of Java online submissions for Binary Tree Maximum Path Sum.
 */
public class BinaryTreeMaximumPathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    Integer max;

    public int maxPathSum(TreeNode root) {

        dfs(root);
        return max;
    }

    int dfs(TreeNode root){

        int localMax = root.val;
        int ls = 0;
        int rs = 0;

        if(root.left != null){
            ls = dfs(root.left);
            // ls = Math.max(ls, root.val+ls);

        }

        if(root.right != null){
            rs = dfs(root.right);
            // rs = Math.max(rs, Math.max(root.val, root.val+rs));
        }

        localMax = Math.max(root.val, Math.max(root.val+ls+rs,Math.max(ls+root.val, rs+root.val)));

        if(max == null)
            max = localMax;
        max = Math.max(max,localMax);

        return Math.max(root.val,Math.max(ls+root.val, rs+root.val));
    }
}
