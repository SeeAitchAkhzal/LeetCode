package leetcode.linkedlist;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null)
            return null;

        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        ListNode temp3 = null;
        ListNode newHead = null;
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while (temp1 != null && temp2 != null) {

            boolean flag = temp1.val < temp2.val;

            if (flag) {

                if (newHead == null) {
                    temp3 = newHead = temp1;
                    temp1 = temp1.next;
                    temp3.next = null;
                } else {
                    temp3.next = temp1;
                    temp1 = temp1.next;
                    temp3 = temp3.next;
                    temp3.next = null;
                }

            } else {
                if (newHead == null) {
                    temp3 = newHead = temp2;
                    temp2 = temp2.next;
                    temp3.next = null;
                } else {
                    temp3.next = temp2;
                    temp2 = temp2.next;
                    temp3 = temp3.next;
                    temp3.next = null;
                }
            }
        }

        while (temp1 != null) {
            temp3.next = temp1;
            temp1 = temp1.next;
            temp3 = temp3.next;
        }

        while (temp2 != null) {
            temp3.next = temp2;
            temp2 = temp2.next;
            temp3 = temp3.next;
        }

        return newHead;

    }

}
