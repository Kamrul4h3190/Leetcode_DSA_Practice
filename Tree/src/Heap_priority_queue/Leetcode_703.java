package Heap_priority_queue;


import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode_703 {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println("kth largest : "+kthLargest.add(3));
    }
    static class KthLargest{
        int k;
        PriorityQueue<Integer> minHeap;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            minHeap = new PriorityQueue<>();
            for (int n : nums) {
                minHeap.offer(n);
                if(minHeap.size()>k) minHeap.poll();
            }
        }

        public int add(int val) {
            minHeap.offer(val);
            if(minHeap.size()>k) minHeap.poll();
            return minHeap.peek();
        }
    }
}