package p160.IntersectionOfTwoLinkedLists;

public class Solution {
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode ta = headA;
        ListNode tb = headB;
        while (ta != null && tb!= null) {
            ta = ta.next;
            tb = tb.next;
        }
        if (ta == null) ta = headB;
        if (tb == null) tb = headA;
        while (ta != null && tb != null) {
            ta = ta.next;
            tb = tb.next;
        }
        if (ta == null) ta = headB;
        if (tb == null) tb = headA;
        while (ta != null && tb != null) {
            if (ta == tb) return ta;
            ta = ta.next;
            tb = tb.next;
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA != null ? pA.next : headB;
            pB = pB != null ? pB.next : headA;
        }
        return pA;
    }
}


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
