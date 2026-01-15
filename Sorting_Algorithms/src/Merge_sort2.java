import java.util.Arrays;

public class Merge_sort2 {
    public static void main(String[] args) {
        Merge_sort2 sort = new Merge_sort2();
//        int[] nums1 = {2,4,6,8};
//        int[] nums2 = {1,3,4};
        int[] nums = {2,8,3,5,7,3,6};
//        int[] nums = {6,3,9,5,2,8};
//        sort.mergeSort(nums);
        System.out.println(Arrays.toString(sort.mergeSort(nums)));
//        System.out.println(Arrays.toString(sort.merge(nums1,nums2)));
    }

    public int[] mergeSort(int[] nums){
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