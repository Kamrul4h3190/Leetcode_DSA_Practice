import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode_436 {
    public static void main(String[] args) {
        Leetcode_436 app = new Leetcode_436();
        int[][] intervals = {{-6,-5},{-5,-2},{1,4},{2,3},{3,4}};
//        int[][] intervals = {{1,4},{2,3},{3,4}};
//        int[][] intervals = {{1,2}};
//        int[][] intervals = {{3,4},{2,3},{1,2}};
        System.out.println("right intervals : "+ Arrays.toString(app.findRightInterval(intervals)));
    }
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        List<Integer[]> sortedIntervals = new ArrayList<>();
        for (int i = 0; i < n; i++)//transfer to a new list, Preserve original positions of intervals
            sortedIntervals.add(new Integer[]{intervals[i][0] , intervals[i][1], i});//start,end,i
        Collections.sort(sortedIntervals , (a,b)-> a[0]-b[0]);//sort based on start

        int[] rightIntervals = new int[n];
        for (int i = 0; i < n; i++) {//for each interval find right interval. O(NlogN)
            int originalIndex = sortedIntervals.get(i)[2];
            int rightIndex = lowerBound(i,sortedIntervals);//find the relative left index
            rightIntervals[originalIndex] = rightIndex;//place the original position of the left interval
        }

        return rightIntervals;
    }
    private int lowerBound(int start, List<Integer[]> intervals){
        Integer[] startInterval = intervals.get(start);
        int n = intervals.size();
        int left = start;   int right = n-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (intervals.get(mid)[0] >= startInterval[1])// curr_start>=starting_end
                right = mid-1;
            else left = mid+1;
        }

        if (left>=n) return -1;
        return intervals.get(left)[2]; //return the original index of the returned left interval
    }
}