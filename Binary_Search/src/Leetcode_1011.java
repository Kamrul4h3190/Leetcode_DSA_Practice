import java.util.Arrays;
import java.util.Map;

public class Leetcode_1011 {
    public static void main(String[] args) {
        Leetcode_1011 app = new Leetcode_1011();
        int[] weights = {1,2,3,4,5,6,7,8,9,10}; int days = 5;
        System.out.println("minimum ship capacity : "+ app.shipWithinDays(weights,days));
    }
    public int shipWithinDays(int[] weights, int days) {
//        int left = Arrays.stream(weights).max().getAsInt(); //slower than manual
//        int right = Arrays.stream(weights).sum();
        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(left,w);
            right += w;
        }
        while (left<right){
            int mid = left+(right-left)/2;
            if (shipWithinDays(mid,days,weights))
                right = mid;
            else
                left = mid+1;
        }
        return left; //converged to mid minimum(ship capacity)
    }
    private boolean shipWithinDays(int shipCapacity, int daysAllowed,int[] weights){
        int days = 1, loaded = 0;
        for (int w : weights) {
            if (loaded+w<=shipCapacity) //load if space available
                loaded+=w;
            else {
                days++;//new day stated, days count will increase
                if (days>daysAllowed) return false; //exceeded allocated days, early stop
                loaded = w; //new day , load this package(w)
            }
        }
        return true;
    }
}