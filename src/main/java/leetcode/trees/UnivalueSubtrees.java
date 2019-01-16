package leetcode.trees;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}

/**
 * Runtime: 1 ms, faster than 99.52% of Java online submissions for Count Univalue Subtrees.
 */
public class UnivalueSubtrees {

    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {

        recurse(root);
        return count;
    }

    Integer recurse(TreeNode root) {

        if (root == null)
            return null;

        if (root.left == null && root.right == null) {
            count++;
            return root.val;
        }

        boolean l = root.left != null;
        boolean r = root.right != null;

        Integer left = recurse(root.left);
        Integer right = recurse(root.right);

        if (l && r) {
            if (left == null || right == null)
                return null;
            else if (left.intValue() == right.intValue() && left.intValue() == root.val) {
                count++;
                return root.val;
            }
            return null;
        }

        if (!l && r) {
            if (right == null) {
                return null;
            } else if (right.intValue() == root.val) {
                count++;
                return root.val;
            }
            return null;
        }

        if (l && !r) {
            if (left == null) {
                return null;
            } else if (left.intValue() == root.val) {
                count++;
                return root.val;
            }
            return null;
        }

        return null;
    }

}
