import java.util.HashMap;
import java.util.Map;

public class Leetcode_873 {
    public static void main(String[] args) {
        Leetcode_873 app = new Leetcode_873();
//        int[] arr = {1,2,3,4,5};
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println("max fibonacci length : "+ app.lenLongestFibSubseq(arr));
    }
    public int lenLongestFibSubseq(int[] arr) {
        n = arr.length; memFibLen = new int[n][n];
        locations = new HashMap<>();
        for (int i = 0; i < n; i++) locations.put(arr[i],i );

        int maxFibLen = 0; //nums[i]+nums[j] = nums[k] ,hence nums[i] = nums[k]-nums[j]
        for (int j = 1; j <n ; j++) { //explore fib serieses ending at j and k . i will be found from the locations.
            for (int k = j+1; k <n ; k++) {
                int fibLen = exploreFib(j,k,arr);
                maxFibLen = Math.max(maxFibLen,fibLen);
            }
        }
        return maxFibLen >=3 ? maxFibLen : 0;
    }
    int[][] memFibLen; int n;
    Map<Integer,Integer> locations;
    private int exploreFib(int j,int k,int[]arr){
        if (memFibLen[j][k]!=0) return memFibLen[j][k];

        int num_i = arr[k]-arr[j];
        int location_i = locations.getOrDefault(num_i,-1);
        if (location_i!=-1 && location_i<j)
            return memFibLen[j][k] = 1+exploreFib(location_i,j,arr);

        return memFibLen[j][k] = 2; //at least j,k is ok, hence len 2 . This may lead to invalid(0 fib sequences)
    }
}