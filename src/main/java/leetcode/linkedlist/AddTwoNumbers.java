package leetcode.linkedlist;

public class AddTwoNumbers {

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode result = null;
        ListNode temp = null;

        int carry = 0;
        int sum = 0;

        while (l1 != null || l2 != null) {

            int a = 0;
            int b = 0;

            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }

            ListNode newNode = new ListNode((a + b + carry) % 10);

            if (result == null) {
                temp = result = newNode;
            } else {
                temp.next = newNode;
                temp = temp.next;
            }

            carry = (a + b + carry) / 10;
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        return result;
    }
}
