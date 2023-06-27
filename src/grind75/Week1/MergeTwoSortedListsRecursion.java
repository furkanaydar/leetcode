package grind75.Week1;

import common.ListNode;

import java.util.List;

public class MergeTwoSortedListsRecursion {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }

        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
    }

    public static ListNode cr(List<Integer> l, int i) {
        return new ListNode(l.get(i), i < l.size()-1 ? cr(l, i+1) : null);
    }

    public static void main(String[] args) {
        MergeTwoSortedLists m = new MergeTwoSortedLists();
        List<Integer> ll1 = List.of(-4,-2,0,1,4);
        List<Integer> ll2 = List.of(-9,-8,-6,-6,-5,-1,1,4,9);

        ListNode res = m.mergeTwoLists(cr(ll1, 0), cr(ll2, 0));
        int x = 5;
    }
}
