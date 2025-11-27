import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Leetcode_1094 {
    public static void main(String[] args) {
        Leetcode_1094 app = new Leetcode_1094();
        int[][] trips= {{2,1,5},{3,3,7}}; int capacity=4;
        System.out.println("All passenger drop off : "+app.carPooling(trips,capacity));
    }
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer,Integer> passengerMap = new TreeMap<>();//<Location,passengerMap> , location wise sorted
        for (int[] trip : trips) {
            int passenger,from,to;
            passenger = trip[0]; from = trip[1]; to = trip[2];
            passengerMap.put(from,passengerMap.getOrDefault(from,0)+passenger);
            passengerMap.put(to,passengerMap.getOrDefault(to,0)-passenger);
        }
        int currPassengers = 0;
        for (int p :passengerMap.values()){
            currPassengers += p;
            if (currPassengers>capacity) return false;
        }
        return true;
    }
}