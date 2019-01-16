package leetcode.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Runtime: 11 ms, faster than 74.13% of Java online submissions for Merge k Sorted Lists.
 */
public class MergeKSortedLists {

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    class Item {

        public Item(ListNode node, int index) {
            this.node = node;
            this.index = index;
        }

        ListNode node;
        int index;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;

        int k = lists.length;
        ListNode[] travs = new ListNode[lists.length];
        PriorityQueue<Item> q = new PriorityQueue<Item>(new Comparator<Item>() {

            @Override
            public int compare(Item i1, Item i2) {
                return i1.node.val - i2.node.val;
            }
        });

        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                q.add(new Item(lists[i], i));
                travs[i] = lists[i];
            }
        }

        ListNode newList = null;
        ListNode temp = null;

        while (!q.isEmpty()) {
            Item it = q.poll();

            travs[it.index] = travs[it.index].next;
            if (travs[it.index] != null) {
                q.add(new Item(travs[it.index], it.index));
            }

            if (newList == null) {
                temp = newList = it.node;
            } else {
                temp.next = it.node;
                temp = it.node;
            }

            temp.next = null;

        }

        return newList;
    }

}
