import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Leetcode_2398 {
    public static void main(String[] args) {
        Leetcode_2398 app = new Leetcode_2398();
//        int[] chargeTime = {8,76,74,9,75,71,71,42,15,58,88,38,56,59,10,11}; int[] runningCosts = {1,92,41,63,22,37,37,8,68,97,39,59,45,50,29,37}; long budget = 412;
//        int[] chargeTime = {11,12,74,67,37,87,42,34,18,90,36,28,34,20}; int[] runningCosts = {18,98,2,84,7,57,54,65,59,91,7,23,94,20}; long budget = 937;
//        int[] chargeTime = {11,12,19}; int[] runningCosts = {10,8,7}; long budget = 19;
//        int[] chargeTime = {24,3,6,1,3}; int[] runningCosts = {5,2,1,3,4}; long budget = 25;
        int[] chargeTime = {3, 6, 1, 3, 4};int[] runningCosts = {2, 1, 3, 4, 5};long budget = 25;
        System.out.println("maximum robots within budget : "+app.maximumRobots(chargeTime,runningCosts,budget));
    }

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int left = 0;
        int right = chargeTimes.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(chargeTimes, runningCosts, budget, mid))
                left = mid + 1;
            else
                right = mid - 1;
        }
        return right;
    }

    public boolean check(int[] chargeTimes, int[] runningCosts, long budget, int num) {
        long sum = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < chargeTimes.length; i++) {
            while (!deque.isEmpty() && chargeTimes[i] >= chargeTimes[deque.peekLast()]) deque.pollLast();//remove greater elements from last
            while (!deque.isEmpty() && i - deque.peekFirst() >= num) deque.pollFirst(); //remove from fast, if window out
            if (i >= num) sum -= runningCosts[i - num];

            deque.addLast(i);
            sum += runningCosts[i];
            if (i >= num - 1 && chargeTimes[deque.peekFirst()] + num * sum <= budget) {
                return true;
            }
        }
        return false;
    }
}