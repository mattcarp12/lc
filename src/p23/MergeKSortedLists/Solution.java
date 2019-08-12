package p23.MergeKSortedLists;


import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode list : lists) {
            while (list != null) {
                pq.add(list.val);
                list = list.next;
            }
        }
        ListNode sol = new ListNode(0);
        ListNode t = sol;
        while (!pq.isEmpty()) {
            t.next = new ListNode(pq.poll());
            t = t.next;
        }
        return sol.next;
    }
}
