package p143.ReorderLinkedList;

//find the middle, reverse second half, merge two linked lists


public class Solution {
    public void reorderList(ListNode head) {
        ListNode middle = findMiddle(head);
        ListNode head2 = middle.next;
        middle.next = null; middle = null;
        head2 = reverse(head2);
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
        ListNode prev = null, next = null, curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    private void merge(ListNode l1, ListNode l2) {
        ListNode t1, t2;
        while (l2 != null) {
            t1 = l1.next;
            t2 = l2.next;
            l1.next = l2;
            l2.next = t1;
            l1 = t1;
            l2 = t2;
        }
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