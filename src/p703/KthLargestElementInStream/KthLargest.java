package p703.KthLargestElementInStream;

import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<Integer>();
        this.k = k;
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) heap.poll();
        }
    }

    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) heap.poll();
        return heap.peek();
    }
}