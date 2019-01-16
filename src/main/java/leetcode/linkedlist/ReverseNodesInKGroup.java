package leetcode.linkedlist;

public class ReverseNodesInKGroup {

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    int k;

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null)
            return head;

        this.k = k;

        ListNode temp = head;
        ListNode prev = head;
        ListNode prevP = null;
        head = null;

        int count = 0;

        while (temp != null) {

            if (count % k == 0 && count != 0) {

                ListNode oldHead = prev;
                // reverse
                ListNode newHead = reverse(prev);
                oldHead.next = temp;

                if (head == null) {
                    head = newHead;
                }
                // join with previous
                if (prevP != null) {
                    prevP.next = newHead;
                }

                prevP = prev;
                prev = temp;
            }

            temp = temp.next;
            count++;
        }

        if (count % k == 0) {

            ListNode oldHead = prev;
            // reverse
            ListNode newHead = reverse(prev);
            oldHead.next = temp;

            if (head == null) {
                head = newHead;
            }
            // join with previous
            if (prevP != null) {
                prevP.next = newHead;
            }

            prevP = prev;
            prev = temp;
        }

        return head == null ? prev : head;
    }

    ListNode reverse(ListNode head) {

        ListNode temp = head;
        ListNode prev = null;
        int j = 0;
        ;

        while (temp != null && j < k) {

            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;

            j++;
            temp = next;
        }

        return prev;
    }

}
