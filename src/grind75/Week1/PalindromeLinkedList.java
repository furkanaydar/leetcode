package grind75.Week1;

import common.ListNode;

public class PalindromeLinkedList {

    public ListNode reverse(ListNode prev, ListNode head) {
        while (head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }

        return prev;
    }

    public ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;

        while (head != null) {
            head = head.next;

            if (head != null) {
                head = head.next;
            }

            if (head != null) {
                slow = slow.next;
            }
        }

        return slow;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode middle = getMiddleNode(head);
        ListNode endNode = reverse(middle, middle.next);
        middle.next = null;
        while (head != null && endNode != null) {
            if (head.val != endNode.val) {
                return false;
            }

            head = head.next;
            endNode = endNode.next;
        }

        return true;
    }
}
