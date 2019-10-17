package p234.PalindromeLinkedList;

class Solution2 {
    public boolean isPalindrome(ListNode head) {

        // find length of list
        int n = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            n++;
        }

        // iterate through first half, reversing as we go
        ListNode p1, p2;
        p1 = p2 = new ListNode(0);
        p1.next = head;
        p2 = p2.next;
        for (int i = 0; i < n / 2; i++) {
            ListNode next = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = next;
        }
        if (n % 2 == 1) p2 = p2.next;

        // check if palindrome
        while (p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}
