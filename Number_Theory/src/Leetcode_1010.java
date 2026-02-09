import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode_1010 {
    public static void main(String[] args) {
        Leetcode_1010 app = new Leetcode_1010();
        int[] time = {60,60,60};
        System.out.println("pairs : "+ app.numPairsDivisibleBy60(time));
    }
    public int numPairsDivisibleBy60(int[] time) {
        int pairs = 0;
        Map<Integer,Integer> remainderCount  = new HashMap<>();
        for (int t : time) {
            int r1 = t%60;
            int r2 = 60-r1; //r1+r2 = 60;
            if (remainderCount.containsKey(r2))
                pairs+= remainderCount.get(r2);
            if (r1==0)//if r1=0 then r2 = 60 or vice versa
                remainderCount.put(60,remainderCount.getOrDefault(60,0)+1);
            else
                remainderCount.put(r1,remainderCount.getOrDefault(r1,0)+1);
        }
        return pairs;
    }
}
