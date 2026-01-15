import java.util.Arrays;

public class Leetcode_164 {
    public static void main(String[] args) {
        Leetcode_164 app = new Leetcode_164();
//        int[] nums = {10};
        int[] nums = {3,6,9,1};
        System.out.println("maximum gap : "+app.maximumGap(nums));
    }

    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n==1) return 0;
//        Arrays.sort(nums);
        nums = mergeSort(nums);
        int left = 0;
        int right = nums[n-1]-nums[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (maxGap(mid,nums)<mid)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return right;
    }

    public int maxGap(int mid, int[] nums) {
        int maxDiff = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            maxDiff = Math.max(maxDiff,nums[i]-nums[i-1]);
        }
        return maxDiff;
    }


    public int[] mergeSort(int[] nums){//self written merge sort
        int n = nums.length;
        if (n==1) return nums;

        int mid = n/2;
        int[] leftHalf = new int[mid];  int[] rightHalf = new int[n-mid];
        for (int i = 0; i < mid; i++) leftHalf[i] = nums[i];
        for (int i = mid; i < n; i++) rightHalf[i-mid] = nums[i];

        leftHalf = mergeSort(leftHalf);
        rightHalf = mergeSort(rightHalf);

        return merge(leftHalf,rightHalf);
    }

    private int[] merge(int[] leftHalf,int[] rightHalf){
        int m = leftHalf.length,n= rightHalf.length;
        int s = m+n;
        int[] merged = new int[s];
        int i=0,j=0,k=0;
        while (i<m && j<n){
            if (leftHalf[i]<=rightHalf[j])
                merged[k++] = leftHalf[i++];
            else merged[k++] = rightHalf[j++];
        }
        while (i<m) merged[k++] = leftHalf[i++];
        while (j<n) merged[k++] = rightHalf[j++];

        return merged;
    }
}