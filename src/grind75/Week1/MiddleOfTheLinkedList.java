package grind75.Week1;

import common.ListNode;

public class MiddleOfTheLinkedList {

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode case1() {
        return new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    }


    public static ListNode case2() {
        return new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
    }

    public static ListNode case3() {
        return new ListNode(1);
    }

    public static ListNode case4() {
        return new ListNode(1, new ListNode(2));
    }

    public static void main(String[] args) {
        System.out.println(middleNode(case1()).val);
        System.out.println(middleNode(case2()).val);
        System.out.println(middleNode(case3()).val);
        System.out.println(middleNode(case4()).val);
    }

}
