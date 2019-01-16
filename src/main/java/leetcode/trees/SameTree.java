package leetcode.trees;

/**
 * Runtime: 4 ms, faster than 93.83% of Java online submissions for Same Tree.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return recurse(p,q);
    }


    boolean recurse(TreeNode p, TreeNode q){

        if(p == null && q == null) return true;

        if(p == null || q == null) return false;

        if(p.val != q.val) return false;


        return recurse(p.left, q.left) &&
               recurse(p.right, q.right);
    }


}
