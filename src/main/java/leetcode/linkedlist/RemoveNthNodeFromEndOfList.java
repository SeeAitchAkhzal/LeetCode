package leetcode.linkedlist;

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) { val = x; }
}

/**
 * Runtime: 11 ms, faster than 93.61% of Java online submissions for Remove Nth Node From End of List.
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = null;
        ListNode prev = null;

        while (fast != null) {

            n--;

            if (n <= 0) {
                prev = slow;
                slow = slow == null ? head : slow.next;
            }

            fast = fast.next;
        }

        // remove the first element
        if (prev == null)
            head = head.next;
        else {
            prev.next = slow.next;
        }

        return head;
    }

}
