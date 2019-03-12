package leetcode.linkedlist;

import java.util.HashMap;

/**
 * Runtime: 3 ms, faster than 54.36% of Java online submissions for Copy List with Random Pointer.
 * Memory Usage: 28.1 MB, less than 38.52% of Java online submissions for Copy List with Random Pointer.
 */
public class CopyRandomList {

    class RandomListNode {

        int label;
        RandomListNode next, random;

        RandomListNode(int x) { this.label = x; }
    }

    public RandomListNode copyRandomList(RandomListNode head) {

        RandomListNode copyHead = null;
        if (head == null)
            return copyHead;

        HashMap<RandomListNode, Integer> nodeToIndex = new HashMap<>();
        HashMap<Integer, RandomListNode> indexToNode = new HashMap<>();
        RandomListNode temp = head;
        RandomListNode prev = null;

        int i = 0;
        while (temp != null) {

            nodeToIndex.put(temp, i);

            RandomListNode copyNode = new RandomListNode(temp.label);
            if (copyHead == null) {
                copyHead = copyNode;
            }

            if (prev != null) {
                prev.next = copyNode;
            }

            indexToNode.put(i, copyNode);
            prev = copyNode;
            temp = temp.next;
            i++;
        }

        temp = head;
        RandomListNode temp2 = copyHead;

        while (temp != null) {

            RandomListNode randNext = temp.random;

            if (randNext != null) {
                int j = nodeToIndex.get(randNext);
                RandomListNode randNode = indexToNode.get(j);
                temp2.random = randNode;
            }

            temp2 = temp2.next;
            temp = temp.next;
        }

        return copyHead;
    }

}
