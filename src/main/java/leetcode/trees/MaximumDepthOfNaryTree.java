package leetcode.trees;

import java.util.List;

/**
 * Runtime: 3 ms, faster than 77.91% of Java online submissions for Maximum Depth of N-ary Tree.
 */


public class MaximumDepthOfNaryTree {
    int maxDepth = 0;
    public int maxDepth(Node root) {
        findDepth(root, 0);
        return maxDepth;
    }


    void findDepth(Node root, int depth){

        if(root == null){
            return;
        }

        depth++;
        maxDepth = Math.max(maxDepth, depth);

        for(Node child: root.children){
            findDepth(child, depth);
        }

        depth--;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
