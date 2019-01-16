package leetcode.linkedlist;

/**
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
 */
public class ReverseLinkedList {

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {

        if (head == null)
            return head;

        ListNode trav = head;
        ListNode prev = null;
        ListNode next = null;

        while (trav != null) {

            next = trav.next;
            trav.next = prev;
            head = trav;
            prev = trav;

            trav = next;

        }

        return head;

    }
}
