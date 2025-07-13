import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Leetcode_1326 {
    public static void main(String[] args) {
        Leetcode_1326 app = new Leetcode_1326();
//        int n = 5;int[] ranges = {3,4,1,1,0,0};//1
        int n = 4;int[] ranges = {2,0,0,0,2};//2
//        int n = 5;int[] ranges = {2,3,0,1,1,0};//2
//        int n = 3;int[] ranges = {0,0,0,0};//-1
        System.out.println("minimum taps to water the garden : "+app.minTaps(n,ranges));
    }
    public int minTaps(int n, int[] ranges) {
        int[][] spans = new int[n+1][2];
        for (int i = 0; i < spans.length; i++) {
            int left = Math.max(0,i-ranges[i]);
            int right = Math.min(n,i+ranges[i]);

            spans[i][0] = left;
            spans[i][1] = right;
        }
        Arrays.sort(spans,(a,b)->a[0]-b[0]);
        memTaps = new HashMap<>();

        int minTaps = dynamicTaps(0,0,n,spans);

        return minTaps>=1000000007 ? -1 : minTaps;
    }
    HashMap<String,Integer> memTaps ;
    private int dynamicTaps(int idx, int rightMax,int n,int[][] spans){
        if (idx>n){
            if (rightMax>=n) return 0;
            return 1000000007;
        }
        if (rightMax>=n) return 0;
        if ( spans[idx][0]>rightMax) return 1000000007;

        String key = idx+"-"+rightMax;
        if (memTaps.containsKey(key)) return memTaps.get(key);

        int tap_open = 0,keep_close = 0;
        tap_open = 1 + dynamicTaps(idx+1, Math.max(rightMax,spans[idx][1]),n,spans);
        keep_close = dynamicTaps(idx+1, rightMax,n,spans);

        int minTaps = Math.min(tap_open,keep_close);
        memTaps.put(key,minTaps);return minTaps;
    }
}