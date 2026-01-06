import java.util.HashMap;
import java.util.Map;

public class Leetcode_233 {
    public static void main(String[] args) {
        Leetcode_233 app = new Leetcode_233();
        int n=824883294;
//        int n=23;
        System.out.println("number of 1,s upto n : "+ app.countDigitOne(n));
    }
    public int countDigitOne(int n) {
        if (n==0) return 0;
        String number = Integer.toString(n);
        return solve(0,true,0,number);
    }
    Map<String,Integer> idx1Counts = new HashMap<>();
    private int solve(int i,boolean tight, int count1s,String number){
        if (i==number.length()) return count1s;
        String key = i+(tight ?"T":"F")+count1s;
        if (idx1Counts.containsKey(key)) return idx1Counts.get(key);

        int total1s = 0;
        int limit = tight ? number.charAt(i)-'0' : 9;
        for (int digit = 0; digit <= limit; digit++) {//pass custom parameters, not edit globally
            total1s += solve(i+1,  tight && digit==limit, digit==1 ? 1+count1s: count1s , number);
        }

        idx1Counts.put(key,total1s);
        return total1s;
    }
}