package p141.LinkedListCycle;

import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle2(ListNode head) {
        HashMap<ListNode, Integer> hash = new HashMap<>();
        while (head != null && !hash.containsKey(head)) {
            hash.put(head, 1);
            head = head.next;
        }
        if (head == null) return false;
        return true;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode p1 = head, p2 = head;
        while (p1 != null && p2 != null && p1 != p2) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        if (p1 == p2) return true;
        return false;
    }



}