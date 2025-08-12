package Heap_priority_queue;


import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode_1353 {
        public static void main(String[] args) {
            Leetcode_1353 app = new Leetcode_1353();
            int[][] events = {{1,2},{2,3},{3,4},{1,2}};
            System.out.println("max attend events possible : "+app.maxEvents(events));
        }
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->a[0]-b[0]);//sort ascending according to starting time

        int day = 0,n=events.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int attend  = 0,index=0;
        while (!minHeap.isEmpty() || index<n){
            if (minHeap.isEmpty())  day = events[index][0];
            while (index<n && events[index][0]<=day)  minHeap.offer(events[index++][1]); //as long as starting day is <= day add finish time to heap

            minHeap.poll(); //attend the event with early finish time.explore next day
            attend++;   day++;

            while (!minHeap.isEmpty() && minHeap.peek()<day) minHeap.poll(); //exclude events whose finish time is less than curr day
        }
        return attend;
    }
}