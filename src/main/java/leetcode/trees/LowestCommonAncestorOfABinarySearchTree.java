package leetcode.trees;

/**
 * Runtime: 4 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
 */
public class LowestCommonAncestorOfABinarySearchTree {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            return LCA(root, p, q);
        }

        TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {

            if (root == null)
                return root;

            if ((p.val >= root.val && q.val <= root.val) ||
                (p.val <= root.val && q.val >= root.val)) {
                return root;
            }

            if (p.val < root.val)
                return LCA(root.left, p, q);

            return LCA(root.right, p, q);
        }

    }
}
