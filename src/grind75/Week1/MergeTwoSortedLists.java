package grind75.Week1;

import common.ListNode;

import java.util.List;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = list1;
        if (list1 == null) {
            head = list2;
        } else if (list2 != null) {
            head = list1.val <= list2.val ? list1 : list2;
        }

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (list1.next == null) {
                    list1.next = list2;
                    break;
                }
                else if (list1.next.val < list2.val) {
                    list1 = list1.next;
                } else {
                    ListNode tmp = list1.next;
                    ListNode lTmp = list2.next;
                    list1.next = list2;
                    list2.next = tmp;
                    list2 = lTmp;
                }
            } else {
                if (list2.next == null) {
                    list2.next = list1;
                    break;
                }
                else if (list2.next.val < list1.val) {
                    list2 = list2.next;
                } else {
                    ListNode tmp = list2.next;
                    ListNode lTmp = list1.next;
                    list2.next = list1;
                    list1.next = tmp;
                    list1 = lTmp;
                }
            }
        }

        return head;
    }

    public static ListNode cr(List<Integer> l, int i) {
        return new ListNode(l.get(i), i < l.size()-1 ? cr(l, i+1) : null);
    }

    public static void main(String[] args) {
        MergeTwoSortedLists m = new MergeTwoSortedLists();
        List<Integer> ll1 = List.of(-4,-2,0,1,4);
        List<Integer> ll2 = List.of(-9,-8,-6,-6,-5,-1,1,4,9);

        m.mergeTwoLists(cr(ll1, 0), cr(ll2, 0));
    }
}
