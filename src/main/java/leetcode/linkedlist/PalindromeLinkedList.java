package leetcode.linkedlist;

import java.util.Stack;

/**
 * Runtime: 2 ms, faster than 54.25% of Java online submissions for Palindrome Linked List.
 */
public class PalindromeLinkedList {

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null)
            return true;

        ListNode f = head;
        ListNode r = head;
        Stack<Integer> s = new Stack();

        int len = 0;
        while (r != null) {
            len++;
            r = r.next;
        }
        r = head;

        while (f != null) {
            s.push(r.val);
            r = r.next;

            if (f.next != null) {
                f = f.next.next;
            } else {
                f = null;
            }
        }

        if (len % 2 != 0)
            s.pop();

        while (!s.isEmpty() && r != null) {
            if (s.pop() != r.val)
                return false;
            r = r.next;
        }

        return true;
    }

}
