import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode_368 {
    public static void main(String[] args) {
        Leetcode_368 app = new Leetcode_368();
//        int[] group = {2,3,5},profit ={6,7,8};  int n=10,minProfit=5;
        int[] nums = {5,9,18,54,108,540,90,180,360,720};
//        int[] nums = {4,15,3,32,64};
        System.out.println("largest divisible LIS : "+app.largestDivisibleSubset(nums));
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        n= nums.length;     memLISSize = new int[n];
        Arrays.sort(nums);      largestLIS = new ArrayList<>();
        exploreSequence(0,-1,new ArrayList<>(),nums);
        return largestLIS;
    }
    List<Integer> largestLIS;    int n;
    int[]   memLISSize;
    private void exploreSequence(int curr,int prev,List<Integer> lis,int[] nums){
        if (curr>=n){
            if (lis.size()>largestLIS.size()) largestLIS = new ArrayList<>(lis);
            return;
        }

        if (prev==-1 || lis.size()>memLISSize[curr] && nums[curr]%nums[prev]==0){//take
            memLISSize[curr] = lis.size();
            lis.add(nums[curr]);
            exploreSequence(curr+1, curr, lis, nums);
            lis.removeLast();
        }

        exploreSequence(curr+1, prev, lis, nums);//skip
    }
}