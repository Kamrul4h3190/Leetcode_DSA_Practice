package Heap_priority_queue;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode_1942 {
    public static void main(String[] args) {
        Leetcode_1942 app = new Leetcode_1942();
        int[][] times = {{1,4},{2,3},{4,6}};int targetFriend = 1;
        System.out.println("closest numbered chair : "+ app.smallestChair(times,targetFriend));
    }

    public int smallestChair(int[][] times, int targetFriend) {
        int targetStart = times[targetFriend][0];
        Arrays.sort(times,(a,b)->a[0]-b[0]);//sort based on starting time

        PriorityQueue<Integer> chairs = new PriorityQueue<>();//min heap for chairs
        for (int i = 0; i < times.length; i++) chairs.offer(i);//min numbered chair on top

        PriorityQueue<int[]> bookings = new PriorityQueue<>((a,b)->a[0]-b[0]);//for managing bookings
        for (int[] time : times) {//book or release chairs
            while (!bookings.isEmpty() && bookings.peek()[0] <= time[0])//while current start time <= bookings end time
                chairs.offer(bookings.poll()[1]); //release
            if (time[0] == targetStart) break;
            bookings.offer(new int[]{time[1], chairs.poll()});//book
        }
        return chairs.peek();
    }
}