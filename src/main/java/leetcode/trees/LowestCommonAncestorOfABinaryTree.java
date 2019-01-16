package leetcode.trees;

/**
 * Runtime: 9 ms, faster than 48.16% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
 */
public class LowestCommonAncestorOfABinaryTree {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    boolean found = false;

    class State {

        boolean p;
        boolean q;
        TreeNode n;

        public State(TreeNode n, boolean p, boolean q) {
            this.n = n;
            this.p = p;
            this.q = q;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;

        return LCA(root, p, q).n;
    }

    State LCA(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return new State(null, false, false);

        State s = new State(null, false, false);
        if (root.val == p.val) {
            s.p = true;
        }

        if (root.val == q.val) {
            s.q = true;
        }

        State a = LCA(root.left, p, q);
        State b = LCA(root.right, p, q);
        boolean seenP = a.p || b.p || s.p;
        boolean seenQ = a.q || b.q || s.q;

        if (seenP && seenQ) {
            if (found) {
                return a.n == null ? b : a;
            }

            found = true;
            return new State(root, true, true);
        }

        return new State(null, seenP, seenQ);
    }

}
