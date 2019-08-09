package p143.ReorderLinkedList;

//find the middle, reverse second half, merge two linked lists


public class Solution {
    public void reorderList(ListNode head) {
        ListNode middle = findMiddle(head);
        ListNode head2 = middle.next;
        middle.next = null;
        head2 = reverse(middle.next);
        merge(head, head2);
    }
    
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode p1 = head;
        if (p1 == null) return p1;
        ListNode p2 = p1.next;
        if (p2 == null) return p1;
        ListNode p3 = p2.next;
        p1.next = null;
        while (p3 != null) {
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }
        p2.next = p1;
        return p2;
    }
    
    private void merge(ListNode l1, ListNode l2) {
        ListNode t1, t2;
        while (l1.next != null && l2.next != null) {
            t1 = l1.next;
            t2 = l2.next;
            l1.next = l2;
            l2.next = t1;
            l1 = t1;
            l2 = t2;
        }
        if (l1.next == null) l1.next = l2;
        if (l2.next == null) l2.next = l1;
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	head.next.next.next = new ListNode(4);
    	Solution s = new Solution();
    	s.reorderList(head);
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}