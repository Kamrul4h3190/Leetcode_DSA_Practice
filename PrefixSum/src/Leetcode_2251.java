import java.util.*;

public class Leetcode_2251 {
    public static void main(String[] args) {
        Leetcode_2251 app = new Leetcode_2251();
//        int[][] flowrs = {{21,34},{17,37},{23,43},{17,46},{37,41},{44,45},{32,45}}; int[] people = {31,41,10,12};
        int[][] flowrs = {{19,37},{19,38},{19,35}}; int[] people = {6,7,21,1,13,37,5,37,46,43};
//        int[][] flowrs = {{1,10},{3,3}}; int[] people = {3,3,2};
//        int[][] flowrs = {{1,6},{3,7},{9,12},{4,13}}; int[] people = {2,3,7,11};
        System.out.println(Arrays.toString(app.fullBloomFlowers(flowrs, people)));
    }
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        Map<Integer,Integer> timeFreqMap = new TreeMap<>();
        for (int[] flower : flowers) {//track blooming frequencies with time in an ordered map. sorted based on time
            int bloom = flower[0]; int close = flower[1];
            timeFreqMap.put(bloom,timeFreqMap.getOrDefault(bloom,0)+1);
            close++;
            timeFreqMap.put(close,timeFreqMap.getOrDefault(close,0)-1);
        }

        int sum=0; //build the prefix sum array, This will be used as line sweep
        List<Integer[]> prefixSum = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : timeFreqMap.entrySet()) {
            int time = entry.getKey();
            sum += entry.getValue();
            prefixSum.add(new Integer[]{time,sum});
        }

        int[] bloomsForPeople = new int[people.length];//for each people's entry time find number of bloomed flowers with binary search
        for (int i = 0; i < bloomsForPeople.length; i++) {
            int entryTime = people[i];
            if (entryTime <prefixSum.getFirst()[0] || entryTime>=prefixSum.getLast()[0]) continue; //lowest and highest blooming time boundary check
            bloomsForPeople[i] = upperBound(entryTime,prefixSum);
        }
        return bloomsForPeople;
    }
    private int upperBound(int targetTime,List<Integer[]> prefixSum){ //<=tagetTime
        int left = 0,right = prefixSum.size()-1;
        while (left<right){
            int mid = left + Math.ceilDiv((right-left),2);

            Integer[] pair = prefixSum.get(mid);

            if (pair[0]>targetTime) right = mid-1;
            else left = mid;

            if (pair[0]==targetTime) right = left;
        }
        return prefixSum.get(left)[1];
    }
}