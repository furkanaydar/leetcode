package grind75.Week4;

import common.ListNode;

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int c = 0;
        ListNode tmp = head, res = head;
        ListNode prev = null;
        while (tmp != null) {
            if (c>=n) {
                prev = head;
                head = head.next;
            }

            tmp = tmp.next;
            c++;
        }

        if (prev == null) {
            return res.next;
        }

        prev.next = prev.next.next;
        return res;
    }
}
