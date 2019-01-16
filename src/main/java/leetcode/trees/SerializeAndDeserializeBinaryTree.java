package leetcode.trees;

import java.util.Stack;

/**
 * Runtime: 28 ms, faster than 23.05% of Java online submissions for Serialize and Deserialize Binary Tree.
 */
public class SerializeAndDeserializeBinaryTree {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);

        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null || data == "")
            return null;

        TreeNode root = null;

        int i = 1;
        String[] tokens = data.split(" ");
        Stack<TreeNode> s = new Stack<>();

        TreeNode parent = null;
        int len = tokens.length;
        boolean flag = false;

        while (i < len) {

            while (i < len && !tokens[i].equals("null")) {

                TreeNode ln = new TreeNode(Integer.parseInt(tokens[i]));
                if (parent != null)
                    parent.left = ln;
                if (root == null)
                    root = ln;
                if (flag) {
                    flag = false;
                    s.pop().right = ln;
                }
                s.push(ln);
                parent = ln;

                i++;
            }

            TreeNode n = s.pop();
            i++;

            if (!flag) {
                // is leaf?
                if (i < len && tokens[i].equals("null")) {
                    parent = null;
                    flag = true;
                    i++;
                } else if (i < len) {
                    TreeNode rn = new TreeNode(Integer.parseInt(tokens[i]));
                    n.right = rn;
                    s.push(rn);
                    i++;
                    parent = rn;
                }
            }
        }

        return root;
    }

    void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(" null");
            return;
        }

        sb.append(" " + root.val);
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }
}
