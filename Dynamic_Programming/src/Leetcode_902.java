import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Leetcode_902 {
    public static void main(String[] args) {
        Leetcode_902 app = new Leetcode_902();
        String[] digits = {"1","4","9"};    int n = 1000000000;
//        String[] digits = {"1","3","5","7"};    int n = 100;
        System.out.println("total nonzero numbers upto n : "+ app.atMostNGivenDigitSet(digits,n));
    }
    public int atMostNGivenDigitSet(String[] digits,int n) {
        String number = Integer.toString(n);
        for (String digit : digits) //mark the existing numbers by setting the bits to 1;
            mask |= (1 << (Integer.parseInt(digit)));
        return solve(0,true,true,number)-1;//-1, to exclude 0 from the count
    }
    Map<String,Integer> state_Counts = new HashMap<>();
    int mask = 0;
    private int solve(int index,boolean tight, boolean leadingZero,String number){
        if (index==number.length()) return 1;
        String state = index+(tight ?"T":"F")+(leadingZero ? "T":"F");//total [length(number)][2][2] states
        if (state_Counts.containsKey(state)) return state_Counts.get(state);

        int countNumbers = 0;
        int limit = tight ? number.charAt(index)-'0' : 9;
        for (int digit = 0; digit <= limit; digit++) {
            if (leadingZero && digit==0)//handle leading zero case separately
                countNumbers += solve(index+1, false, true, number);
            else {//core logic
                if ((mask>>digit & 1) != 1) continue;//if the digit is not present in digits ,skip
                countNumbers += solve(index+1, tight && digit==limit, false, number);
            }
        }

        state_Counts.put(state,countNumbers);
        return countNumbers;
    }
}