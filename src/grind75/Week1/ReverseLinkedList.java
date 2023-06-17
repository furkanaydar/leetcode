package grind75.Week1;

import common.ListNode;

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }

        return prev;
    }

    public static void main(String[] args) {
        System.out.println(reverseList(case1()).val);
        System.out.println(reverseList(case2()).val);
        System.out.println(reverseList(case3()).val);
    }

    public static ListNode case1() {
        return new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    }


    public static ListNode case2() {
        return new ListNode(1);
    }

    public static ListNode case3() {
        return new ListNode(1, new ListNode(2));
    }
}