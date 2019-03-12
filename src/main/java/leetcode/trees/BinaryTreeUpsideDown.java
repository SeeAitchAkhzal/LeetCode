package leetcode.trees;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Upside Down.
 * Memory Usage: 25.9 MB, less than 40.81% of Java online submissions for Binary Tree Upside Down.
 */
public class BinaryTreeUpsideDown {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        TreeNode change = null;
        public TreeNode upsideDownBinaryTree(TreeNode root) {

            recurse(root);
            return change;
        }

        TreeNode recurse(TreeNode root){

            if(root == null) return null;


            TreeNode newRoot = recurse(root.left);

            if(newRoot == null){
                change = root;
                return root;
            }

            newRoot.left = root.right;
            newRoot.right = root;
            root.right = root.left = null;



            return newRoot.right;


        }
    }
}
