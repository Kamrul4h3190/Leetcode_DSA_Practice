import java.util.ArrayList;
import java.util.List;

public class Leetcode_2223 {
    public static void main(String[] args) {
        Leetcode_2223 app = new Leetcode_2223();
        String s = "babab";
        System.out.println("sum of scores :"+app.sumScores(s));
    }
    public long sumScores(String s) {
        int[] zScore = zScore(s.toCharArray());
        long sum = s.length();
        for (long num :zScore)
            sum+=num;
        return sum;
    }
    private int[] zScore(char[] s){
        int n = s.length;   int[] zScore = new int[n];
        int left=0,right=0;
        for (int k = 1; k < n; k++) {
            if (k>right){
                left = right = k;
                while (right<n && s[right] == s[right-left])
                    right++;
                zScore[k] = right-left; //ZScore is the amount of prefix matching portion
                right--;
            }else {
                int k1 = k-left;        //within Z Box
                if (k+zScore[k1]<=right)
                    zScore[k] = zScore[k1];
                else {//outside z box, find next matches starting from here
                    left = k;
                    while (right<n && s[right] == s[right-left])
                        right++;
                    zScore[k] = right-left;
                    right--;
                }
            }
        }
        return zScore;
    }
}
