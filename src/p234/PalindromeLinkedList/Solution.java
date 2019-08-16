package p234.PalindromeLinkedList;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public static boolean isPalindrome(ListNode head) {
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }
        if (n == 0 || n == 1) return true;
        int i;
        Stack<Integer> stack = new Stack();
        for (i = 0; i < n/2; i++) {
            stack.push(head.val);
            head = head.next;
        }
        if (n % 2 == 1) head = head.next;
        for (i = 0; i < n/2; i++) {
            if (stack.peek() == head.val) {
                stack.pop();
                head = head.next;
            }
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);

        boolean truf = isPalindrome(node);
        System.out.println(truf);
    }
}