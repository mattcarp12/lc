package p21.MergeTwoSortedLists;

import ListNode.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode currNode = new ListNode(-1);
        ListNode sol = currNode;
        ListNode next1 = l1.next, next2 = l2.next;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                currNode.next = l1;
                currNode = currNode.next;
                l1 = l1.next;
            } else {
                currNode.next = l2;
                currNode = currNode.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) currNode.next = l1;
        if (l2 != null) currNode.next = l2;
        return sol.next;
    }
}