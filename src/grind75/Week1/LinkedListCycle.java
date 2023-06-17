package grind75.Week1;

import common.ListNode;

public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            if (fast.next == slow) {
                return true;
            }

            if (fast.next == null) {
                return false;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }

    public static ListNode case1() {
        ListNode loopPoint = new ListNode(2);
        loopPoint.next = new ListNode(0, new ListNode(-4, loopPoint));
        return new ListNode(3, loopPoint);
    }

    public static ListNode case2() {
        ListNode head = new ListNode(1);
        ListNode loopPoint = new ListNode(2);
        loopPoint.next = head;
        head.next = loopPoint;
        return head;
    }

    public static ListNode case3() {
        return new ListNode(1);
    }

    public static void main(String[] args) {
        System.out.println(hasCycle(case1()));
        System.out.println(hasCycle(case2()));
        System.out.println(hasCycle(case3()));

    }
}
