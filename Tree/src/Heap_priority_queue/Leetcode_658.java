package Heap_priority_queue;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode_658 {
    public static void main(String[] args) {
        Leetcode_658 app = new Leetcode_658();
//        int[] arr = {1,2,3,4,5};int k = 4, x = 3;
        int[] arr = {1,1,2,3,4,5};int k = 4, x = -1;
        System.out.println("k closest numbers : "+ app.findClosestElements(arr,k,x));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b)->b.distance==a.distance? b.val-a.val: b.distance-a.distance);
        for (int num : arr) {//push pairs based on distance, if tie by value
            maxHeap.offer(new Pair(Math.abs(num-x),num));
            if (maxHeap.size()>k) maxHeap.poll();
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        while (!maxHeap.isEmpty()){//push just values, to sort them
            Pair pair = maxHeap.poll();
            minHeap.offer(pair.val);
        }
        List<Integer> elements = new ArrayList<>(); //after sorting, collect inside a list
        while (!minHeap.isEmpty()) elements.add(minHeap.poll());
        return elements;
    }
    class Pair{
        int distance,val;
        public Pair(int distance, int val) {this.distance = distance;this.val = val;}
    }
}