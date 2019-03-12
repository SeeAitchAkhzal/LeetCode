package leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Leaves of Binary Tree.
 * Memory Usage: 26.2 MB, less than 33.75% of Java online submissions for Find Leaves of Binary Tree.
 */
public class FindLeavesOfBinaryTrees {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {

        findHeight(root);
        return res;
    }

    int findHeight(TreeNode n) {
        if (n == null)
            return -1;

        int left = findHeight(n.left);
        int right = findHeight(n.right);

        int lvl = Math.max(left, right) + 1;

        List<Integer> lst;
        if (res.size() < lvl + 1) {
            lst = new ArrayList();
            res.add(lst);
        } else {
            lst = res.get(lvl);
        }

        lst.add(n.val);

        return lvl;
    }

}
