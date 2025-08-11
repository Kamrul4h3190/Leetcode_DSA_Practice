package Heap_priority_queue;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class leetcode_2462 {
    public static void main(String[] args) {
        leetcode_2462 app = new leetcode_2462();
        int[] costs = {17,12,10,2,7,2,11,20,8};int k = 3, candidates = 4;
        System.out.println("total hiring cost : "+app.totalCost(costs,k,candidates));
    }
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> leftQueue = new PriorityQueue<>((a,b)->a-b);//default ascending sort
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>((a,b)->a-b);
        int i=0,j= costs.length-1;

        long cost = 0;int hired=0;
        while (hired++<k){// or (k-->0), hire k workers,0 indexed
            while (leftQueue.size()<candidates && i<=j) leftQueue.offer(costs[i++]);//i<=j for adding from the right side, after left part is done
            while (rightQueue.size()<candidates && i<=j) rightQueue.offer(costs[j--]);

            int leftMin = !leftQueue.isEmpty() ? leftQueue.peek() : Integer.MAX_VALUE;
            int rightMin = !rightQueue.isEmpty() ? rightQueue.peek() : Integer.MAX_VALUE;

            if (leftMin<=rightMin ) cost += leftQueue.poll();//if equal ,break tie by taking from leftQueue
            else cost+= rightQueue.poll();
        }
        return cost;
    }
}