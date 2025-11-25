import java.util.HashMap;
import java.util.Map;

public class Leetcode_303 {
    public static void main(String[] args) {
//        Leetcode_303 app = new Leetcode_303();
//        int[] arr = {1,2,3,4,5};
        int[] arr = {1,2,3,4,5,6,7,8};  int left = 2,right = 5;
        NumArray numArray = new NumArray(arr);
        System.out.println("range sum : "+ numArray.sumRange(left,right));
    }
    static class NumArray {
        int[] prefixSum;
        public NumArray(int[] nums) {//build the prefix sums initially
            prefixSum = nums;
            for (int i = 1; i < nums.length; i++) {
                prefixSum[i] += prefixSum[i-1];
            }
        }

        public int sumRange(int left, int right) { //O(1) lookup
            if (left==0) return prefixSum[right];
            return prefixSum[right]-prefixSum[left-1];
        }
    }
}